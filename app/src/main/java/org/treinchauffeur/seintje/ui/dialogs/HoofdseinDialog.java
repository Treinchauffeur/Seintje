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
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;

import org.treinchauffeur.seintje.MainActivity;
import org.treinchauffeur.seintje.R;
import org.treinchauffeur.seintje.misc.Constants;

public class HoofdseinDialog extends Dialog implements View.OnClickListener {

    protected final Context context;
    protected final MainActivity activity;
    protected ViewGroup allViews;
    public static final String TAG = "HoofdseinDialog";

    public HoofdseinDialog(@NonNull Context context, MainActivity activity) {
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
        setContentView(R.layout.dialog_hoofdseinen);

        allViews = findViewById(R.id.dialogCardView);

        for (View v : allViews.getTouchables()) {
            if (v instanceof Button && v.isClickable()) {
                v.setOnClickListener(this);
                if (v instanceof MaterialButton) continue;
                else if (v instanceof MaterialCheckBox) continue;

                if (Constants.DEBUG) {
                    String convertedDrawableResourceString;
                    String preConvertedName = context.getResources().getResourceEntryName(v.getId());
                    if (preConvertedName.toLowerCase().contains("laag"))
                        convertedDrawableResourceString = "rail_piece_lichtsein_laag_" + context.getResources().getResourceEntryName(v.getId()).split("Sein")[1].toLowerCase();
                    else if (preConvertedName.toLowerCase().contains("voorsein"))
                        convertedDrawableResourceString = "rail_piece_voorsein_" + context.getResources().getResourceEntryName(v.getId()).split("Sein")[1].toLowerCase();
                    else
                        convertedDrawableResourceString = "rail_piece_lichtsein_hoog_" + context.getResources().getResourceEntryName(v.getId()).split("Sein")[1].toLowerCase();

                    int drawableResourceId = activity.getResources().getIdentifier(convertedDrawableResourceString, "drawable", activity.getPackageName());
                    if (drawableResourceId == 0) {
                        v.setAlpha(0.4f);
                    }
                }
            }
        }

        MaterialCheckBox showOnjuistCheckBox = findViewById(R.id.onjuistHoofdseinCheckBox);
        showOnjuistCheckBox.setOnCheckedChangeListener((compoundButton, b) -> {
            ViewGroup hoofdseinGroup = findViewById(R.id.hoofdSeinGroup);
            int count = hoofdseinGroup.getChildCount();
            for (int i = 0; i < count; i++) {
                Log.d(TAG, "onCreate: ");
                View v = hoofdseinGroup.getChildAt(i);
                if (v instanceof RadioButton) {
                    RadioButton radio = (RadioButton) v;
                    if (radio.getAlpha() < 1) {
                        radio.setVisibility(compoundButton.isChecked() ? View.VISIBLE : View.GONE);
                    }
                }
            }
            ViewGroup pSeinGroup = findViewById(R.id.hoofdSeinGroupPSein);
            int countP = pSeinGroup.getChildCount();
            for (int i = 0; i < countP; i++) {
                Log.d(TAG, "onCreate: ");
                View v = pSeinGroup.getChildAt(i);
                if (v instanceof RadioButton) {
                    RadioButton radio = (RadioButton) v;
                    if (radio.getAlpha() < 1) {
                        radio.setVisibility(compoundButton.isChecked() ? View.VISIBLE : View.GONE);
                    }
                }
            }
        });
    }

    @SuppressLint("DiscouragedApi") //I REALLY don't want to have to type all those resource IDs..
    @Override
    public void onClick(View view) {
        if (view instanceof MaterialButton) {
            dismiss();
            return;
        } else if (view instanceof MaterialCheckBox) return;

        String convertedDrawableResourceString;
        String preConvertedName = context.getResources().getResourceEntryName(view.getId());
        if (preConvertedName.toLowerCase().contains("laag"))
            convertedDrawableResourceString = "rail_piece_lichtsein_laag_" + context.getResources().getResourceEntryName(view.getId()).split("Sein")[1].toLowerCase();
        else if (preConvertedName.toLowerCase().contains("voorsein"))
            convertedDrawableResourceString = "rail_piece_voorsein_" + context.getResources().getResourceEntryName(view.getId()).split("Sein")[1].toLowerCase();
        else
            convertedDrawableResourceString = "rail_piece_lichtsein_hoog_" + context.getResources().getResourceEntryName(view.getId()).split("Sein")[1].toLowerCase();

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
