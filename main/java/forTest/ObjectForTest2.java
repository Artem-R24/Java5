package forTest;

import com.company.AutoInjectable;

public class ObjectForTest2 {

    @AutoInjectable
    private Test2Interface field1;

    @AutoInjectable
    private Test2Object field2;

    public String toString() {
        return "field1: " + field1.getName() + "; field2: " + field2.getName();
    }
}
