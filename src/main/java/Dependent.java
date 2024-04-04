import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Dependent extends Customer implements Serializable {
    public Dependent(String name, String cardNum) {
        super(name, cardNum);
    }

}
