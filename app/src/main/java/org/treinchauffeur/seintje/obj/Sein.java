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
        } else if (id == R.drawable.rail_piece_lichtsein_hoog_gedoofd
        || id == R.drawable.rail_piece_lichtsein_laag_gedoofd
        || id == R.drawable.rail_piece_lichtsein_laag_pgedoofd
        || id == R.drawable.rail_piece_lichtsein_hoog_pgedoofd) {
            this.naam = "Gedoofd hoofdsein.";
            this.betekenis = "Geen betekenis.";
            this.hint = "Gaan we de waterval gedoofde/onjuiste seinen af? Moeten we nog meer weten?";
        } else if (id == R.drawable.rail_piece_lichtsein_laag_rood ||
                id == R.drawable.rail_piece_lichtsein_laag_prood) {
            this.naam = "Laaggeplaatst rood licht.";
            this.betekenis = "Stoppen vóór het sein.";
            this.hint = "Hoe zou ik dit sein voorbij kunnen? Is dit een P-sein? Denk aan de waterval.";
        } else if (id == R.drawable.rail_piece_lichtsein_hoog_rood ||
                id == R.drawable.rail_piece_lichtsein_hoog_prood) {
            this.naam = "Hooggeplaatst rood licht.";
            this.betekenis = "Stoppen vóór het sein.";
            this.hint = "Hoe zou ik dit sein voorbij kunnen? Is dit een P-sein? Denk aan de waterval.";
        } else if (id == R.drawable.rail_piece_lichtsein_laag_geel
        || id == R.drawable.rail_piece_lichtsein_laag_pgeel) {
            this.naam = "Laaggeplaatst geel licht.";
            this.betekenis = "Rijden toegestaan met ten hoogste 40 km/u, of de ter plaatse geldende lagere snelheid, " +
                    "om voor het eerstvolgende sein met betekenis ‘stop’ te kunnen stoppen.";
            this.hint = "Geen hint.";
        } else if (id == R.drawable.rail_piece_lichtsein_hoog_geel
        || id == R.drawable.rail_piece_lichtsein_hoog_pgeel) {
            this.naam = "Hooggeplaatst geel licht.";
            this.betekenis = "Snelheid begrenzen tot 40 km/u of zoveel minder als nodig om voor het eerstvolgende stoptonende sein te kunnen stoppen.";
            this.hint = "Geen hint.";
        } else if (id == R.drawable.rail_piece_lichtsein_hoog_geelknipper
        || id == R.drawable.rail_piece_lichtsein_hoog_pgeelknipper) {
            this.naam = "Hooggeplaatst geel knipperend licht.";
            this.betekenis = "Rijden op zicht.";
            this.hint = "Wat kunnen we allemaal verwachten ná dit sein? Tot wanneer geldt deze opdracht? Welke seinen kunnen voorafgaan aan dit sein?";
        } else if (id == R.drawable.rail_piece_lichtsein_laag_geelknipper
        || id == R.drawable.rail_piece_lichtsein_laag_pgeelknipper) {
            this.naam = "Laaggeplaatst geel knipperend licht.";
            this.betekenis = "Rijden op zicht.";
            this.hint = "Wat kunnen we allemaal verwachten ná dit sein? Tot wanneer geldt deze opdracht? Welke seinen kunnen voorafgaan aan dit sein?";
        } else if (id == R.drawable.rail_piece_lichtsein_laag_groen
        || id == R.drawable.rail_piece_lichtsein_laag_pgroen) {
            this.naam = "Laaggeplaatst groen licht.";
            this.betekenis = "Voorbijrijden toegestaan met een snelheid van ten hoogste 40 km/u.";
            this.hint = "Onthoud 'groen is doen' en 'geel is veel'.";
        } else if (id == R.drawable.rail_piece_lichtsein_hoog_groenknipper
        || id == R.drawable.rail_piece_lichtsein_hoog_pgroenknipper) {
            this.naam = "Hooggeplaatst groen knipperend licht.";
            this.betekenis = "Voorbijrijden toegestaan met een snelheid van ten hoogste 40 km/u.";
            this.hint = "Onthoud 'groen is doen' en 'geel is veel'.";
        } else if (id == R.drawable.rail_piece_lichtsein_hoog_groen
        || id == R.drawable.rail_piece_lichtsein_hoog_pgroen) {
            this.naam = "Hooggeplaatst groen licht.";
            this.betekenis = "Voorbijrijden toegestaan met inachtneming van de plaatselijke snelheid. " +
                    "Indien bij vertrek de plaatselijke snelheid niet bekend is, is voorbijrijden met een snelheid van ten hoogste 40 km/u toegestaan.";
            this.hint = "Onthoud 'groen is doen' en 'geel is veel'. Is er een plaatselijke snelheid bekend?";
        } else if (id == R.drawable.rail_piece_lichtsein_hoog_groenknipper6 ||
                id == R.drawable.rail_piece_lichtsein_hoog_groenknipper8 ||
                id == R.drawable.rail_piece_lichtsein_hoog_groenknipper12 ||
                id == R.drawable.rail_piece_lichtsein_hoog_groenknipper13 ||
                id == R.drawable.rail_piece_lichtsein_hoog_pgroenknipper6 ||
                id == R.drawable.rail_piece_lichtsein_hoog_pgroenknipper8 ||
                id == R.drawable.rail_piece_lichtsein_hoog_pgroenknipper12 ||
                id == R.drawable.rail_piece_lichtsein_hoog_pgroenknipper13) {
            this.naam = "Hooggeplaatst groen knipperend licht met een door wit licht gevormd getal.";
            this.betekenis = "Voorbijrijden toegestaan met ten hoogste de door het getal aangegeven snelheid.";
            this.hint = "Onthoud 'groen is doen' en 'geel is veel'.";
        } else if (id == R.drawable.rail_piece_lichtsein_hoog_geel4 ||
                id == R.drawable.rail_piece_lichtsein_hoog_geel6 ||
                id == R.drawable.rail_piece_lichtsein_hoog_geel8 ||
                id == R.drawable.rail_piece_lichtsein_hoog_geel12 ||
                id == R.drawable.rail_piece_lichtsein_hoog_geel13 ||
                id == R.drawable.rail_piece_lichtsein_hoog_pgeel4 ||
                id == R.drawable.rail_piece_lichtsein_hoog_pgeel6 ||
                id == R.drawable.rail_piece_lichtsein_hoog_pgeel8 ||
                id == R.drawable.rail_piece_lichtsein_hoog_pgeel12 ||
                id == R.drawable.rail_piece_lichtsein_hoog_pgeel13) {
            this.naam = "Hooggeplaatst geel licht met een door wit licht gevormd getal.";
            this.betekenis = "Snelheid begrenzen tot de door het getal aangegeven snelheid. Deze snelheid moet voor het volgende hoofdsein bereikt zijn.";
            this.hint = "Onthoud 'groen is doen' en 'geel is veel'.";
        } else if (id == R.drawable.rail_piece_lichtsein_hoog_geel4knipper ||
                id == R.drawable.rail_piece_lichtsein_hoog_geel6knipper ||
                id == R.drawable.rail_piece_lichtsein_hoog_geel8knipper ||
                id == R.drawable.rail_piece_lichtsein_hoog_geel12knipper ||
                id == R.drawable.rail_piece_lichtsein_hoog_geel13knipper ||
                id == R.drawable.rail_piece_lichtsein_hoog_pgeel4knipper ||
                id == R.drawable.rail_piece_lichtsein_hoog_pgeel6knipper ||
                id == R.drawable.rail_piece_lichtsein_hoog_pgeel8knipper ||
                id == R.drawable.rail_piece_lichtsein_hoog_pgeel12knipper ||
                id == R.drawable.rail_piece_lichtsein_hoog_pgeel13knipper) {
            this.naam = "Hooggeplaatst geel licht met een door knipperend wit licht gevormd getal.";
            this.betekenis = "Snelheid begrenzen tot de aangegeven snelheid. Deze snelheid kan niet in alle situaties bij het volgende hoofdsein bereikt zijn. " +
                    "In die situaties mag de remming niet onderbroken worden indien het volgende hoofdsein een verdere begrenzing van de snelheid opdraagt.";
            this.hint = "Onthoud 'groen is doen' en 'geel is veel'. Mag ik eventueel mijn remming onderbreken? Wat zegt het volgende sein?";
        } else if (id == R.drawable.rail_piece_lichtsein_hoog_pgeelknipper12knipper
        || id == R.drawable.rail_piece_lichtsein_hoog_geelknipper12knipper) {
            this.naam = "Hooggeplaatst geel knipperend licht met een door knipperend wit licht gevormd getal.";
            this.betekenis = "Geen betekenis.";
            this.hint = "Is dit een juist sein? Moeten we de waterval af gaan?";
        } else if (id == R.drawable.rail_piece_juk) {
            this.naam = "Stootjuk met afsluitlanteren.";
            this.betekenis = "Stoppen voor het sein.";
            this.hint = "Geen hint.";
        } else if (id == R.drawable.rail_piece_seinbordcombinatie_hooggeelknippersnh8) {
            this.naam = "Hooggeplaatst geel knipperend licht met een snelheidsbord.";
            this.betekenis = "Rijden op zicht.";
            this.hint = "Welk sein is leidend, en moeten we nog iets onthouden terwijl we deze opvolgen?";
        } else if (id == R.drawable.rail_piece_seinbordcombinatie_hooggroenbvk13 ||
                id == R.drawable.rail_piece_seinbordcombinatie_hooggroensnh13) {
            this.naam = "Hooggeplaatst groen licht met een (baanvak)snelheidsbord.";
            this.betekenis = "Rijden toegestaan met de plaatselijke snelheid.";
            this.hint = "En de plaatselijke snelheid is bekend, namelijk 130 km/u.";
        } else if (id == R.drawable.rail_piece_seinbordcombinatie_hooggroensnh8) {
            this.naam = "Hooggeplaatst groen licht met een (baanvak)snelheidsbord.";
            this.betekenis = "Rijden toegestaan met de plaatselijke snelheid.";
            this.hint = "En de plaatselijke snelheid is bekend, namelijk 80 km/u.";
        } else if (id == R.drawable.rail_piece_seinbordcombinatie_hooggroensnh14) {
            this.naam = "Hooggeplaatst groen licht met een (baanvak)snelheidsbord.";
            this.betekenis = "Rijden toegestaan met de plaatselijke snelheid.";
            this.hint = "En de plaatselijke snelheid is bekend, namelijk 140 km/u.";
        } else if (id == R.drawable.rail_piece_seinbordcombinatie_hooggroenknippersnh14) {
            this.naam = "Hooggeplaatst groen knipperend licht met een (baanvak)snelheidsbord.";
            this.betekenis = "Rijden toegestaan met een snelheid van ten hoogste 40 kilometer per uur.";
            this.hint = "Mogen we het snelheidsbord opvolgen? Doen we er verder nog iets mee?";
        } else if (id == R.drawable.rail_piece_voorsein_gedoofd) {
            this.naam = "Gedoofd voorsein.";
            this.betekenis = "Geen betekenis.";
            this.hint = "Gaan we de waterval gedoofde/onjuiste seinen af, of hebben gedoofde voorseinen een speciale rol?";
        } else if (id == R.drawable.rail_piece_voorsein_geel) {
            this.naam = "Hooggeplaatst geel licht.";
            this.betekenis = "Snelheid begrenzen tot 40 kilometer per uur of lager, om voor het eerstvolgende sein met betekenis ‘stop’ te kunnen stoppen. Een voorafgaande opdracht ‘Rijden op zicht’ blijft gelden.";
            this.hint = "Geen hint.";
        } else if (id == R.drawable.rail_piece_voorsein_geel4
        || id == R.drawable.rail_piece_voorsein_geel6
                || id == R.drawable.rail_piece_voorsein_geel8
                || id == R.drawable.rail_piece_voorsein_geel12
                || id == R.drawable.rail_piece_voorsein_geel13) {
            this.naam = "Hoog geplaatst geel licht met een door wit licht gevormd getal.";
            this.betekenis = "Snelheid begrenzen tot de aangegeven snelheid. Deze snelheid moet vóór het volgende hoofdsein bereikt zijn. Een voorafgaande opdracht ‘Rijden op zicht’ blijft gelden.";
            this.hint = "Onthoud 'groen is doen' en 'geel is veel'.";
        } else if (id == R.drawable.rail_piece_voorsein_geel4knipper) {
            this.naam = "Hoog geplaatst geel licht met een door wit knipperend licht gevormd getal.";
            this.betekenis = "Geen betekenis.";
            this.hint = "Is dit een juist seinbeeld? Moeten we de waterval af of hebben onjuiste voorseinen een speciale rol?";
        } else if (id == R.drawable.rail_piece_voorsein_geelknipper) {
            this.naam = "Hoog geplaatst geel knipperend licht.";
            this.betekenis = "Geen betekenis.";
            this.hint = "Is dit een juist seinbeeld? Moeten we de waterval af of hebben onjuiste voorseinen een speciale rol?";
        } else if (id == R.drawable.rail_piece_overig_keperbakens) {
            this.naam = "Keperbaken.";
            this.betekenis = "Snelheid begrenzen tot 40 kilometer per uur of zoveel minder als nodig om voor het eerstvolgende ‘stop’ tonende sein te kunnen stoppen.";
            this.hint = "Wanneer kom je dit sein tegen? Waar moet je rekening mee houden bij het volgende sein?";
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
