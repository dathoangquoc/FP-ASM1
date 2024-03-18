import java.util.ArrayList;

public class PolicyHolder extends Customer{
    private ArrayList<Dependent> dependents;

    public PolicyHolder(String name, InsuranceCard insuranceCard) {
        super(name, insuranceCard);
        this.dependents = new ArrayList<>();
    }

    public ArrayList<Dependent> getDependents() {
        return dependents;
    }

    public void setDependents(ArrayList<Dependent> dependents) {
        this.dependents = dependents;
    }
}
