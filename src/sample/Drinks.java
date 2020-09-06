package sample;

public class Drinks {
    String name;
    String origin;
    String desc;
    String image;

    //Constructor
    public Drinks(String name, String origin, String desc, String image) {
        this.name = name;
        this.origin = origin;
        this.desc = desc;
        this.image = image;
    }

    //Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    //toString
    @Override
    public String toString() {
        return name;
    }
}
