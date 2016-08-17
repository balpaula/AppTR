package com.example.paula.apptr;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Paula on 15/08/2016.
 */
public class ComFuncionaFragment extends Fragment {

    public static final String ImageIDKey = "imagekey";
    public static final String DescriptionKey ="descriptionkey";

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_com_funciona, container, false);

        Bundle bundle = getArguments();
        if (bundle != null)
        {
            int imageID = bundle.getInt(ImageIDKey);
            String description = bundle.getString(DescriptionKey);

            setValues(view, imageID, description);
        }

        return view;
    }

    private void setValues(View view, int imageID, String description) {

        ImageView imageView = (ImageView) view.findViewById(R.id.imageViewComFunciona);
        imageView.setImageResource(imageID);

        TextView textView = (TextView) view.findViewById(R.id.tvFotoDescription);
        textView.setText(description);

    }
}
