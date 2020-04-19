package hu.zolta;

public class Main {

    public static void main(String[] args) {
	    Fuvarok fuvarok = new Fuvarok("./feladat/fuvar.csv");
        fuvarok.feladatKiiras(3, fuvarok.harmasFeladat());
        fuvarok.feladatKiiras(4, fuvarok.negyesFeladat());
        fuvarok.feladatKiiras(5, fuvarok.otosFeladat());
        fuvarok.feladatKiiras(6, fuvarok.hatosFeladat());
        fuvarok.feladatKiiras(7, fuvarok.hetesFeladat());
        fuvarok.feladatKiiras(8, fuvarok.nyolcasFeladat());
    }
}