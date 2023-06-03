package com.example.classarrange2;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.classarrange2.databinding.ActivityMainBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
    private Fragment currentFragment; // Fragmento atualmente exibido

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomNavigationView.setBackground(null);

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.home:
                    selectedFragment = new HomeFragment();
                    break;

                case R.id.chat:
                    selectedFragment = new ChatFragment();
                    break;

                case R.id.horario:
                    selectedFragment = new HorarioFragment();
                    break;

                case R.id.logout:
                    selectedFragment = new LogoutFragment();
                    break;
            }

            if (selectedFragment != null && selectedFragment != currentFragment) {
                replaceFragment(selectedFragment);
                currentFragment = selectedFragment;
            }

            return true;
        });

        binding.fab.setOnClickListener(
                v->{
                    showBottomDialog();
                }
        );

        // Define o fragmento inicial
        Fragment initialFragment = new HomeFragment();
        currentFragment = initialFragment;
        replaceFragment(initialFragment);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Remove o fragmento atual da exibição
        if (currentFragment != null) {
            fragmentTransaction.remove(currentFragment);
        }

        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

    private void showBottomDialog(){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomsheet_layout);

        LinearLayout horarioLayout = dialog.findViewById(R.id.layoutHorario);
        LinearLayout avaliacaoLayout = dialog.findViewById(R.id.layoutAvaliacoes);
        LinearLayout livrosLayout = dialog.findViewById(R.id.layoutLivros);
        ImageView cancelButton = dialog.findViewById(R.id.cancelButton);

        horarioLayout.setOnClickListener(
                v->{
                    dialog.dismiss();
                    Toast.makeText(this, "Upload a Horarios is clicked", Toast.LENGTH_SHORT).show();
                }
        );
        avaliacaoLayout.setOnClickListener(
                v->{
                    dialog.dismiss();
                    Toast.makeText(this, "Upload a avaliacao is clicked", Toast.LENGTH_SHORT).show();
                }
        );
        livrosLayout.setOnClickListener(
                v->{
                    dialog.dismiss();
                    Toast.makeText(this, "Upload a books is clicked", Toast.LENGTH_SHORT).show();
                }
        );
        cancelButton.setOnClickListener(
                v->{
                    dialog.dismiss();
                }
        );

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }
}
