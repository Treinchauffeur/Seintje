package org.treinchauffeur.seintje.ui;

import android.content.Context;
import android.view.View;

import org.treinchauffeur.seintje.MainActivity;
import org.treinchauffeur.seintje.ui.dialogs.RemoveItemDialog;

public class RemoveSignalLongClickListener implements View.OnLongClickListener {
    private final MainActivity activity;
    private final Context context;

    public RemoveSignalLongClickListener(MainActivity activity, Context context) {
        super();
        this.activity = activity;
        this.context = context;
    }

    @Override
    public boolean onLongClick(View view) {
        RemoveItemDialog dialog = new RemoveItemDialog(context, activity, view);
        dialog.show();
        return false;
    }
}
