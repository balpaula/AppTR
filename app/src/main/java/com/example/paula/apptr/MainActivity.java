package com.example.paula.apptr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void botoElsColorsOnClick(View v){
        //Canviar de pantalla en clicar el botó, de la pàgina inicial a Els Colors
        Intent passarPantalla = new Intent(this, pantallaElsColors.class);
        startActivity(passarPantalla);
    }

    public void botoComFuncionaOnClick(View v){
        //Canviar de pantalla en clicar el botó, de la pàgina inicial a Com Funciona?
        Intent passarPantalla = new Intent(this,pantallaComFunciona3.class);
        startActivity(passarPantalla);
    }

    public void botoSobreAppOnClick(View v){
        //Canviar de pantalla en clicar el botó, de la pàgina inicial a Sobre l'app
        Intent passarPantalla = new Intent(this, PantallaSobreApp.class);
        startActivity(passarPantalla);
    }

    public void botoFerFoto(View v){
        //Canviar de pantalla en clicar el botó, de la pàgina inicial a Detecció Colors
        Intent passarPantalla = new Intent(this, deteccioColors.class);
        startActivity(passarPantalla);
    }



}
