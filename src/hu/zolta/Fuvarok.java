package hu.zolta;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Fuvarok {
    private List<Fuvar> fuvarList;
    private List<String> hibasSor;

    public Fuvarok(String fileHelye) {
        fuvarList = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(fileHelye)));
            String sor = br.readLine();
            hibasSor = new ArrayList<>();
            hibasSor.add(sor);
            while ((sor = br.readLine()) != null) {
                String[] sorBontott = sor.split(";");
                if (Integer.parseInt(sorBontott[2]) > 0
                        && Double.parseDouble(sorBontott[4].replace(",", ".")) > 0
                        && Double.parseDouble(sorBontott[3].replace(",", ".")) == 0) {
                    hibasSor.add(sor);
                }
                else{
                    fuvarList.add(
                            new Fuvar(
                                    Integer.parseInt(sorBontott[0]),
                                    sorBontott[1],
                                    Integer.parseInt(sorBontott[2]),
                                    Double.parseDouble(sorBontott[3].replace(",", ".")),
                                    Double.parseDouble(sorBontott[4].replace(",", ".")),
                                    Double.parseDouble(sorBontott[5].replace(",", ".")),
                                    sorBontott[6]
                            )
                    );
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String harmasFeladat(){
        return fuvarList.size() + " fuvar";
    }

    public String negyesFeladat(){
        int bevetel = 0;
        int fuvarokSzama = 0;

        for (int i = 0; i < fuvarList.size(); i++) {
            if (fuvarList.get(i).getTaxiID() == 6185){
                bevetel += fuvarList.get(i).getBorravalo() + fuvarList.get(i).getVitelDij();
                fuvarokSzama++;
            }
        }
        return fuvarokSzama + " fuvar alatt: " + bevetel + "$";
    }

    public String otosFeladat(){
        int[] db = new int[5];

        for (int i = 0; i < fuvarList.size(); i++) {
            switch (fuvarList.get(i).getFizetesModja()){
                case "bankkártya":
                    db[0]++;
                    break;
                case "készpénz":
                    db[1]++;
                    break;
                case "vitatott":
                    db[2]++;
                    break;
                case "ingyenes":
                    db[3]++;
                    break;
                case "ismeretlen":
                    db[4]++;
                    break;
                default:
                    break;
            }
        }

        return  "\n" +
                "\tbankkártya: " + db[0] + " fuvar\n" +
                "\tkészpénz: " + db[1] + " fuvar\n" +
                "\tvitatott: " + db[2] + " fuvar\n" +
                "\tingyenes: " + db[3] + " fuvar\n" +
                "\tismeretlen: " + db[4] + " fuvar"
        ;
    }

    public String hatosFeladat(){
        double sum = 0;
        for (int i = 0; i < fuvarList.size(); i++) {
            sum += fuvarList.get(i).getMegtettTavolsag();
        }

        return merfoldToKilometer(sum) + "km";
    }

    public double merfoldToKilometer(double merfold){
        return merfold * 1.6;
    }

    public String hetesFeladat(){
        int id = 0;
        int maxIdo = 0;

        for (int i = 0; i < fuvarList.size(); i++) {
            if (maxIdo < fuvarList.get(i).getUtazasIdotartama()){
                id = i;
                maxIdo = fuvarList.get(i).getUtazasIdotartama();
            }
        }
        return "Leghosszabb fuvar:\n" + fuvarList.get(id);
    }

    public String nyolcasFeladat(){
        if (hibasSor.size() > 1){
            try {
                Path file = Paths.get("hibak.txt");
                Files.write(file, hibasSor, StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "hibak.txt";
        }
        else {
            return "Nem volt hibás sor";
        }
    }

    public void feladatKiiras(int sorszam, String valasz){
        System.out.printf("%d. feladat: %s \n", sorszam, valasz);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}