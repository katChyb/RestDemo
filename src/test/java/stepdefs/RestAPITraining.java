package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RestAPITraining {
    @Given("As a teacher")
    public void as_a_teacher() {
        System.out.println("as a techer");
    }

    @When("I am searching for student")
    public void i_am_searching_for_student() {
        System.out.println("i_am_searching_for_student");
    }

    @Then("I am getting student details")
    public void i_am_getting_student_details() {
        System.out.println("i_am_getting_student_details");
    }
}
