package com.example.paula.apptr;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class deteccioColors extends Activity {



    static final int REQUEST_IMAGE_CAPTURE = 1;
    public ImageView imatge;
    private static final String TAG = "PantallaDeteccioColors";
    Bitmap bitMapImatge;
    float hue;
    float value;
    float sat;
    private ImageView plus;
    private PopupWindow popupWindow;
    private LayoutInflater layoutInflater;
    private RelativeLayout relativeLayout;
    int codiColorPopup;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Llevar el títol de l'activity
        /*requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
                */
        setContentView(R.layout.activity_deteccio_colors);

        //Agafem la imatge
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
        // this is the view on which you will listen for touch events
        final View touchView = findViewById(R.id.imatgeFoto);
        touchView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d(TAG, "Coordenades de la imatge : " +
                        "( " + String.valueOf(event.getX()) + " , " + String.valueOf(event.getY()) + " ) ");
                Matrix inverse = new Matrix();
                ((ImageView) v).getImageMatrix().invert(inverse);
                float[] touchPoint = new float[]{event.getX(), event.getY()};
                inverse.mapPoints(touchPoint);
                int xCoord = Integer.valueOf((int) touchPoint[0]);
                int yCoord = Integer.valueOf((int) touchPoint[1]);
                int color = bitMapImatge.getPixel(xCoord, yCoord);
                int green = Color.green(color);
                int blue = Color.blue(color);
                int red = Color.red(color);
                Log.d(TAG, "Colors: vermell: " + red + " verd: " + green + " blau: " + blue);
                float[] hsv = new float[3];
                Color.RGBToHSV(red, green, blue, hsv);
                //noms als floats
                hue = hsv[0];
                sat = hsv[1];
                value = hsv[2];

                Log.d(TAG, "Colors: hue: " + hsv[0] + " saturation: " + hsv[1] + " value: " + hsv[2]);

                plus = (ImageView) findViewById(R.id.plus);
                plus.setVisibility(plus.VISIBLE);
                relativeLayout = (RelativeLayout) findViewById(R.id.relative);

                plus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                        ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.popup, null);

                        popupWindow = new PopupWindow(container, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
                        popupWindow.showAtLocation(relativeLayout, Gravity.CENTER, 0, 0);

                        ImageView imatgeGammaCanvi = (ImageView)popupWindow.getContentView().
                                findViewById(R.id.imageGamma);

                        TextView textEnunciatColorComplementari = (TextView)popupWindow.getContentView().
                                findViewById(R.id.textColorComplementari);

                        TextView textRespostaCanvi = (TextView)popupWindow.getContentView().
                                findViewById(R.id.textResposta);

                        if (codiColorPopup == 0){
                            textRespostaCanvi.setVisibility(View.GONE);
                            textEnunciatColorComplementari.setVisibility(View.GONE);
                            imatgeGammaCanvi.setImageResource(R.drawable.gammacalida);
                        }else if (codiColorPopup == 10){
                            textRespostaCanvi.setVisibility(View.GONE);
                            textEnunciatColorComplementari.setVisibility(View.GONE);
                            imatgeGammaCanvi.setImageResource(R.drawable.gammafreda);
                        }else {
                            textRespostaCanvi.setVisibility(View.VISIBLE);
                            textEnunciatColorComplementari.setVisibility(View.VISIBLE);
                        }
                        if (codiColorPopup == 1){
                            textRespostaCanvi.setText("Lila");
                            imatgeGammaCanvi.setImageResource(R.drawable.gammacalida);
                        }
                        if (codiColorPopup == 2){
                            textRespostaCanvi.setText("Verd");
                            imatgeGammaCanvi.setImageResource(R.drawable.gammacalida);
                        }
                        if (codiColorPopup == 3){
                            textRespostaCanvi.setText("Taronja");
                            imatgeGammaCanvi.setImageResource(R.drawable.gammafreda);
                        }
                        if (codiColorPopup == 4){
                            textRespostaCanvi.setText("Blau");
                            imatgeGammaCanvi.setImageResource(R.drawable.gammacalida);
                        }
                        if (codiColorPopup == 5){
                            textRespostaCanvi.setText("Groc");
                            imatgeGammaCanvi.setImageResource(R.drawable.gammafreda);
                        }
                        if (codiColorPopup == 6){
                            textRespostaCanvi.setText("Vermell");
                            imatgeGammaCanvi.setImageResource(R.drawable.gammafreda);
                        }
                        if (codiColorPopup == 7){
                            textRespostaCanvi.setText("Blanc");
                            imatgeGammaCanvi.setImageResource(R.drawable.gammaneutra);
                        }
                        if (codiColorPopup == 8){
                            textRespostaCanvi.setText("Negre");
                            imatgeGammaCanvi.setImageResource(R.drawable.gammaneutra);
                        }
                        if (codiColorPopup == 9){
                            textRespostaCanvi.setVisibility(View.GONE);
                            textEnunciatColorComplementari.setVisibility(View.GONE);
                            imatgeGammaCanvi.setImageResource(R.drawable.gammaneutra);
                        }


                        container.setOnTouchListener(new View.OnTouchListener() {
                            @Override
                            public boolean onTouch(View v, MotionEvent event) {
                                popupWindow.dismiss();
                                return true;
                            }
                        });


                    }
                });

                TextView textToChange = (TextView) findViewById(R.id.textColor);

                if (value <= 0.300) {
                    textToChange.setText("NEGRE");
                    codiColorPopup = 7;
                }
                if (sat <= 0.20 && 0.800 <= value) {
                    textToChange.setText("BLANC");
                    codiColorPopup = 8;
                }
                if (sat <= 0.20 && 0.300 < value && value < 0.800) {
                    textToChange.setText("GRIS");
                    codiColorPopup = 9;
                }
                if (5 < hue && hue <= 45 && 0.20 < sat) {
                    if (0.650 < value) {
                        textToChange.setText("TARONJA");
                        codiColorPopup = 4;
                    }
                    if (0.300 < value && value <= 0.650) {
                        textToChange.setText("MARRÓ");
                        codiColorPopup = 0;
                    }
                }
                if (45 < hue && hue <= 90 && 0.20 < sat) {
                    if (0.650 < value) {
                        textToChange.setText("GROC");
                        codiColorPopup = 1;
                    }
                    if (0.300 < value && value <= 0.650) {
                        textToChange.setText("VERD OLIVA");//groc oliva? verd oliva? REVISAR
                        codiColorPopup = 10;
                    }
                }
                if (90 < hue && hue <= 165 && 0.20 < sat) {
                    if (0.500 < value) {
                        textToChange.setText("VERD");
                        codiColorPopup = 6;
                    }
                    if (0.300 < value && value <= 0.500) {
                        textToChange.setText("VERD FOSC");
                        codiColorPopup = 10;
                    }
                }
                if (165 < hue && hue <= 180 && 0.20 < sat) {
                    if (0.300 < value) {
                        textToChange.setText("TURQUESA");
                        codiColorPopup = 10;
                    }
                        //blau turquesa?cian? revisar

                    /* if (0.300<value && value<=0.750){
                        textToChange.setText("TURQUESA"); //MODIFICAR NOM
                    }
                    */
                }
                if (180 < hue && hue <= 220 && 0.20 < sat) {
                    if (0.750 < value) {
                        textToChange.setText("BLAU CLAR");
                        codiColorPopup = 10;
                    }
                    if (0.500 < value && value <= 0.750) {
                        textToChange.setText("BLAU");
                        codiColorPopup = 3;
                    }
                    if (0.300 < value && value <= 0.500) {
                        textToChange.setText("BLAU FOSC");
                        codiColorPopup = 10;
                    }
                }
                if (220 < hue && hue <= 260 && 0.20 < sat) {
                    if (0.650 < value) {
                        textToChange.setText("BLAU");
                        codiColorPopup = 3;
                    }
                    if (0.300 < value && value <= 0.650) {
                        textToChange.setText("BLAU FOSC");//blau marí? revisar
                        codiColorPopup = 10;
                    }
                }
                if (260 < hue && hue <= 285 && 0.20 < sat) {
                    if (0.300 < value) {
                        textToChange.setText("LILA");
                        codiColorPopup = 5;
                    }
                    /*if(0.300<value && value<=0.650){
                        textToChange.setText("LILA FOSC");//morat?albergínia? revisar
                    }*/
                }
                if (285 < hue && hue <= 310 && 0.20 < sat) {
                    if (0.650 < value) {
                        textToChange.setText("VIOLETA");
                        codiColorPopup = 10;
                    }
                    if (0.300 < value && value <= 0.650) {
                        textToChange.setText("LILA");//revisar
                        codiColorPopup = 5;
                    }
                }
                if (310 < hue && hue <= 340 && 0.20 < sat) {
                    if (0.650 < value) {
                        textToChange.setText("ROSA");
                        codiColorPopup = 0;
                    }
                    if (0.300 < value && value <= 0.650) {
                        textToChange.setText("GRANAT");//burdeus?morat?fúcsia? revisar
                        codiColorPopup = 0;
                    }
                }
                if (((340 < hue && hue <= 360) || (0 < hue && hue < 5)) && 0.20 < sat) {
                    if (0.500 < value && 0.500 < sat) {
                        textToChange.setText("VERMELL");
                        codiColorPopup = 2;
                    }
                    if (0.500 < value && 0.20 < sat && sat < 0.500) {
                        textToChange.setText("ROSA");
                        codiColorPopup = 0;
                    }
                    if (0.300 < value && value <= 0.500) {
                        textToChange.setText("GRANAT");//teula?granate? revisar
                        codiColorPopup = 0;
                    }
                }

            return true;

            }
        });

    }


     @Override // necessari aqui?
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
         imatge = (ImageView)findViewById(R.id.imatgeFoto);
         if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
             Bundle extras = data.getExtras();
             Bitmap imageBitmap = (Bitmap) extras.get("data");
             //Guardar el bitMap de la imatge en una variable local de l'activity
             bitMapImatge = imageBitmap;
             imatge.setImageBitmap(imageBitmap);
        }
    }

}



