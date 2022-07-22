package com.ornikar.api.stepdefs;

        import com.ornikar.api.services.DummyService;
        import com.ornikar.api.utils.json.EmployeeParent;
        import io.cucumber.java.en.And;
        import io.cucumber.java.en.Then;
        import io.cucumber.java.en.When;
        import io.cucumber.spring.CucumberContextConfiguration;
        import io.restassured.response.ValidatableResponse;
        import org.springframework.beans.factory.annotation.Value;
        import org.springframework.boot.test.context.SpringBootTest;

        import java.io.IOException;

@SpringBootTest
@CucumberContextConfiguration

public class Dummy {

    private DummyService dummyService;
    private ValidatableResponse validatableResponse;
    private String employee_salary;
    private String verificationTokenOut;
    private String firstnameOut;

    @Value("${test.property}")
    private String value;

    public Dummy (DummyService dummyService) {
        this.dummyService = dummyService;
    }

    @When("I send a GET request to the URL")
    public void iSendAGETRequestToTheURL() {
        System.out.println(value);
        validatableResponse = dummyService.getAllEmployeesRequest();
    }

    @Then("^The request will return (\\d+)$")
    public void the_request_will_return(int statusCode) {
        validatableResponse.assertThat().statusCode(statusCode);
    }


    @And("The response should have employee_salary")
    public void theResponseShouldHaveEmployee_salary() {
        String responseJson = validatableResponse.extract().asPrettyString();
        if (responseJson != null) {
            try {
                employee_salary = dummyService.mapperResponse(responseJson, EmployeeParent.class).getData().get(0).getEmployee_salary();
                System.out.print("employee_salary:" + employee_salary);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
