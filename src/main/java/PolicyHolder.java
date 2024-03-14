import java.util.ArrayList;

public class PolicyHolder extends Customer{
    ArrayList<Dependent> dependents;

    public PolicyHolder(String name, InsuranceCard insuranceCard) {
        super(name, insuranceCard);
        this.dependents = new ArrayList<Dependent>();
    }

    void AddDependent(){

    }
}
