package org.treinchauffeur.seintje;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.chip.Chip;

import org.treinchauffeur.seintje.ui.LichtseinDialog;

public class MainActivity extends AppCompatActivity {

    private Chip lichtseinen, snelheidsborden, overig, lichtseinenSnelheidsborden, stootjuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lichtseinen = findViewById(R.id.lichtseinenButton);
        snelheidsborden = findViewById(R.id.snelheidsbordenButton);
        overig = findViewById(R.id.overigButton);
        lichtseinenSnelheidsborden = findViewById(R.id.combinatieButton);
        stootjuk = findViewById(R.id.jukButton);
        assignButtonActions();

    }

    private void assignButtonActions() {
        lichtseinen.setOnClickListener(view -> {
            LichtseinDialog dialog = new LichtseinDialog(MainActivity.this, this);
            dialog.show();
        });

        snelheidsborden.setOnClickListener(view -> {
            //Todo create dialog
        });

        overig.setOnClickListener(view -> {
            //Todo create dialog
        });

        lichtseinenSnelheidsborden.setOnClickListener(view -> {
            //Todo create dialog
        });

        stootjuk.setOnClickListener(view -> {
            //Todo create dialog
        });
    }

    /**
     * Inserts a newly created rail piece onto the main 'list' Linear layout.
     * @param drawableResourceId the image resource id to create the newly created piece with.
     */
    public void insertPiece(int drawableResourceId) {
        ImageView toAdd = new ImageView(MainActivity.this);
        toAdd.setImageResource(drawableResourceId);
        toAdd.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        LinearLayout mainLinearLayout = findViewById(R.id.mainLinearLayout);
        mainLinearLayout.addView(toAdd, 1);
    }
}