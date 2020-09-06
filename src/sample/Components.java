package sample;

//Combination of an ingredient and a measurement
public class Components {
    private int ml;
    private Ingredients ing;

    //Constructor
    public Components(int ml, Ingredients ing) {
        this.ml = ml;
        this.ing = ing;
    }

    //Getter and Setter
    public int getMl() {
        return ml;
    }

    public void setMl(int ml) {
        this.ml = ml;
    }

    public Ingredients getIng() {
        return ing;
    }

    public void setIng(Ingredients ing) {
        this.ing = ing;
    }

    //toString method for display
    @Override
    public String toString() {
        return "ml=" + ml +
                ", ing=" + ing;
    }
}
