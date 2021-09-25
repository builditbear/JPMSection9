package com.company;

import java.util.ArrayList;
import java.util.List;

// Represents the basic fields of an order for contact lenses. Written for Lesson 125's Interfaces Challenge as a
// test implementation of the Saveable interface.
public class clOrder implements Saveable{
    private String manufacturer;
    private String brand;
    private String model;
    private int baseCurve;
    private int diameter;
    private int quantity;

    public clOrder(String manufacturer, String brand, String model, int baseCurve, int diameter, int quantity) {
        this.manufacturer = manufacturer;
        this.brand = brand;
        this.model = model;
        this.baseCurve = baseCurve;
        this.diameter = diameter;
        this.quantity = quantity;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getBaseCurve() {
        return baseCurve;
    }

    public void setBaseCurve(int baseCurve) {
        this.baseCurve = baseCurve;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public List<String> write() {
        // Store all fields in list.
        ArrayList<String> writeBuffer = new ArrayList<>();
        writeBuffer.add(manufacturer);
        writeBuffer.add(brand);
        writeBuffer.add(model);
        writeBuffer.add(Integer.toString(baseCurve));
        writeBuffer.add(Integer.toString(diameter));
        writeBuffer.add(Integer.toString(quantity));
        return writeBuffer;
    }

    @Override
    public String toString() {
        return "clOrder{" +
                "manufacturer='" + manufacturer + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", baseCurve=" + baseCurve +
                ", diameter=" + diameter +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public void read(List<String> file) {
        if(file.size() == 6){
            manufacturer = file.get(0);
            brand = file.get(1);
            model = file.get(2);
            baseCurve = Integer.parseInt(file.get(3));
            diameter = Integer.parseInt(file.get(4));
            quantity = Integer.parseInt(file.get(5));
        }else{
            System.out.println("Improperly formatted read file! Data does not match number of fields.");
        }
    }
}
