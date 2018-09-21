package DAO_DESIGN.Model;

public class Softner {
    private int Softerid;
    private String name;
    private double price;

    public Softner(){

    }

    public Softner(int softerid, String name, double price) {
        Softerid = softerid;
        this.name = name;
        this.price = price;
    }

    public int getSofterid() {
        return Softerid;
    }

    public void setSofterid(int softerid) {
        Softerid = softerid;
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
