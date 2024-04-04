package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
    @Given("I have a sample code to run")
    public void i_have_a_sample_code_to_run() {
        System.out.println("hello");
    }

    @When("I print {string}")
    public void i_print(String string) {
        System.out.println(string);
    }

    @Then("I verify {string} is printed")
    public void i_verify_is_printed(String string) {
        System.out.println(string);
    }

    @Then("I will check if status code is {int}")
    public void i_will_check_if_status_code_is(Integer int1) {
        System.out.println(int1);
    }
}
