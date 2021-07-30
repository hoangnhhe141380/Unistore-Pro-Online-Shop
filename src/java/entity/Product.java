/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;

/**
 *
 * @author Riel
 */
public class Product {

    private int id;
    private String name;
    private double price;
    private String description;
    private int quantity_stock;
    private String operating_system;
    private String display_resolution;
    private String processor;
    private String processor_technology;
    private String graphics;
    private String memory;
    private String hard_drive;
    private String wireless;
    private String power_supply;
    private String battery;
    private Category category;
    private List<Product_Image> listImage;

    public Product() {
    }

    public Product(int id, String name, double price, String description, int quantity_stock, String operating_system, String display_resolution, String processor, String processor_technology, String graphics, String memory, String hard_drive, String wireless, String power_supply, String battery, Category category, List<Product_Image> listImage) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity_stock = quantity_stock;
        this.operating_system = operating_system;
        this.display_resolution = display_resolution;
        this.processor = processor;
        this.processor_technology = processor_technology;
        this.graphics = graphics;
        this.memory = memory;
        this.hard_drive = hard_drive;
        this.wireless = wireless;
        this.power_supply = power_supply;
        this.battery = battery;
        this.category = category;
        this.listImage = listImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity_stock() {
        return quantity_stock;
    }

    public void setQuantity_stock(int quantity_stock) {
        this.quantity_stock = quantity_stock;
    }

    public String getOperating_system() {
        return operating_system;
    }

    public void setOperating_system(String operating_system) {
        this.operating_system = operating_system;
    }

    public String getDisplay_resolution() {
        return display_resolution;
    }

    public void setDisplay_resolution(String display_resolution) {
        this.display_resolution = display_resolution;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getProcessor_technology() {
        return processor_technology;
    }

    public void setProcessor_technology(String processor_technology) {
        this.processor_technology = processor_technology;
    }

    public String getGraphics() {
        return graphics;
    }

    public void setGraphics(String graphics) {
        this.graphics = graphics;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getHard_drive() {
        return hard_drive;
    }

    public void setHard_drive(String hard_drive) {
        this.hard_drive = hard_drive;
    }

    public String getWireless() {
        return wireless;
    }

    public void setWireless(String wireless) {
        this.wireless = wireless;
    }

    public String getPower_supply() {
        return power_supply;
    }

    public void setPower_supply(String power_supply) {
        this.power_supply = power_supply;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Product_Image> getListImage() {
        return listImage;
    }

    public void setListImage(List<Product_Image> listImage) {
        this.listImage = listImage;
    }
    
    public Product_Image getFirstImage(){
        return listImage.get(0);
    }
    
    public int getNumImage(){
        return listImage.size();
    }
    
}
