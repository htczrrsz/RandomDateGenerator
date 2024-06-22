package stepDefinitions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPage;
import pages.RandomDateGeneratorPage;

public class RandomDateGenerator_stepDefs extends CommonPage {

    private final RandomDateGeneratorPage randomDateGeneratorPage = new RandomDateGeneratorPage();

    @When("User enters {int} dates to generate")
    public void user_enters_dates_to_generate(int amountOfDates) {
        randomDateGeneratorPage.userEntersAmountOfDates(amountOfDates);
    }

    @Then("Verify that the system created the specified number of dates")
    public void verify_that_the_system_created_the_specified_number_of_dates() {
        randomDateGeneratorPage.verifyDateAmountTheSameAsEnteredAmount();
    }

    @When("User chooses date format as {string}")
    public void user_chooses_date_format_as(String dateFormat) {
        randomDateGeneratorPage.userChooseDateFormat(dateFormat);
    }

    @When("User enters start date as {string}")
    public void user_enters_start_date_as(String expectedStartDate) {
        randomDateGeneratorPage.userEntersStartDate(expectedStartDate);
    }

    @Then("Verify that the selected start date should be the same as entered date")
    public void verify_that_the_selected_start_date_should_be_the_same_as_entered_date() {
        randomDateGeneratorPage.verifyStartDateTheSameAsEnteredDate();
    }

    @When("User enters end date as {string}")
    public void user_enters_end_date_as(String expectedEndDate) {
        randomDateGeneratorPage.userEntersEndDate(expectedEndDate);
    }

    @Then("Verify that the selected end date should be the same as entered date")
    public void verify_that_the_selected_end_date_should_be_the_same_as_entered_date() {
        randomDateGeneratorPage.verifyEndDateTheSameAsEnteredDate();
    }

    @When("User clicks on Generate Random Date button")
    public void user_clicks_on_generate_random_date_button() {
        randomDateGeneratorPage.userClicksOnGenerateRandomDateButton();
    }

    @Then("Verify that the system generated dates within the expected range")
    public void verifyThatTheSystemGeneratedDatesWithinTheExpectedRange() {
        randomDateGeneratorPage.verifyDateGeneratedAsExpected();
    }

    @Then("Verify that the system does not allow generating the start year be later than the end year")
    public void verify_that_the_system_does_not_allow_generating_the_start_year_be_later_than_the_end_year() {
      randomDateGeneratorPage.verifyRandomDateNotGenerated();
    }

}
