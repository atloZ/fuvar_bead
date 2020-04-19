package hu.zolta;

public class Fuvar {
    private int taxiID; // format: xxxx
    private String indulasIdopontja;    // format: yyyy-mm-dd hh:mm:ss
    private int utazasIdotartama;   // Másodpercben mérve
    private double megtettTavolsag;    // Mérföldben
    private double vitelDij;    // Dollár
    private double borravalo;    // Dollár
    private String fizetesModja;

    public Fuvar(int taxiID, String indulasIdopontja, int utazasIdotartama, double megtettTavolsag, double vitelDij, double borravalo, String fizetesModja) {
        this.taxiID = taxiID;
        this.indulasIdopontja = indulasIdopontja;
        this.utazasIdotartama = utazasIdotartama;
        this.megtettTavolsag = megtettTavolsag;
        this.vitelDij = vitelDij;
        this.borravalo = borravalo;
        this.fizetesModja = fizetesModja;
    }

    public int getTaxiID() {
        return taxiID;
    }

    public String getIndulasIdopontja() {
        return indulasIdopontja;
    }

    public int getUtazasIdotartama() {
        return utazasIdotartama;
    }

    public double getMegtettTavolsag() {
        return megtettTavolsag;
    }

    public double getVitelDij() {
        return vitelDij;
    }

    public double getBorravalo() {
        return borravalo;
    }

    public String getFizetesModja() {
        return fizetesModja;
    }

    @Override
    public String toString() {
        return String.format(
                "\tFuvar hossza: %f másodperc\n" +
                "\tTaxi azonositoja: %d\n" +
                "\tMegtett távolság: %f km\n" +
                "\tViteldíj: %f$",
                vitelDij, taxiID, megtettTavolsag, vitelDij
        );
    }
}