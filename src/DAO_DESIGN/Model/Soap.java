package DAO_DESIGN.Model;

public class Soap {
    private int Soapid;
    private String name;
    private double price;

    public Soap(){

    }

    public Soap(int soapid, String name, double price) {
        this.Soapid = soapid;
        this.name = name;
        this.price = price;
    }

    public int getSoapid() {
        return Soapid;
    }

    public void setSoapid(int soapid) {
        Soapid = soapid;
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
}
