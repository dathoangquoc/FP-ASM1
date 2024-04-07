/**
 * @author <Hoang Quoc Dat - s3979331>
 */

import java.io.Serializable;

public class Dependent extends Customer implements Serializable {
    public Dependent(String name, String cardNum) {
        super(name, cardNum);
    }

}
