package org.treinchauffeur.seintje.obj;

import org.treinchauffeur.seintje.R;

public class Sein {
    private String naam;
    private String betekenis;
    private String hint;

    public Sein(int resourceID) {
        resolveSeinDetails(resourceID);
    }

    private void resolveSeinDetails(int id) {
        if (id == R.drawable.rail_piece_leeg) {
            this.naam = "Leeg stuk spoor.";
            this.betekenis = "Geen betekenis.";
            this.hint = "Geen hint.";
        } else if (id == R.drawable.rail_piece_start) {
            this.naam = "Start van het spoor.";
            this.betekenis = "Geen betekenis.";
            this.hint = "Is er al een plaatselijke snelheid bekend?";
        } else if (id == R.drawable.rail_piece_wissel) {
            this.naam = "Spoor met een wissel.";
            this.betekenis = "Geen betekenis.";
            this.hint = "Let goed op wat dit wissel kan betekenen voor het eventueel hernemen van je snelheid.";
        } else if (id == R.drawable.rail_piece_lichtsein_laag_rood) {
            this.naam = "Laaggeplaatst rood licht.";
            this.betekenis = "Stoppen vóór het sein.";
            this.hint = "Hoe zou ik dit sein voorbij kunnen? Is dit een P-sein? Denk aan de waterval.";
        } else if (id == R.drawable.rail_piece_lichtsein_hoog_rood) {
            this.naam = "Hooggeplaatst rood licht.";
            this.betekenis = "Stoppen vóór het sein.";
            this.hint = "Hoe zou ik dit sein voorbij kunnen? Is dit een P-sein? Denk aan de waterval.";
        } else if (id == R.drawable.rail_piece_lichtsein_laag_geel) {
            this.naam = "Laaggeplaatst geel licht.";
            this.betekenis = "Rijden toegestaan met ten hoogste 40 km/u, of de ter plaatse geldende lagere snelheid, " +
                    "om voor het eerstvolgende sein met betekenis ‘stop’ te kunnen stoppen.";
            this.hint = "Geen hint.";
        } else if (id == R.drawable.rail_piece_lichtsein_hoog_geel) {
            this.naam = "Hooggeplaatst geel licht.";
            this.betekenis = "Snelheid begrenzen tot 40 km/u of zoveel minder als nodig om voor het eerstvolgende stoptonende sein te kunnen stoppen.";
            this.hint = "Geen hint.";
        } else if (id == R.drawable.rail_piece_lichtsein_hoog_geelknipper) {
            this.naam = "Hooggeplaatst geel knipperend licht.";
            this.betekenis = "Rijden op zicht.";
            this.hint = "Wat kunnen we allemaal verwachten ná dit sein? Tot wanneer geldt deze opdracht? Welke seinen kunnen voorafgaan aan dit sein?";
        } else if (id == R.drawable.rail_piece_lichtsein_laag_geelknipper) {
            this.naam = "Laaggeplaatst geel knipperend licht.";
            this.betekenis = "Rijden op zicht.";
            this.hint = "Wat kunnen we allemaal verwachten ná dit sein? Tot wanneer geldt deze opdracht? Welke seinen kunnen voorafgaan aan dit sein?";
        } else if (id == R.drawable.rail_piece_lichtsein_laag_groen) {
            this.naam = "Laaggeplaatst groen licht.";
            this.betekenis = "Voorbijrijden toegestaan met een snelheid van ten hoogste 40 km/u.";
            this.hint = "Onthoud 'groen is doen' en 'geel is veel'.";
        } else if (id == R.drawable.rail_piece_lichtsein_hoog_groenknipper) {
            this.naam = "Hooggeplaatst groen knipperend licht.";
            this.betekenis = "Voorbijrijden toegestaan met een snelheid van ten hoogste 40 km/u.";
            this.hint = "Onthoud 'groen is doen' en 'geel is veel'.";
        } else if (id == R.drawable.rail_piece_lichtsein_hoog_groen) {
            this.naam = "Hooggeplaatst groen licht.";
            this.betekenis = "Voorbijrijden toegestaan met inachtneming van de plaatselijke snelheid. " +
                    "Indien bij vertrek de plaatselijke snelheid niet bekend is, is voorbijrijden met een snelheid van ten hoogste 40 km/u toegestaan.";
            this.hint = "Onthoud 'groen is doen' en 'geel is veel'. Is er een plaatselijke snelheid bekend?";
        } else if (id == R.drawable.rail_piece_lichtsein_hoog_groenknipper6 ||
                id == R.drawable.rail_piece_lichtsein_hoog_groenknipper8 ||
                id == R.drawable.rail_piece_lichtsein_hoog_groenknipper12 ||
                id == R.drawable.rail_piece_lichtsein_hoog_groenknipper13) {
            this.naam = "Hooggeplaatst groen knipperend licht met een door wit licht gevormd getal.";
            this.betekenis = "Voorbijrijden toegestaan met ten hoogste de door het getal aangegeven snelheid.";
            this.hint = "Onthoud 'groen is doen' en 'geel is veel'.";
        } else if (id == R.drawable.rail_piece_lichtsein_hoog_geel4 ||
                id == R.drawable.rail_piece_lichtsein_hoog_geel6 ||
                id == R.drawable.rail_piece_lichtsein_hoog_geel8 ||
                id == R.drawable.rail_piece_lichtsein_hoog_geel12 ||
                id == R.drawable.rail_piece_lichtsein_hoog_geel13) {
            this.naam = "Hooggeplaatst geel licht met een door wit licht gevormd getal.";
            this.betekenis = "Snelheid begrenzen tot de door het getal aangegeven snelheid. Deze snelheid moet voor het volgende hoofdsein bereikt zijn.";
            this.hint = "Onthoud 'groen is doen' en 'geel is veel'.";
        } else if (id == R.drawable.rail_piece_lichtsein_hoog_geel4knipper ||
                id == R.drawable.rail_piece_lichtsein_hoog_geel6knipper ||
                id == R.drawable.rail_piece_lichtsein_hoog_geel8knipper ||
                id == R.drawable.rail_piece_lichtsein_hoog_geel12knipper ||
                id == R.drawable.rail_piece_lichtsein_hoog_geel13knipper) {
            this.naam = "Hooggeplaatst geel licht met een door knipperend wit licht gevormd getal.";
            this.betekenis = "Snelheid begrenzen tot de aangegeven snelheid. Deze snelheid kan niet in alle situaties bij het volgende hoofdsein bereikt zijn. " +
                    "In die situaties mag de remming niet onderbroken worden indien het volgende hoofdsein een verdere begrenzing van de snelheid opdraagt.";
            this.hint = "Onthoud 'groen is doen' en 'geel is veel'. Mag ik eventueel mijn remming onderbreken? Wat zegt het volgende sein?";
        } else {
            this.naam = "";
            this.betekenis = "";
            this.hint = "";
        }
    }

    public String getNaam() {
        return naam;
    }

    public String getBetekenis() {
        return betekenis;
    }

    public String getHint() {
        return hint;
    }
}
