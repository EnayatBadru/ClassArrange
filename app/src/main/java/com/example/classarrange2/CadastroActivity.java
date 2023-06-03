package com.example.classarrange2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.classarrange2.databinding.ActivityCadastroBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CadastroActivity extends AppCompatActivity {
    private ActivityCadastroBinding binding;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCadastroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        iniciaToolbar();

        mAuth = FirebaseAuth.getInstance();

        binding.btnCriarConta.setOnClickListener(
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
        String senha = binding.editSenha.getText().toString().trim();

        if(!usuario.isEmpty()){
            if(!senha.isEmpty()){

                binding.progressBar.setVisibility(View.VISIBLE);

                criarContaFirebase(usuario,senha);

            }else{
                Toast.makeText(this, "Informe uma senha", Toast.LENGTH_LONG).show();
            }

        }else{
            Toast.makeText(this, "Informe seu usuario", Toast.LENGTH_LONG).show();
        }

    }

    private void criarContaFirebase(String usuario, String senha){
        mAuth.createUserWithEmailAndPassword(
                usuario, senha
        ).addOnCompleteListener(task -> {
            if(task.isSuccessful()){

                finish();
                startActivity(new Intent(this, MainActivity.class));

            }else{
                binding.progressBar.setVisibility(View.GONE);
                Toast.makeText(this, "Ocorreu um erro", Toast.LENGTH_LONG).show();
            }
        });
    }

}