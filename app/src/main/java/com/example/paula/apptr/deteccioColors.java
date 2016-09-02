package com.example.paula.apptr;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class deteccioColors extends Activity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    public ImageView imatge;
    private static final String TAG = "PantallaDeteccioColors";
    Bitmap bitMapImatge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Llevar el títol de l'activity
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
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
                         "( " + String.valueOf(event.getX()) + " , " + String.valueOf(event.getY())+ " ) ");
                Matrix inverse = new Matrix();
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



