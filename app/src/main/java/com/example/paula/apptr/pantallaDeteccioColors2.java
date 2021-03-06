package com.example.paula.apptr;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class pantallaDeteccioColors2 extends Activity {


    public ImageView imatge;
    Uri photoURI;
    Bitmap bitMapImatge;
    File photoFile;
    Bitmap myBitmap;




    String mCurrentPhotoPath;

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = "file:" + image.getAbsolutePath();
        return image;
    }

    static final int REQUEST_TAKE_PHOTO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_deteccio_colors2);

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File

            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                photoURI = FileProvider.getUriForFile(this,
                        "com.example.android.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }


    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        switch (requestCode) {


            case REQUEST_TAKE_PHOTO:
                if (requestCode == REQUEST_TAKE_PHOTO)
                    if (resultCode == Activity.RESULT_OK) {
                        try {

                            String imagePath = photoFile.getAbsolutePath();             // photoFile is a File type.
                            Bitmap myBitmap  = BitmapFactory.decodeFile(imagePath);

                            Bitmap orientedBitmap = ExifUtil.rotateBitmap(imagePath, myBitmap);

                            //bitMapImatge = MediaStore.Images.Media.getBitmap(
                                   //getContentResolver(), photoURI);

                            imatge = (ImageView)findViewById(R.id.imageFoto);
                            imatge.setImageBitmap(orientedBitmap);



                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                        /*try {
                            myBitmap = MediaStore.Images.Media.getBitmap(
                                    getContentResolver(), photoURI);

                            ExifInterface exif = new ExifInterface(photoURI.getPath());
                            int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
                            Log.d("EXIF", "Exif: " + orientation);
                            Matrix matrix = new Matrix();
                            if (orientation == 6) {
                                matrix.postRotate(90);
                            }
                            else if (orientation == 3) {
                                matrix.postRotate(180);
                            }
                            else if (orientation == 8) {
                                matrix.postRotate(270);
                            }
                            myBitmap = Bitmap.createBitmap(myBitmap, 0, 0, myBitmap.getWidth(), myBitmap.getHeight(), matrix, true); // rotating bitmap
                        }
                        catch (Exception e) {

                        }
                        ImageView img = (ImageView) findViewById(R.id.imageFoto);
                        img.setImageBitmap(myBitmap);*/


                    }
        }



}
}
