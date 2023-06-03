package com.example.classarrange2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.classarrange2.databinding.ActivityVisualizarBinding;

public class visualizarActivity extends AppCompatActivity {

    private ActivityVisualizarBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVisualizarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.visuHorarios.setOnClickListener(
                v -> {
                    showFragment(new visuHorarioFragment());
                }
        );

        binding.visuDisciplinas.setOnClickListener(
                v -> {
                    showFragment(new visuDisciplinasFragment());
                }
        );

    }

    private void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }

}
