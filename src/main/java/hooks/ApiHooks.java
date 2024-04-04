package hooks;

import io.cucumber.java.*;

public class ApiHooks {

    @Before("@bug")
    public void beforeAll() {
        System.out.println("before bug scenarios");
    }

    @BeforeStep("@bug")
    public void beforeAllSteps() {
        System.out.println("before each steps");
    }

    @AfterStep("@bug")
    public void afterAllSteps() {
        System.out.println("after each steps");
    }

}
