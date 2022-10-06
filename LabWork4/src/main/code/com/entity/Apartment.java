package main.code.com.entity;

import java.io.Serializable;

public class Apartment implements Identifiable, Serializable {
    private int id;
    private String status;
    private String type;
    private int numberOfRooms ;
    private int apartmentNumber;
    private int numberOfBeds;
    private double price;
    private String photo;

    public Apartment() {
    }

    public Apartment(int id, String status, String type, int numberOfRooms, int apartmentNumber, int numberOfBeds, double price,String photo) {
        this.id = id;
        this.status = status;
        this.type = type;
        this.numberOfRooms = numberOfRooms;
        this.apartmentNumber = apartmentNumber;
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.photo=photo;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;

        Apartment apartment = (Apartment) o;
        return id == apartment.id &&
                status.equals(apartment.status) &&
                type.equals(apartment.type) &&
                numberOfBeds == apartment.numberOfBeds &&
                numberOfRooms == apartment.numberOfRooms &&
                apartmentNumber==apartment.apartmentNumber &&
                price == apartment.price &&
                photo.equals(apartment.photo);

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result +  id;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + numberOfRooms;
        result = prime * result + numberOfBeds;
        result = prime * result + apartmentNumber;
        result = prime * result + (int) price;
        result = prime * result + ((photo == null) ? 0 : photo.hashCode());
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder("Product{");
        result.append("id=").append(id);
        result.append(", type=").append(type);
        result.append(", status=").append(status);
        result.append(", numberOfRooms='").append(numberOfRooms).append('\'');
        result.append(", numberOfBeds='").append(numberOfBeds).append('\'');
        result.append(", apartmentNumber='").append(apartmentNumber).append('\'');
        result.append(", price=").append(price);
        result.append(", photo=").append(photo);
        result.append('}');
        return result.toString();
    }
}
