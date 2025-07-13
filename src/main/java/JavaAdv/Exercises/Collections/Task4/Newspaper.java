package JavaAdv.Exercises.Collections.Task4;

import java.util.Date;

public class Newspaper {
    private String serialNumber;
    private String publisher;
    private String title;
    private Date releaseDate;

    public Newspaper(String serialNumber, String publisher, String title, Date releaseDate) {
        this.serialNumber = serialNumber;
        this.publisher = publisher;
        this.title = title;
        this.releaseDate = releaseDate;
    }

    public Newspaper(){}

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
