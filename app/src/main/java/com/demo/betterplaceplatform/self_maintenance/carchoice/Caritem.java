package com.demo.betterplaceplatform.self_maintenance.carchoice;

/**
 * Created by starnamu on 2015-07-15.
 */
public class Caritem {

    int CarPicture;
    String PartName;
    String Price;

    public Caritem(int carPicture, String partName, String price) {
        CarPicture = carPicture;
        PartName = partName;
        Price = price;
    }

    public int getCarPicture() {
        return CarPicture;
    }

    public void setCarPicture(int carPicture) {
        CarPicture = carPicture;
    }

    public String getPartName() {
        return PartName;
    }

    public void setPartName(String partName) {
        PartName = partName;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
