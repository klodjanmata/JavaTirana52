package CarRentalSystem.Repository;

import CarRentalSystem.Entitiy.*;
import CarRentalSystem.Service.VehicleType;

import java.io.*;
import java.util.HashMap;

public class VehicleRepository {
    private final String FILEPATH = "CarRentalFiles/Vehicles.csv";
    private final String SEPARATOR = ",";

    public HashMap<String, Vehicle> readFromFile() {
        HashMap<String, Vehicle> vehiclesMap = new HashMap<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(FILEPATH))){
            reader.readLine();
            String line;
            while((line = reader.readLine()) != null) {
                String[] fields = line.split(SEPARATOR);
                if (VehicleType.valueOf(fields[0]) == VehicleType.CAR) {
                    Car car = new Car();
                    car.setVehicleType(VehicleType.valueOf(fields[0]));
                    car.setVin(fields[1]);
                    car.setLicensePlate(fields[2]);
                    car.setMake(fields[3]);
                    car.setModel(fields[4]);
                    car.setYear(Integer.parseInt(fields[5]));
                    car.setColor(fields[6]);
                    car.setSeats(Integer.parseInt(fields[7]));
                    car.setMinPricePerDay(Integer.parseInt(fields[8]));
                    car.setMinNumberOfDays(Integer.parseInt(fields[9]));
                    car.setAvailable(Boolean.parseBoolean(fields[10]));
                    car.setEngineType(EngineType.valueOf(fields[11]));
                    car.setNumberOfDoors(Integer.parseInt(fields[12]));
                    car.setHasSunroof(Boolean.parseBoolean(fields[13]));
                    car.setBodyType(BodyType.valueOf(fields[14]));
                    car.setHasNavigation(Boolean.parseBoolean(fields[15]));
                    car.setTransmission(Transmission.valueOf(fields[16]));
                    vehiclesMap.put(car.getLicensePlate(), car);
                }
                if (VehicleType.valueOf(fields[0]) == VehicleType.MOTORCYCLE) {

                }
            }
            reader.close();
            System.out.println("Successfully read vehicles from the file.");
        }catch (Exception e){
            e.printStackTrace();
        }
        return vehiclesMap;
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

    private String getHeadline(){
        return "Vehicle Type,Vin,License Plate,Make,Model,Year,Color,Seats,Min Price,Min Days,Available," +
                "Engine Type,Number Of Doors,Sunroof,Body Type,Navigation,Transmission";
    }
}
