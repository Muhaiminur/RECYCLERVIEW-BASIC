package com.example.abir.recyclerview;

/**
 * Created by ABIR on 3/12/2018.
 */

public class Store {
    String Shopname,owner,address,mbl;

    @Override
    public String toString() {
        return "Store{" +
                "Shopname='" + Shopname + '\'' +
                ", owner='" + owner + '\'' +
                ", address='" + address + '\'' +
                ", mbl='" + mbl + '\'' +
                '}';
    }

    public Store() {
    }

    public Store(String shopname, String owner, String address, String mbl) {
        Shopname = shopname;
        this.owner = owner;
        this.address = address;
        this.mbl = mbl;
    }

    public String getShopname() {
        return Shopname;
    }

    public void setShopname(String shopname) {
        Shopname = shopname;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMbl() {
        return mbl;
    }

    public void setMbl(String mbl) {
        this.mbl = mbl;
    }
}
