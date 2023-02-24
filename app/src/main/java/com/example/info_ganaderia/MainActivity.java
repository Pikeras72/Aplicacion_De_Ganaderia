package com.example.info_ganaderia;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;
    private Button login, registrarse,cerrar_sesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.iniciarSesionPantalla);
        registrarse = findViewById(R.id.registrarPantalla);
        cerrar_sesion = findViewById(R.id.cerrarSesionPantalla);

        auth =FirebaseAuth.getInstance();
        if(auth.getCurrentUser()!= null){
            login.setVisibility(View.GONE);
            registrarse.setVisibility(View.GONE);
            cerrar_sesion.setVisibility(View.VISIBLE);
        }
    }

    public void irAIniciarSesion(View view){
        Intent i = new Intent(this, IniciarSesionActivity.class);
        startActivity(i);
    }

    public void irARegistrarse(View view){
        Intent i = new Intent(this, registrarActivity.class);
        startActivity(i);
    }

    public void cerrarSesion(View view){
        auth.signOut();
        if(auth.getCurrentUser()== null){
            login.setVisibility(View.VISIBLE);
            registrarse.setVisibility(View.VISIBLE);
            cerrar_sesion.setVisibility(View.GONE);
        }
    }

    public void irANoticias(View view){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://elpais.com/noticias/ganaderia/"));
        startActivity(i);
    }
    public void irATipos(View view){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://economipedia.com/definiciones/tipos-de-ganaderia.html"));
        startActivity(i);
    }
    public void irARazas(View view){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mapa.gob.es/es/ganaderia/temas/zootecnia/razas-ganaderas/razas/catalogo-razas/"));
        startActivity(i);
    }
    public void irAConsejos(View view){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://milkmaxfrio.com.ec/5-tips-para-tener-una-ganaderia-exitosa/"));
        startActivity(i);
    }

    public void irALibros(View view){
        if (auth.getCurrentUser() == null){
            AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
            builder1.setMessage("Debes estar Registrado o Iniciar Sesión para acceder");
            builder1.setCancelable(true);
            builder1.setPositiveButton(
                    "OK",(dialog,id)->{dialog.cancel();});
            AlertDialog alertDialog = builder1.create();
            alertDialog.show();
        }else{
            Intent i = new Intent(this, LibrosActivity.class);
            startActivity(i);
        }
    }
}