package CarRentalSystem.Repository;

import CarRentalSystem.Entitiy.*;
import CarRentalSystem.Service.VehicleType;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class VehicleRepository {
    private final String FILEPATH = "CarRentalFiles/Vehicles.csv";
    private final String SEPARATOR = ",";

    private void writeVehicleGeneralFields(Vehicle v, BufferedWriter writer) {
        try {
            writer.write(v.getVehicleType() + SEPARATOR);
            writer.write(v.getVin() + SEPARATOR);
            writer.write(v.getLicensePlate() + SEPARATOR);
            writer.write(v.getMake() + SEPARATOR);
            writer.write(v.getModel() + SEPARATOR);
            writer.write(v.getYear() + SEPARATOR);
            writer.write(v.getColor() + SEPARATOR);
            writer.write(v.getSeats() + SEPARATOR);
            writer.write(v.getMinPricePerDay() + SEPARATOR);
            writer.write(v.getMinNumberOfDays() + SEPARATOR);
            writer.write(v.isAvailable() + SEPARATOR);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void writeCarSpecificFields(Car car, BufferedWriter writer) {
        try{
            writer.write(car.getEngineType() + SEPARATOR);
            writer.write(car.getNumberOfDoors() + SEPARATOR);
            writer.write(car.isHasSunroof() + SEPARATOR);
            writer.write(car.getBodyType() + SEPARATOR);
            writer.write(car.isHasNavigation() + SEPARATOR);
            writer.write(car.getTransmission() + SEPARATOR);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void writeToFile(HashMap<String, Vehicle> vehicleHashMap){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILEPATH))){
            writer.write(getHeadline());
            for(Vehicle v : vehicleHashMap.values()){
                writer.newLine();
                writeVehicleGeneralFields(v, writer);
                if (v.getVehicleType() == VehicleType.CAR) {
                    writeCarSpecificFields((Car) v, writer);
                }
                if (v.getClass().isInstance(Motorbike.class)) {
                    Motorbike motorbike = (Motorbike) v;
                }
                if(v.getClass().isInstance(MiniBuss.class)){
                    MiniBuss miniBuss = (MiniBuss) v;
                }

            }
            writer.close();
            System.out.println("Successfully wrote vehicles to the file.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getHeadline(){
        return "Vehicle Type,Vin,License Plate,Make,Model,Year,Color,Seats,Min Price,Min Days,Available," +
                "Engine Type,Number Of Doors,Sunroof,Body Type,Navigation,Transmission";
    }
}
