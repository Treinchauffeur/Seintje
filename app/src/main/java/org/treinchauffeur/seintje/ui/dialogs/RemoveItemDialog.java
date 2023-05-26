package org.treinchauffeur.seintje.ui.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import org.treinchauffeur.seintje.MainActivity;
import org.treinchauffeur.seintje.R;

public class RemoveItemDialog extends Dialog implements View.OnClickListener {

    private final MainActivity activity;
    protected final Context context;
    protected final ImageView toRemove;

    public RemoveItemDialog(Context context,MainActivity activity , View toRemove) {
        super(context);
        this.activity = activity;
        this.context = context;
        this.toRemove = (ImageView) toRemove;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.dialog_remove_item);

        handleButtons();
    }

    private void handleButtons() {
        MaterialButton btnYes = findViewById(R.id.dialogRemoveYes);
        btnYes.setOnClickListener(this);
        MaterialButton btnNo = findViewById(R.id.dialogRemoveNo);
        btnNo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.dialogRemoveYes) {
            if(toRemove.getTag().equals(R.drawable.rail_piece_start)) {
                Toast.makeText(activity, "Dit item kan niet worden verwijderd!", Toast.LENGTH_SHORT).show();
                dismiss();
                return;
            }
            activity.removePiece(toRemove);
            Toast.makeText(activity, "Één item verwijderd!", Toast.LENGTH_SHORT).show();
        }
        dismiss();
    }
}
