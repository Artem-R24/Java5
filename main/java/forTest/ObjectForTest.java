package forTest;

import com.company.AutoInjectable;

public class ObjectForTest {

    @AutoInjectable
    private TestInterface field1;

    @AutoInjectable
    private TestObject field2;

    public String toString() {
        return "field1: " + field1.getName() + "; field2: " + field2.getName();
    }

}
