package com.codepath.pborrayo.todoapp;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.widget.EditText;

/**
 * Created by pborrayo on 9/29/16.
 */
public class CustomAlertDialog {

    public CustomAlertDialog() {
        // no-op
    }

    public AlertDialog createAlertDialog(Context context, final RecyclerViewAdapter recyclerViewAdapter, final String itemText) {
        final boolean isInsert = itemText == null;

        Builder builder = new Builder(context);
        final EditText input = new EditText(context);
        input.setText(itemText != null ? itemText : "");
        builder.setView(input)

            .setTitle(isInsert ? R.string.dialog_insert_title : R.string.dialog_update_title)

            .setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int id) {
                    if (isInsert) {
                        recyclerViewAdapter.addItem(input.getText().toString());
                    } else {
                        recyclerViewAdapter.updateItem(input.getText().toString());
                    }

                }
            })

            .setNegativeButton(R.string.dialog_cancel, new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int id) {

                }

            });
        return builder.create();
    }

}
