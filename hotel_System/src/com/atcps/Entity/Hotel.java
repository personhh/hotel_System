package com.atcps.Entity;

public class Hotel {
    private String id;
    private String hotel_name;
    private String hotel_price;
    private String hotel_location;
    private String hotel_photo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getHotel_price() {
        return hotel_price;
    }

    public void setHotel_price(String hotel_price) {
        this.hotel_price = hotel_price;
    }

    public String getHotel_location() {
        return hotel_location;
    }

    public void setHotel_location(String hotel_location) {
        this.hotel_location = hotel_location;
    }

    public String getHotel_photo() {
        return hotel_photo;
    }

    public void setHotel_photo(String hotel_photo) {
        this.hotel_photo = hotel_photo;
    }

    public Hotel() {
    }

    public Hotel(String id , String hotel_name, String hotel_price, String hotel_location,String hotel_photo) {
        this.id = id;
        this.hotel_name = hotel_name;
        this.hotel_price = hotel_price;
        this.hotel_location = hotel_location;
        this.hotel_photo = hotel_photo;
    }

    public Hotel(String id, String hotel_name, String hotel_price, String hotel_location) {
        this.id = id;
        this.hotel_name = hotel_name;
        this.hotel_price = hotel_price;
        this.hotel_location = hotel_location;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id='" + id + '\'' +
                ", hotel_name='" + hotel_name + '\'' +
                ", hotel_price='" + hotel_price + '\'' +
                ", hotel_location='" + hotel_location + '\'' +
                ", hotel_photo='" + hotel_photo + '\'' +
                '}';
    }
}
