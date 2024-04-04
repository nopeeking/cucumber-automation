import org.testng.annotations.*;

public class ApiTestsTwo {

    @Test
    @Parameters({"env"})
    public void  test(@Optional String env) {
        //This is a GET Api call which uses one param which is student name
        System.out.println("Sample @Test");
        System.out.println("Environment is: " + env);

        if (env.equals("qa")) {
            System.out.println("Tests are running on QA environment");
        }
    }

    @BeforeSuite
    public void  beforeSuite() {
        // related to framework/suite level (one time use)
        System.out.println("This will run before suite - @BeforeSuite");
    }

    @BeforeClass
    public void  beforeClass() {
        System.out.println("This will run before class - @BeforeClass");
    }

}
