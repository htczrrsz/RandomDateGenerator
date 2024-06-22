package pages;

import org.openqa.selenium.support.PageFactory;

import static stepDefinitions.Hooks.driver;

public abstract class CommonPage {

    public CommonPage() {
        PageFactory.initElements(driver, this);
    }

    private RandomDateGeneratorPage randomDateGeneratorPage;

    public RandomDateGeneratorPage getRandomDateGeneratorPage(){
        if (randomDateGeneratorPage==null){
            randomDateGeneratorPage = new RandomDateGeneratorPage();
        }
        return randomDateGeneratorPage;
    }
}
