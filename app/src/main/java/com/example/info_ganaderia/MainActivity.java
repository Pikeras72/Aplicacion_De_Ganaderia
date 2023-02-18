package com.example.info_ganaderia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irAIniciarSesion(View view){
        Intent i = new Intent(this, IniciarSesionActivity.class);
        startActivity(i);
    }

    public void irARegistrarse(View view){
        Intent i = new Intent(this, registrarActivity.class);
        startActivity(i);
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
}