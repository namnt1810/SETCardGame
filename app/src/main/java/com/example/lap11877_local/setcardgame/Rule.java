package com.example.lap11877_local.setcardgame;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

public class Rule extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.dialog_set_rule)
                .setPositiveButton(R.string.back, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // RETURN
                    }
                })
                .setTitle(R.string.rule);

        // Create the AlertDialog object and return it
        return builder.create();
    }
}
