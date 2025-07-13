package JavaAdv.Exercises.Collections.Task4;


import JavaAdv.Exercises.Helper;

import java.util.HashMap;

public class NewspaperService {
    private HashMap<String, Newspaper> newsMap;

    public void addNewspaper(Newspaper newspaper){
        if (newspaper == null) {
            System.out.println("Newspaper is null! CANNOT ADD NEWSPAPER!");
            return;
        }
        if (newspaper.getSerialNumber() == null || newspaper.getSerialNumber().isEmpty()) {
            System.out.println("Newspaper serialNumber is null! CANNOT ADD NEWSPAPER!");
            return;
        }
        if (this.newsMap.containsKey(newspaper.getSerialNumber())){
            System.out.println("Newspaper already exist! CANNOT ADD NEWSPAPER!");
            return;
        }
        this.newsMap.put(newspaper.getSerialNumber(), newspaper);
    }

    public void addNewspaperFromUser() {
        Newspaper newspaper = new Newspaper();
        System.out.println("Enter necessary values: ");
        newspaper.setSerialNumber(Helper.getStringFromUser("SerialNumber"));
        if (newspaper.getSerialNumber() == null || newspaper.getSerialNumber().isEmpty()) {}
        // Kontroll numrit serial
        newspaper.setTitle(Helper.getStringFromUser("Title"));
        newspaper.setPublisher(Helper.getStringFromUser("Publisher"));

        addNewspaper(newspaper);
    }


    public NewspaperService(HashMap<String, Newspaper> newsMap) {
        this.newsMap = newsMap;
    }

    public NewspaperService() {
        this.newsMap = new HashMap<>();
    }

    public HashMap<String, Newspaper> getNewsMap() {
        return newsMap;
    }

    public void setNewsMap(HashMap<String, Newspaper> newsMap) {
        this.newsMap = newsMap;
    }
}
