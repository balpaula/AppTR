package com.example.paula.apptr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class pantallaInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_info);
    }

    public void botoElsColorsOnClick(View v){
        //Canviar de pantalla en clicar el botó, de la pàgina info a Els Colors Invisibles
        Intent passarPantalla = new Intent(this, pantallaElsColors.class);
        startActivity(passarPantalla);
        this.finish();
    }

    public void botoSobreAppOnClick(View v){
        //Canviar de pantalla en clicar el botó, de la pàgina info a Sobre l'app
        Intent passarPantalla = new Intent(this, PantallaSobreApp.class);
        startActivity(passarPantalla);
        this.finish();
    }

}