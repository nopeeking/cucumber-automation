package step_definitions;

import io.cucumber.java.en.Given;

import java.util.Map;
import java.util.List;

public class ApiStepDefinitions {
    @Given("a new student has been created with the following request")
    public void a_new_student_has_been_created_with_the_following_request(List<Map<String, String>> requestMapsFromFeatureFiles) {
        requestMapsFromFeatureFiles.forEach( map -> {
            System.out.println(map.get("name"));
            System.out.println(map.get("email"));
            System.out.println(map.get("id"));
        });
    }
}
