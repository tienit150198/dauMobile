package com.example.daumobile.Controller;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class DialogHandler {
    private static DialogHandler INSTANCE;

    public static DialogHandler getInstance(){
        if(INSTANCE == null){
            INSTANCE = new DialogHandler();
        }
        return INSTANCE;
    }


    public void singleChoiceDialog(Context context, ArrayList<Integer> arraylist, int defaultSelected, String title, String message, String strOk, String strCancel, final OnDialogSelectorListener listener) {
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_single_choice, arraylist);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setTitle(title);
        alertDialog.setSingleChoiceItems(arrayAdapter, defaultSelected, null);
        alertDialog.setPositiveButton(strOk, (dialog, which) -> {
            int selectedPosition = ((AlertDialog)dialog).getListView().getCheckedItemPosition();
            listener.onSelectedOption(selectedPosition);
        });
        alertDialog.create().show();
    }

    public interface OnDialogSelectorListener {
        void onSelectedOption(int selectedIndex);
    }
}
