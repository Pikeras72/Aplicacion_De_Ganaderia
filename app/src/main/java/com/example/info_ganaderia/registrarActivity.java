package com.example.info_ganaderia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class registrarActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    private EditText correo, contrasena, confirmarContrasena;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        correo = findViewById(R.id.correoRegistro);
        contrasena = findViewById(R.id.contrasenaRegistro);
        confirmarContrasena = findViewById(R.id.confirmarContrasenaRegistro);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    public void registrarUsuario(View view){
        if (this.contrasena.getText().toString().equals(confirmarContrasena.getText().toString().trim()) && contrasena.getText().toString().length() >= 8){
            mAuth.createUserWithEmailAndPassword(this.correo.getText().toString().trim(),this.contrasena.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(getApplicationContext(), "User Created", Toast.LENGTH_SHORT).show();
                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(i);
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(getApplicationContext(), "Authentication failed.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }else if (this.contrasena.getText().toString().trim().length() >= 8){
            Toast.makeText(this,"Las contraseñas no coinciden",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"La contraseña debe tener al menos 8 carácteres",Toast.LENGTH_SHORT).show();
        }
    }
}