package org.treinchauffeur.seintje.ui;

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

import org.treinchauffeur.seintje.MainActivity;
import org.treinchauffeur.seintje.R;

import java.util.Locale;

public class LichtseinDialog extends Dialog implements View.OnClickListener {

    protected final Context context;
    protected final MainActivity activity;
    public static final String TAG = "LichtseinDialog";

    private RadioButton RadioButtonLaagSeinGedoofd, RadioButtonLaagSeinRood,
            RadioButtonLaagSeinGeel, RadioButtonLaagSeinGeelKnipper, RadioButtonLaagSeinGroen,
            RadioButtonHoofdseinGedoofd, RadioButtonHoofdseinRood, RadioButtonHoofdseinRoodKnipper,
            RadioButtonHoofdseinGeel, RadioButtonHoofdseinGeelKnipper, RadioButtonHoofdseinGroen,
            RadioButtonHoofdseinGroenKnipper, RadioButtonHoofdseinGroenKnipper4, RadioButtonHoofdseinGroenKnipper6,
            RadioButtonHoofdseinGroenKnipper8, RadioButtonHoofdseinGroenKnipper12, RadioButtonHoofdseinGroenKnipper13,
            RadioButtonHoofdseinGeel6, RadioButtonHoofdseinGeel8, RadioButtonHoofdseinGeel12,
            RadioButtonHoofdseinGeel13, RadioButtonHoofdseinGeelKnipper6, RadioButtonHoofdseinGeelKnipper8,
            RadioButtonHoofdseinGeelKnipper12, RadioButtonHoofdseinGeelKnipper13, RadioButtonHoofdseinGeel12Knipper12;

    private RadioButton RadioButtonLaagSeinPGedoofd, RadioButtonLaagSeinPRood,
            RadioButtonLaagSeinPGeel, RadioButtonLaagSeinPGeelKnipper, RadioButtonLaagSeinPGroen,
            RadioButtonHoofdseinPGedoofd, RadioButtonHoofdseinPRood, RadioButtonHoofdseinPRoodKnipper,
            RadioButtonHoofdseinPGeel, RadioButtonHoofdseinPGeelKnipper, RadioButtonHoofdseinPGroen,
            RadioButtonHoofdseinPGroenKnipper, RadioButtonHoofdseinPGroenKnipper4, RadioButtonHoofdseinPGroenKnipper6,
            RadioButtonHoofdseinPGroenKnipper8, RadioButtonHoofdseinPGroenKnipper12, RadioButtonHoofdseinPGroenKnipper13,
            RadioButtonHoofdseinPGeel6, RadioButtonHoofdseinPGeel8, RadioButtonHoofdseinPGeel12,
            RadioButtonHoofdseinPGeel13, RadioButtonHoofdseinPGeelKnipper6, RadioButtonHoofdseinPGeelKnipper8,
            RadioButtonHoofdseinPGeelKnipper12, RadioButtonHoofdseinPGeelKnipper13, RadioButtonHoofdseinPGeel12Knipper12;


    public LichtseinDialog(@NonNull Context context, MainActivity activity) {
        super(context);
        this.context = context;
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.dialog_lichtseinen);

        ViewGroup allViews = findViewById(R.id.dialogCardView);

        for(View v : allViews.getTouchables()) {
            if(v instanceof Button && v.isClickable()) {
                v.setOnClickListener(this);
            }
        }
    }

    @SuppressLint("DiscouragedApi") //I REALLY don't want to have to type all those resource IDs..
    @Override
    public void onClick(View view) {
        if(view instanceof MaterialButton) {dismiss(); return;}

        String convertedDrawableResourceString;
        String preConvertedName = context.getResources().getResourceEntryName(view.getId());
        if(preConvertedName.toLowerCase().contains("laag"))
            convertedDrawableResourceString = "rail_piece_lichtsein_laag_" + context.getResources().getResourceEntryName(view.getId()).split("Sein")[1].toLowerCase();
        else if(preConvertedName.toLowerCase().contains("voorsein"))
            convertedDrawableResourceString = "rail_piece_voorsein_" + context.getResources().getResourceEntryName(view.getId()).split("Sein")[1].toLowerCase();
        else
            convertedDrawableResourceString = "rail_piece_lichtsein_" + context.getResources().getResourceEntryName(view.getId()).split("Sein")[1].toLowerCase();

        int drawableResourceId = activity.getResources().getIdentifier(convertedDrawableResourceString, "drawable", activity.getPackageName());
        if(drawableResourceId != 0) {
            activity.insertPiece(drawableResourceId);
            dismiss();
        } else {
            Toast.makeText(context, convertedDrawableResourceString, Toast.LENGTH_SHORT).show();
            Log.d(TAG, "onClick: "+convertedDrawableResourceString);
        }
    }
}
