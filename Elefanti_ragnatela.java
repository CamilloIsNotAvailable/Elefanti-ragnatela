import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Elefanti_ragnatela {

    public static void main(String[] args) throws IOException {
        int n_elefanti = 2;
        File f = new File("/home/camillo/Desktop/elefanti.txt");
        FileWriter fw = new FileWriter(f);

        System.out.println("un elefante si dondolava sopra il filo di una ragnatela, trovando la cosa molto interessante ando' a chiamare un altro elefante.");

        while (n_elefanti != 999999) {
            System.out.println(n_elefanti);
            fw.write(toString(n_elefanti) + " elefanti si dondolavano sopra il filo di una ragnatela, trovando la cosa molto interessante andarono a chiamare un altro elefante.\n");
            fw.flush();
            n_elefanti++;

        }

    }

    private static String toString(int num) { //20 -> "venti", 742 -> "settecentoquarantadue"
        int mill = num / 1000;
        int cent = num / 100 - (mill * 10);
        int dec = num / 10 - (cent * 10 + mill * 100);
        int unit = num - (cent * 100 + dec * 10 + mill * 1000);

        String name = "";

        if (mill != 0) {
            String mill_name = "";
            mill_name = toString(mill);
            if (mill_name.equals("uno")) {
                name += "mille";

            } else {
                name += mill_name + "mila";

            }

        }

        if (cent != 0) {
            String cent_name = "";
            cent_name = unit_converter(cent);

            name += (cent_name == "uno")? "cento" : cent_name + "cento";


        }

        if (dec == 1) {
            name += dieci_converter(unit);

        } else if (dec != 0) {
            name += decine_converter(dec, unit);

        } else { //dec = 0
            name += unit_converter(unit);

        }

        return name;

    }

    private static String unit_converter(int num) { //2 -> due, 9 -> nove
        switch (num) {
            case 1:
                return "uno";

            case 2:
                return "due";

            case 3:
                return "tre";

            case 4:
                return "quattro";

            case 5:
                return "cinque";

            case 6:
                return "sei";

            case 7:
                return "sette";

            case 8:
                return "otto";

            case 9:
                return "nove";

            default:
                return "";

        }

    }

    private static String dieci_converter(int unit) {
        switch (unit) {
            case 0:
                return "dieci";

            case 1:
                return "undici";

            case 2:
                return "dodici";

            case 3:
                return "tredici";

            case 4:
                return "quattordici";

            case 5:
                return "quindici";

            case 6:
                return "sedici";

            case 7:
                return "diciassette";

            case 8:
                return "diciotto";

            case 9:
                return "diciannove";

            default:
                return "";

        }

    }

    private static String decine_converter(int dec, int unit) {
        String name = "";

        switch (dec) {
            case 2:
                name = "vent";
                break;

            case 3:
                name = "trent";
                break;

            case 4:
                name = "quarant";
                break;

            case 5:
                name = "cinquant";
                break;

            case 6:
                name = "sesant";
                break;

            case 7:
                name = "settant";
                break;

            case 8:
                name = "ottant";
                break;

            case 9:
                name = "novant";
                break;

            default:
                return "";

        }

        if (unit == 1) {
            name += "uno";

        } else if (unit == 8) {
            name += "otto";

        } else if (name.equals("vent")) {
            name += "i" + unit_converter(unit);

        } else {
            name += "a" + unit_converter(unit);

        }

        return name;

    }

}
