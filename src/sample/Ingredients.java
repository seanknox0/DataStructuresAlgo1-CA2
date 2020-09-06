package sample;

public class Ingredients {
    public String name;
    public String desc;
    public double ABV;

    //Constructor
    public Ingredients(String name, String desc, double ABV){
        this.name =name;
        this.desc = desc;
        this.ABV = ABV;
    }

    //Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getABV() {
        return ABV;
    }

    public void setABV(double ABV) {
        this.ABV = ABV;
    }

    /*public int compareTo(Ingredients i) {
        return this.getName().compareTo(i.getName());
    }*/

    //toString
    @Override
    public String toString() {
        return name;
    }
}
