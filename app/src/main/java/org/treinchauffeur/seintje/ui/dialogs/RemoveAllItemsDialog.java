package org.treinchauffeur.seintje.ui.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import org.treinchauffeur.seintje.MainActivity;
import org.treinchauffeur.seintje.R;

public class RemoveAllItemsDialog extends Dialog implements View.OnClickListener {

    private final MainActivity activity;
    protected final Context context;

    public RemoveAllItemsDialog(Context context, MainActivity activity) {
        super(context);
        this.activity = activity;
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.dialog_remove_all_items);

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
            activity.removeAll();
            Toast.makeText(activity, "Alle items verwijderd!", Toast.LENGTH_SHORT).show();
        }
        dismiss();
    }
}
