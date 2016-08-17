package com.example.paula.apptr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class pantallaElsColors extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_els_colors);
    }

    public void botoColorsPrimarisOnClick(View v) {
        ImageView img = (ImageView)findViewById(R.id.imageView);
        img.setImageResource(R.drawable.colorsprimaris);
    }

    public void botoColorsSecundarisOnClick(View v) {
        ImageView img = (ImageView)findViewById(R.id.imageView);
        img.setImageResource(R.drawable.colorssecundaris);
    }

    public void botoColorsTerciarisOnClick(View v) {
        ImageView img = (ImageView)findViewById(R.id.imageView);
        img.setImageResource(R.drawable.colorsterciaris);
    }

}
