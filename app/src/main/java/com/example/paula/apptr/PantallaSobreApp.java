package com.example.paula.apptr;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PantallaSobreApp extends AppCompatActivity {

    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_sobre_app);
        TextView textObjectiu = (TextView) findViewById(R.id.textObjectiuApp);
        textObjectiu.setText("COLORITECA és una aplicació dissenyada i desenvolupada per reconèixer els colors. Neix com a Treball de Recerca i amb l'objectiu de convertir-se en una eina d'ajuda que faciliti la identificació dels colors a aquelles persones que pateixen daltonisme o discromatòpsia.");
    }

    public void robaOnClick (View v){
        TextView textCanvi = (TextView)findViewById(R.id.textFacts);
        textCanvi.setText("El 90% dels daltònics demana ajuda a l'hora de comprar roba i el 88% té problemes a l'hora de triar què posar-se.");
    }

    public void colorsOnClick (View v){
        TextView textCanvi = (TextView)findViewById(R.id.textFacts);
        textCanvi.setText("La comunicació visual i gràfica d'avui en dia es basa principalment en els colors.");
        //Més del 90% de la comunicació d'avui en dia utilitza gràfics i recursos visuals basats en el color.
    }

    public void ledOnClick(View v){
        TextView textCanvi = (TextView)findViewById(R.id.textFacts);
        textCanvi.setText("La majoria de daltònics és incapaç de diferenciar els indicadors de llum LED, l'ús dels quals ha augmentat amb les noves tecnologies.");
    }

    public void pastillaOnClick (View v){
        TextView textCanvi = (TextView)findViewById(R.id.textFacts);
        textCanvi.setText("El color s'utilitza sovint com a factor de diferenciació i identificació en l'indústria farmacèutica.");
    }
}
