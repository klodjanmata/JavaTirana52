package JavaAdv.Exercises;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class PoesyWriter {
    private final String poesy =
            "Në Heshtje Rritet Drita\n" +
            "\n" +
            "Në heshtje rritet drita e mëngjesit,\n" +
            "si shpresë që vjen pas një nate të gjatë,\n" +
            "çdo rreze prek me mall një shpirt të heshtur,\n" +
            "çdo hap i ri një ëndërr sjell me vrap.\n" +
            "\n" +
            "Në sytë e tu ka yje që s’kanë rënë,\n" +
            "ka ndjenja që s’kanë gjetur ende fjalë,\n" +
            "po zemra jote di të shkruaj poezi,\n" +
            "edhe kur bota rri në qetësi.\n" +
            "\n" +
            "Mos ki frikë nga nata që mbulon,\n" +
            "as nga stuhitë që vijnë pa lajmëruar,\n" +
            "se brenda teje frymon një diell i fshehur,\n" +
            "që ditën tënde do dijë ta ndriçojë përsëri.";

    private final String FILEPATH = "Files/Poesy.txt";

    public static void main(String[] args) {
        PoesyWriter poesyWriter = new PoesyWriter();
//        poesyWriter.writePoesy();
        System.out.println(poesyWriter.readPoesy());

    }

    public void writePoesy() {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILEPATH));
            writer.write(poesy);
            writer.close();
            System.out.println("Poesy written to file!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String readPoesy() {
        String result = "";
        try(BufferedReader reader = new BufferedReader(new FileReader(FILEPATH))){
            String line;
            while((line = reader.readLine()) != null){
                result += line;
                result += "\n";
            }
            reader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


}


/**

 *
 *
 *
 */
