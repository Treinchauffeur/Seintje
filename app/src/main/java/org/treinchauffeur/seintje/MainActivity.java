package org.treinchauffeur.seintje;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.chip.Chip;
import com.google.android.material.elevation.SurfaceColors;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import org.treinchauffeur.seintje.io.IOFactory;
import org.treinchauffeur.seintje.misc.Constants;
import org.treinchauffeur.seintje.ui.dialogs.HintDialog;
import org.treinchauffeur.seintje.ui.dialogs.HoofdseinDialog;
import org.treinchauffeur.seintje.ui.dialogs.RemoveAllItemsDialog;
import org.treinchauffeur.seintje.ui.RemoveSignalLongClickListener;
import org.treinchauffeur.seintje.ui.dialogs.SnelheidsbordDialog;
import org.treinchauffeur.seintje.ui.dialogs.VoorseinDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    IOFactory ioFactory;
    private Chip lichtseinen, voorseinen, snelheidsborden, overig, lichtseinenSnelheidsborden,
            stootjuk, leegSpoor, spoorMetWissel;
    private LinearLayout mainLinearLayout;
    protected MaterialToolbar toolbar;
    private ExtendedFloatingActionButton editFab, doneFab;
    private boolean isEditing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ioFactory = new IOFactory(this, MainActivity.this);
        int color = SurfaceColors.SURFACE_2.getColor(this);
        getWindow().setStatusBarColor(color);
        findViewById(R.id.editingPanel).setBackgroundColor(color);

        mainLinearLayout = findViewById(R.id.mainLinearLayout);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setOnMenuItemClickListener(item -> {
            if(item.getItemId() == R.id.menuSendMail) {
                PackageInfo pInfo;
                try {
                    pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
                } catch (PackageManager.NameNotFoundException e) {
                    Toast.makeText(MainActivity.this, "Er is een fout opgetreden, stuur een mail naar "+Constants.DEV_EMAIL, Toast.LENGTH_LONG).show();
                    throw new RuntimeException(e);
                }
                String version = pInfo.versionName;
                final Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{Constants.DEV_EMAIL});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Over: Seintje v "+version);
                startActivity(Intent.createChooser(emailIntent, "E-mail versturen.."));
            } else if(item.getItemId() == R.id.menuSaveLayout) {
                save();
                setisEditing(false);
            } else if(item.getItemId() == R.id.menuResetLayout) {
                RemoveAllItemsDialog dialog = new RemoveAllItemsDialog(this, MainActivity.this);
                dialog.show();
            }
            return false;
        });

        doneFab = findViewById(R.id.doneFab);
        doneFab.setOnClickListener(this);
        editFab = findViewById(R.id.editFab);
        editFab.setOnClickListener(this);
        lichtseinen = findViewById(R.id.hoofdseinenButton);
        voorseinen = findViewById(R.id.voorseinenButton);
        snelheidsborden = findViewById(R.id.snelheidsbordenButton);
        overig = findViewById(R.id.overigButton);
        lichtseinenSnelheidsborden = findViewById(R.id.combinatieButton);
        stootjuk = findViewById(R.id.jukButton);
        leegSpoor = findViewById(R.id.leegSpoorButton);
        spoorMetWissel = findViewById(R.id.spoorMetWisselButton);

        setisEditing(isEditing);
        assignEditingPanelActions();

        if(ioFactory.loadLayout(false).size() > 0)
            ioFactory.loadLayout(true);
        else insertBasePiece();

    }

    private void assignEditingPanelActions() {
        lichtseinen.setOnClickListener(view -> {
            HoofdseinDialog dialog = new HoofdseinDialog(MainActivity.this, this);
            dialog.show();
        });

        voorseinen.setOnClickListener(view -> {
            VoorseinDialog dialog = new VoorseinDialog(MainActivity.this, this);
            dialog.show();
        });

        snelheidsborden.setOnClickListener(view -> {
            SnelheidsbordDialog dialog = new SnelheidsbordDialog(MainActivity.this, this);
            dialog.show();
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

        leegSpoor.setOnClickListener(view -> insertEmptyPiece());

        spoorMetWissel.setOnClickListener(view -> insertPiece(R.drawable.rail_piece_wissel));
    }

    public void insertEmptyPiece() {
        insertPiece(R.drawable.rail_piece_leeg);
    }

    public void insertBasePiece() {
        insertPiece(R.drawable.rail_piece_start);
    }

    /**
     * Inserts a newly created rail piece onto the main 'list' Linear layout.
     * @param drawableResourceId the image resource id to create the newly created piece with.
     */
    public void insertPiece(int drawableResourceId) {
        ImageView toAdd = new ImageView(MainActivity.this);
        toAdd.setOnLongClickListener(new RemoveSignalLongClickListener(this, MainActivity.this));
        toAdd.setOnClickListener(view -> {
            if(!isEditing) new HintDialog(MainActivity.this, toAdd).show();
        });
        toAdd.setScaleType(ImageView.ScaleType.CENTER_CROP);
        toAdd.setTag(drawableResourceId);
        toAdd.setImageResource(drawableResourceId);
        toAdd.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mainLinearLayout.addView(toAdd, 0);
        saveSilently();
    }

    public void removePiece(ImageView toRemove) {
        mainLinearLayout.removeView(toRemove);
        saveSilently();
    }

    public void removeAll() {
        mainLinearLayout.removeAllViews();
        insertBasePiece();
        setisEditing(false);
    }


    private void saveSilently() {
        ioFactory.saveImageIDs(mainLinearLayout, false);
    }
    private void save() {
        ioFactory.saveImageIDs(mainLinearLayout, true);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.editFab) {
            setisEditing(true);
        }
        if(view.getId() == R.id.doneFab) {
            setisEditing(false);
        }
    }

    private void setisEditing(boolean editing) {
        isEditing = editing;
        if(!editing) {
            editFab.setVisibility(View.VISIBLE);
            doneFab.setVisibility(View.GONE);
            findViewById(R.id.editingPanel).setVisibility(View.GONE);
            toolbar.getMenu().findItem(R.id.menuSaveLayout).setVisible(false);
        } else {
            editFab.setVisibility(View.GONE);
            doneFab.setVisibility(View.VISIBLE);
            findViewById(R.id.editingPanel).setVisibility(View.VISIBLE);
            toolbar.getMenu().findItem(R.id.menuSaveLayout).setVisible(true);
        }
    }
}