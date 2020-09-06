package sample;

public class Recipes {
    private Drinks drink;
    public MyList<Components> components = new MyList<>();

    //Constructor
    public Recipes(Drinks drink,MyList components){
        this.drink = drink;
        this.components = components;
    }

    //Getter and Setter
    public Drinks getDrink() {
        return drink;
    }

    public void setDrink(Drinks drink) {
        this.drink = drink;
    }

    public MyList<Components> getComponents() {
        return components;
    }

    public void setComponents(MyList<Components> components) {
        this.components = components;
    }

    //toString
    @Override
    public String toString() {
        return "Recipes{" +
                "drink=" + drink +
                ", components=" + components +
                '}';
    }
}
