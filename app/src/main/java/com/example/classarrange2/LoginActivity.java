package com.example.classarrange2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.classarrange2.databinding.ActivityLoginBinding;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth = FirebaseAuth.getInstance();

        binding.textCadastro.setOnClickListener(
                v -> {
                    startActivity(new Intent(this, CadastroActivity.class));
                }
        );

        binding.textRecuperaConta.setOnClickListener(
                v->{
                    startActivity(new Intent(this, RecuperaContaActivity.class));
                }
        );

        binding.btnLogin.setOnClickListener(
                v->{
                    validaDados();
                }
        );


    }


    private void validaDados(){
        String usuario = binding.editUsuario.getText().toString().trim();
        String senha = binding.editSenha.getText().toString().trim();

        if(!usuario.isEmpty()){
            if(!senha.isEmpty()){

                binding.progressBar.setVisibility(View.VISIBLE);

                loginFirebase(usuario,senha);

            }else{
                Toast.makeText(this, "Informe uma senha", Toast.LENGTH_LONG).show();
            }

        }else{
            Toast.makeText(this, "Informe seu usuario", Toast.LENGTH_LONG).show();
        }

    }

    private void loginFirebase(String usuario, String senha){
        mAuth.signInWithEmailAndPassword(
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