package CarRentalSystem.Entitiy;

import java.util.Date;

public class Rental {
    private int Id;
    private String clientId;
    private String licensePlate;
    private int pricePerDay;
    private int numberOfDays;
    private Date startDate;
    private Date returnDate;
    private int totalPrice;
    private boolean paid;

    public Rental(){}

    public Rental(int id, String clientId, boolean paid, int totalPrice, Date returnDate,
                  Date startDate, int numberOfDays, int pricePerDay, String licensePlate) {
        this.Id = id;
        this.clientId = clientId;
        this.paid = paid;
        this.totalPrice = totalPrice;
        this.returnDate = returnDate;
        this.startDate = startDate;
        this.numberOfDays = numberOfDays;
        this.pricePerDay = pricePerDay;
        this.licensePlate = licensePlate;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
