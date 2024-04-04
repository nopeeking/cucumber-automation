package apiSamples;

import org.testng.annotations.*;

public class ApiTestsThree {

    //@BeforeClass -- Will run before testng xml class
    //@BeforeSuite -- Will run before testng xml suite
    //@BeforeTest -- Will run before testng xml test
    //@BeforeMethod -- Will run before every xml method

    //You need session id before tests

    @Test
    public void  test() {
        System.out.println("Sample @Test");
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

    @BeforeTest
    public void  beforeTest() {
        System.out.println("This will run before test - @BeforeTest");
    }

    @BeforeMethod
    public void  beforeMethod() {
        System.out.println("This will run before method - @BeforeMethod");
    }

    //tearDown methods
    //@AfterMethod
    //@AfterTest
    //@AfterClass
    //@AfterSuite

    @AfterClass
    public void afterClass() {
        System.out.println("This will run after class - @AfterClass");
    }

    @AfterSuite
    public void afterSuite() {
        //Close db calls, store reports etc
        System.out.println("This will run after suite - @AfterSuite");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("This will run after method - @AfterMethod");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("This will run after test - @AfterTest");
    }

}
