package com.example.paula.apptr;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Paula on 15/08/2016.
 */
public class ComFuncionaPageAdapter extends FragmentPagerAdapter {

    String[] passos;
    String[] passosDescription;

    public ComFuncionaPageAdapter(FragmentManager fm, Context context) {
        super(fm);

        Resources resources = context.getResources();

        passos = resources.getStringArray(R.array.passos);
        passosDescription = resources.getStringArray(R.array.passos_description);

    }

    @Override
    public Fragment getItem(int position) {

        Bundle bundle = new Bundle();
        bundle.putString(ComFuncionaFragment.DescriptionKey, passosDescription[position]);
        bundle.putInt(ComFuncionaFragment.ImageIDKey,getPasImageID(position) );

        ComFuncionaFragment comFuncionaFragment = new ComFuncionaFragment();
        comFuncionaFragment.setArguments(bundle);

        return comFuncionaFragment;
    }

    private int getPasImageID (int position) {

        int id = 0;
        switch (position)
        {
            case 0:
                id = R.drawable.comfunciona1;
                break;

            case 1:
                id = R.drawable.comfunciona2;
                break;

            case 2:
                id = R.drawable.comfunciona3plus;
                break;

        }

        return id;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return passos[position];
    }

    @Override
    public int getCount() {
        return passos.length;
    }
}
