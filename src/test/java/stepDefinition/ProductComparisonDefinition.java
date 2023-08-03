package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObject.CompareProducts;

import java.time.Duration;

public class ProductComparisonDefinition {
    private static WebDriver driver;
    public final static int TIMEOUT = 10;

    public CompareProducts compareProducts;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        driver.manage().window().maximize();
    }

    @Given("The user must be on the Home page {string}")
    public void the_user_must_be_on_the_home_page(String url) {
        driver.get(url);
    }

    @Given("The user identified {string} as their product of interest")
    public void userIdentifiedItemAsTheirProductOfInterest(String productName) {
        compareProducts = new CompareProducts(driver);
        compareProducts.userIdentifiesProductOfInterest(productName);
    }

    @When("the user hover over the {string} and clicks on the add to compare button")
    public void theUserHoversOverAndClicksTheAddToCompareButton(String productName) {
        compareProducts = new CompareProducts(driver);
        compareProducts.hoverOverAndClickAddToCompare(productName);
    }

    @When("the user clicks on the {string} image")
    public void theUserClicksOnTheImage(String product){
        compareProducts = new CompareProducts(driver);
        compareProducts.clicksOnItemImage(product);
    }

    @When("the user clicks on the {string} name")
    public void theUserClicksOnTheItemName(String product){
        compareProducts = new CompareProducts(driver);
        compareProducts.clicksOnItemName(product);
    }

    @And("the user clicks Add to compare")
    public void theUserClicksAddToCompare(){
        compareProducts = new CompareProducts(driver);
        compareProducts.clicksOnTheAddToCompare();
    }

    @Then("a confirmation message, {string} should be displayed")
    public void confirmationMessageShouldBeDisplayed(String expectedMessage) {
        compareProducts = new CompareProducts(driver);
        String actualMessage = compareProducts.getConfimationMessage();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @And("the user clicks on the comparison list link from the confirmation message")
    public void userClicksOnTheComparisonListLink(){
        compareProducts = new CompareProducts(driver);
        compareProducts.clicksOnCompareListFromLink();
    }

    @And("the user clicks on the remove icon")
    public void userClicksOnTheRemoveIcon(){
        compareProducts = new CompareProducts(driver);
        compareProducts.clicksOnTheRemoveIconForItem();
    }

    @And("the user select {string} from the confirmation alert")
    public void theUserSelectConfirmationAlertOption(String option) {
        compareProducts = new CompareProducts(driver);
        compareProducts.handleConfirmationAlert(option);
    }

    @And("the {string} should be added in the compare products screen")
    public void theItemShouldBeAddedInTheCompareProductsScreen(String productName) {
        compareProducts = new CompareProducts(driver);
        Assert.assertTrue(compareProducts.isProductAddedToCompare(productName));
    }

    @Then("the {string} should be removed from the compare list")
    public void theProductShouldBeRemovedFromCompareList(String productName) {
        compareProducts = new CompareProducts(driver);
        Assert.assertFalse(compareProducts.isProductAddedToCompare(productName));
    }


    @After
    public void teardown() {
        driver.quit();
    }
}
