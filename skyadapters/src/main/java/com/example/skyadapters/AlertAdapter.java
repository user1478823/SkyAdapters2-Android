package com.example.skyadapters;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;

/**
 * Created by ttlnisoffice on 11/20/17.
 */

public class AlertAdapter {

    private Activity a;
    private SharedPreferences sharedPreferences;

    public AlertAdapter(Activity a) {
        this.a = a;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(a);
    }

    public void buildRadioDialog(final String sharedPref, final String alertTitle, final CharSequence[] radioButtonsText) {

        final String savedTheme = PreferenceManager.getDefaultSharedPreferences(a).getString(sharedPref,
                radioButtonsText[0].toString());

        final int[] selectedRadioBtn = {sharedPreferences.getInt("RadioBtnPosition", 0)}; //will give you null exception if you put null

        final String[] themeToSave = {radioButtonsText[selectedRadioBtn[0]].toString()};
        final AlertDialog.Builder builder = new AlertDialog.Builder(a);
        builder .setTitle(alertTitle)
                .setSingleChoiceItems(radioButtonsText, selectedRadioBtn[0],
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                themeToSave[0] = radioButtonsText[i].toString();
                                selectedRadioBtn[0] = i;
                            }
                        })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        if (!themeToSave[0].contains(savedTheme)){
                            sharedPreferences.edit().putString(sharedPref, themeToSave[0]).apply();
                            sharedPreferences.edit().putInt("RadioBtnPosition", selectedRadioBtn[0]).apply();

                            a.setResult(1);
                        }
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });

        AlertDialog alert = builder.create();
        alert.show();
    }

    public String getResult(String sharedPref) {
        return sharedPreferences.getString(sharedPref, "Error");
    }

}
