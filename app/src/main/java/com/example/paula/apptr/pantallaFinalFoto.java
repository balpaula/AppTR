package com.example.paula.apptr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class pantallaFinalFoto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_final_foto);
    }

    public void botoImatgeRecomencarOnClick(View v){
        //Canviar de pantalla en clicar el botó, de la pàgina final foto a la d'inici
        Intent passarPantalla = new Intent(this, MainActivity.class);
        startActivity(passarPantalla);
        this.finish();
    }

}
