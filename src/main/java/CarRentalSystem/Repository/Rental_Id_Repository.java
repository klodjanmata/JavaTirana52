package CarRentalSystem.Repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Rental_Id_Repository {
    private final String FILEPATH = "CarRentalFile/Rental_ID.txt";

    public void saveId(int id){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILEPATH))){
            writer.write(id);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int readId(){
        try(BufferedReader reader = new BufferedReader(new FileReader(FILEPATH))){
            int id = Integer.parseInt(reader.readLine());
            reader.close();
            return  id;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
