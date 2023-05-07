package org.treinchauffeur.seintje.ui.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import org.treinchauffeur.seintje.R;
import org.treinchauffeur.seintje.obj.Sein;

public class HintDialog extends Dialog implements View.OnClickListener {

    protected final Context context;
    protected final ImageView seinView;

    public HintDialog(Context context, View seinView) {
        super(context);
        this.context = context;
        this.seinView = (ImageView) seinView;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.dialog_hint);
        TextView seinNaamView = findViewById(R.id.hintSeinNaamTextView);
        TextView seinBetekenisView = findViewById(R.id.hintSeinBetekenisTextView);
        TextView seinHintView = findViewById(R.id.hintTextView);

        Sein sein = new Sein((int) seinView.getTag());
        if(!sein.getNaam().equals("")) seinNaamView.setText(sein.getNaam());
        if(!sein.getBetekenis().equals("")) seinBetekenisView.setText(sein.getBetekenis());
        if(!sein.getHint().equals("")) seinHintView.setText(sein.getHint());

        handleButtons();
    }

    private void handleButtons() {
        MaterialButton btnClose = findViewById(R.id.dialogHintClose);
        btnClose.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        dismiss();
    }
}
