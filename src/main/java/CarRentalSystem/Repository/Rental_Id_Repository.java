package CarRentalSystem.Repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Rental_Id_Repository {
    private final String FILEPATH = "CarRentalFiles/Rental_ID.txt";

    public void saveId(int id){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILEPATH))){
            writer.write(Integer.toString(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int readId(){
        try(BufferedReader reader = new BufferedReader(new FileReader(FILEPATH))){
            return Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
