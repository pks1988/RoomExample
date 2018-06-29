package com.room.jetpack.utility;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;

/**
 * Created by Pravesh Sharma on 29-06-2018.
 */

public class util {

    public interface dialogClickListener {
        void okCallback(boolean ok);
    }

    private static dialogClickListener dialogClickListener;

    public static void showDialog(Activity mActivity, String title, String message,  dialogClickListener mDialogClickListener) {
        dialogClickListener = mDialogClickListener;
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(mActivity);
        mBuilder.setTitle(title);
        mBuilder.setMessage(message);
        mBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialogClickListener.okCallback(true);
            }
        });

        mBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog=mBuilder.create();
        alertDialog.show();
    }
}
