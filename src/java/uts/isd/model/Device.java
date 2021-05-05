/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;

import java.io.Serializable;

/**
 *
 * @author 61452
 */
public class Device implements Serializable{
    private String name;
    private String manufacturer;
    private String origin;
    private String instock;
    private int numberinstock;

    public Device(String name, String manufacturer, String origin, String instock, int numberinstock) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.origin = origin;
        this.instock = instock;
        this.numberinstock = numberinstock;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getOrigin() {
        return origin;
    }

    public String getInstock() {
        return instock;
    }

    public int getNumberinstock() {
        return numberinstock;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setInstock(String instock) {
        this.instock = instock;
    }

    public void setNumberinstock(int numberinstock) {
        this.numberinstock = numberinstock;
    }
    
}
