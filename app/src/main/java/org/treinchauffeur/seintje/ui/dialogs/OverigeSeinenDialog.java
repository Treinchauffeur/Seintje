package org.treinchauffeur.seintje.ui.dialogs;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;

import org.treinchauffeur.seintje.MainActivity;
import org.treinchauffeur.seintje.R;
import org.treinchauffeur.seintje.misc.Constants;

public class OverigeSeinenDialog extends Dialog implements View.OnClickListener {

    protected final Context context;
    protected final MainActivity activity;
    protected ViewGroup allViews;
    public static final String TAG = "OverigeSeinenDialog";

    public OverigeSeinenDialog(@NonNull Context context, MainActivity activity) {
        super(context);
        this.context = context;
        this.activity = activity;
    }
    @SuppressLint("DiscouragedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.dialog_overigeseinen);

        allViews = findViewById(R.id.overigeSeinenDialogCardView);

        for (View v : allViews.getTouchables()) {
            if (v instanceof Button && v.isClickable()) {
                v.setOnClickListener(this);
                if (v instanceof MaterialButton) continue;
                else if (v instanceof MaterialCheckBox) continue;

                if (Constants.DEBUG) {
                    String convertedDrawableResourceString;
                    String preConvertedName = context.getResources().getResourceEntryName(v.getId());
                    if (preConvertedName.toLowerCase().contains("overig"))
                        convertedDrawableResourceString = "rail_piece_overig_" + context.getResources().getResourceEntryName(v.getId()).split("Overig")[1].toLowerCase();
                    else
                        convertedDrawableResourceString = "";

                    int drawableResourceId = activity.getResources().getIdentifier(convertedDrawableResourceString, "drawable", activity.getPackageName());
                    if (drawableResourceId == 0) {
                        v.setAlpha(0.4f);
                    }
                }
            }
        }
    }

    @SuppressLint("DiscouragedApi")
    @Override
    public void onClick(View view) {
        if (view instanceof MaterialButton) {
            dismiss();
            return;
        } else if (view instanceof MaterialCheckBox) return;

        String convertedDrawableResourceString;
        String preConvertedName = context.getResources().getResourceEntryName(view.getId());
        if (preConvertedName.toLowerCase().contains("overig"))
            convertedDrawableResourceString = "rail_piece_overig_" + context.getResources().getResourceEntryName(view.getId()).split("Overig")[1].toLowerCase();
        else
            convertedDrawableResourceString = "";

        int drawableResourceId = activity.getResources().getIdentifier(convertedDrawableResourceString, "drawable", activity.getPackageName());
        if (drawableResourceId != 0) {
            activity.insertPiece(drawableResourceId);
            if(!Constants.DEBUG) dismiss();
        } else {
            Toast.makeText(context, "Error! Geen resource: " + convertedDrawableResourceString, Toast.LENGTH_SHORT).show();
            Log.d(TAG, "onClick: " + convertedDrawableResourceString);
        }
    }

}
