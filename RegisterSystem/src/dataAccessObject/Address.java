/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccessObject;

/**
 *
 * @author eliasc
 */
public class Address {
    private int addressID;
    private int houseNo;
    private String streetName;
    private String city;
    private int postalCode;

    public Address() {
    }

    public Address(int addressID, int houseNo, String streetName, String city, int postalCode) {
        this.addressID = addressID;
        this.houseNo = houseNo;
        this.streetName = streetName;
        this.city = city;
        this.postalCode = postalCode;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public int getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
    
    
}
