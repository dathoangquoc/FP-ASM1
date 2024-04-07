/**
 * @author <Hoang Quoc Dat - s3979331>
 */

import java.io.Serializable;
import java.util.ArrayList;

public class PolicyHolder extends Customer implements Serializable {
    private ArrayList<Dependent> dependents;

    public PolicyHolder(String name, String cardNum) {
        super(name, cardNum);
        this.dependents = new ArrayList<>();
    }

    public ArrayList<Dependent> getDependents() {
        return dependents;
    }

    protected void addDependent(Dependent dependent) {
        this.dependents.add(dependent);
    }
    protected void setDependents(ArrayList<Dependent> dependents) {
        this.dependents = dependents;
    }
}
