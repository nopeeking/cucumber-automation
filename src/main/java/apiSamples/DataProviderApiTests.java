package apiSamples;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;


//Pojo class as a request for API call can be sent in data provider
public class DataProviderApiTests {

    @DataProvider(name = "dp1")
    public Object[][] dataProvider() {
        return new Object[][] {
                {"John", "1234"},
                {"John", "1234"},
                {"John", "1234"}
        };
    }

    @Test(dataProvider = "dp1")
    public void test(String name, String id) {
        System.out.println("This is a sample test");
        System.out.println("Student name is " + name);
        System.out.println("Student id is " + id);
    }
}
