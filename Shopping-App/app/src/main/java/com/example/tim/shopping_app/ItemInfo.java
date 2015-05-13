package com.example.tim.shopping_app;

/**
 * Created by Tim on 4/22/2015.
 */
public class ItemInfo {

    private double price;
    private String name;
    private String sDescription;



    public ItemInfo() {

    }

    public ItemInfo(double price, String name, String sDescription) {
        this.name = name;
        this.price = price;
        this.sDescription = sDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getsDescripton()
    {
        return sDescription;
    }
    public void setsDescription(String sDescription)
    {
        this.sDescription = sDescription;
    }


    @Override
    public String toString() {
        return name +
                "\nPrice: $" + price;
    }

    public String getInfo() {
        return sDescription;


    }
}
