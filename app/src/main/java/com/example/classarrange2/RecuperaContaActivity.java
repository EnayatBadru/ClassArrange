package com.example.classarrange2;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.classarrange2.databinding.ActivityRecuperaContaBinding;
import com.google.firebase.auth.FirebaseAuth;

public class RecuperaContaActivity extends AppCompatActivity {
    private ActivityRecuperaContaBinding binding;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecuperaContaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        iniciaToolbar();

        mAuth = FirebaseAuth.getInstance();

        binding.btnRecuperarConta.setOnClickListener(
                v->{
                    validaDados();
                }
        );

    }

    private void iniciaToolbar(){
        Toolbar toolbar = binding.toolbar2;
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
    }

    private void validaDados(){
        String usuario = binding.editUsuario.getText().toString().trim();

        if(!usuario.isEmpty()){
            binding.progressBar.setVisibility(View.VISIBLE);

            recuperarContaFirebase(usuario);
        }else{
            Toast.makeText(this, "Informe seu usuario", Toast.LENGTH_LONG).show();
        }

    }

    private void recuperarContaFirebase(String usuario){
        mAuth.sendPasswordResetEmail(
                usuario
        ).addOnCompleteListener(task -> {
            if(task.isSuccessful()){
                Toast.makeText(this, "Já pode verificar seu usuario.", Toast.LENGTH_LONG).show();

            }else{
                Toast.makeText(this, "Ocorreu um erro", Toast.LENGTH_LONG).show();
            }
            binding.progressBar.setVisibility(View.GONE);
        });
    }
}