package com.example.skyadaptersexamp;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * Created by ttlnisoffice on 11/20/17.
 */

public class AlertHelper {

    public void setupAlertDialog(Context c) {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(c);
        alertBuilder.setTitle("Title");
        alertBuilder.setMessage("Message");
        alertBuilder.setCancelable(false);
        //alertBuilder.setIcon(R.drawable.ic_alert);
        alertBuilder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertBuilder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        //add additional views here

        AlertDialog alert = alertBuilder.create();
        alert.show();
    }
}

/********* Add EditText ************************************
 EditText editText = new EditText(c);
 alertBuilder.setView(editText);
 ***********************************************************/

/********** Add RadioButtons *******************************
 RadioGroup radioGroup = new RadioGroup(c);

 RadioButton radioBtn1 = new RadioButton(c);
 radioBtn1.setText("This is radio button 1");

 RadioButton radioBtn2 = new RadioButton(c);
 radioBtn2.setText("This is radio button 2");

 RadioButton radioBtn3 = new RadioButton(c);
 radioBtn3.setText("This is radio button 3");

 radioGroup.addView(radioBtn1);
 radioGroup.addView(radioBtn2);
 radioGroup.addView(radioBtn3);

 alertBuilder.setView(radioGroup);
 ***********************************************************/

/********** Add CheckBoxes *********************************
 LinearLayout checkBoxHolder = new LinearLayout(c);
 checkBoxHolder.setOrientation(LinearLayout.VERTICAL);

 CheckBox checkBox1 = new CheckBox(c);
 checkBox1.setText("This is checkbox 1");

 CheckBox checkBox2 = new CheckBox(c);
 checkBox2.setText("This is checkbox 2");

 CheckBox checkBox3 = new CheckBox(c);
 checkBox3.setText("This is checkbox 3");

 checkBoxHolder.addView(checkBox1);
 checkBoxHolder.addView(checkBox2);
 checkBoxHolder.addView(checkBox3);

 alertBuilder.setView(checkBoxHolder);
 ***********************************************************/