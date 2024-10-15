package pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;


@Getter
public class RandomDateGeneratorPage extends CommonPage {

    private int dateAmount;
    private String endDate;
    private String startDate;
    private String dateFormatIs;


    @FindBy(css = "#count")
    private WebElement howManyDatesToGenerateInputArea;

    @FindBy(xpath = "//select[@id='format']")
    private WebElement dateFormatInputArea;

    @FindBy(css = "#custom-format")
    private WebElement customDateFormatInputArea;

    @FindBy(css = "#start")
    private WebElement startDateInputArea;

    @FindBy(css = "#end")
    private WebElement endDateInputArea;

    @FindBy(css = "#generatedRandomDateTextArea")
    private WebElement generatedRandomDateTextArea;

    @FindBy(xpath = "//button[@class='button is-primary is-large mt-4']")
    private WebElement generateRandomDateButton;

    @FindBy(xpath = "//button[@onclick='copyGeneratedRandomDate();']")
    private WebElement copyGeneratedRandomDateButton;

    @FindBy(xpath = "//button[@onclick='downloadGeneratedData();']")
    private WebElement downloadGeneratedRandomDateButton;


    public void userEntersAmountOfDates(int amountOfDates) {
        howManyDatesToGenerateInputArea.clear();
        howManyDatesToGenerateInputArea.sendKeys(Integer.toString(amountOfDates));
        dateAmount = amountOfDates;
    }

    public void userChooseDateFormat(String dateFormat) {
        Select dropdownMenu = new Select(dateFormatInputArea);
        dropdownMenu.selectByVisibleText(dateFormat);
        dateFormatIs = dateFormat;
    }

    public void userEntersStartDate(String expectedStartDate) {
        startDateInputArea.clear();
        startDateInputArea.sendKeys(expectedStartDate);
        startDate = expectedStartDate;
    }

    public void userEntersEndDate(String expectedEndDate) {
        endDateInputArea.clear();
        endDateInputArea.sendKeys(expectedEndDate);
        endDate = expectedEndDate;
    }

    public void userClicksOnGenerateRandomDateButton() {
        generateRandomDateButton.click();
        dateList();
        System.out.println("dateList().toString() = " + dateList().toString());
    }

    public void verifyDateAmountTheSameAsEnteredAmount() {
        assertEquals(howManyDatesToGenerateInputArea.getAttribute("value"), Integer.toString(dateAmount));
    }

    public void verifyStartDateTheSameAsEnteredDate() {
//        System.out.println("startDateInputArea.getAttribute(\"value\") = " + startDateInputArea.getAttribute("value"));
        assertEquals(startDate, startDateInputArea.getAttribute("value"));
    }

    public void verifyEndDateTheSameAsEnteredDate() {
        assertEquals(endDate, endDateInputArea.getAttribute("value"));
    }

    public List<String> dateList() {
        String dates = generatedRandomDateTextArea.getAttribute("value");
        String[] datesArray = dates.split("\n");
        List<String> datesList = new ArrayList<>();
        for (String date : datesArray) {
            datesList.add(date);
        }
        return datesList;
    }

    public void verifyRandomDateNotGenerated() {
        assertTrue(dateList().isEmpty());
    }


    public void verifyDateGeneratedAsExpected() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter generatedFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");

        try {
            LocalDate startDateTime = LocalDate.parse(startDate, formatter);
            LocalDate endDateTime = LocalDate.parse(endDate, formatter);
            for (String date : dateList()) {
                LocalDate dateTime = LocalDate.parse(date, generatedFormatter);
                assertTrue((dateTime.isAfter(startDateTime)) || dateTime.isEqual(startDateTime) &&
                        (dateTime.isBefore(endDateTime) || dateTime.isEqual(endDateTime)));
            }
        } catch (DateTimeParseException e) {
            System.out.println("Wrong date format " + e.getMessage());
        }
    }
    //draft deneme

}


