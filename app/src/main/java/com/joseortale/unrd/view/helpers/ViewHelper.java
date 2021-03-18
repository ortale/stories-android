package com.joseortale.unrd.view.helpers;

import android.content.Context;

import androidx.appcompat.app.AlertDialog;

import com.joseortale.unrd.R;

/**
 *
 * Methods used to view as a helper
 *
 */
public class ViewHelper {

    /**
     *
     * Shows alert dialog on the view.
     *
     * @param context
     * @return
     */
    public static AlertDialog.Builder showAlertDialog(Context context) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(context)
                .setTitle(R.string.view_helper_error_title)
                .setMessage(R.string.view_helper_error_message)
                .setIcon(android.R.drawable.ic_dialog_alert);

        return dialog;
    }
}
