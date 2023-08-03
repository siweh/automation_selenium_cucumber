package pageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class CompareProducts {
    public static JavascriptExecutor jse;
//    public WebDriverWait wait;

    public CompareProducts(WebDriver driver) {
        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    private static WebDriver driver;

    By addedProductLocator = By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]");
    By confirmationMessageLocator = By.xpath("(//div[@class='message-success success message'])[1]");

    public void waitForElement(){
        try {
            Thread.sleep(3000); // Wait for 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void userIdentifiesProductOfInterest(String product){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        driver.findElement(By.xpath("//a[normalize-space()='" + product + "']"));
    }

    public void hoverOverAndClickAddToCompare(String product){
        WebElement itemName = driver.findElement(By.xpath("//a[normalize-space()='" + product + "']"));
        Actions actions = new Actions(driver);

        actions.moveToElement(itemName).perform();
        driver.findElement(By.xpath("//a[@class='action tocompare']")).click();
    }

    public void clicksOnItemImage(String product){
        driver.findElement(By.xpath("//img[@alt='Breathe-Easy Tank']")).click();
    }

    public void clicksOnItemName(String product){
        driver.findElement(By.xpath("//a[normalize-space()='Argus All-Weather Tank']")).click();
    }

    public void clicksOnTheAddToCompare(){
        driver.findElement(By.xpath("(//a[@class='action tocompare'])[1]")).click();
    }

    public void clicksOnCompareListFromLink(){
        waitForElement();
        driver.findElement(By.xpath("//a[normalize-space()='comparison list']")).click();
    }

    public void handleConfirmationAlert(String option) {
        waitForElement();
        Alert alert = driver.switchTo().alert();
        if (option.equalsIgnoreCase("OK")) {
            alert.accept();
        } else if (option.equalsIgnoreCase("Cancel")) {
            alert.dismiss();
        } else {
            throw new IllegalArgumentException("Invalid option. Only 'OK' or 'Cancel' are allowed.");
        }
    }
    public void clicksOnTheRemoveIconForItem(){
        driver.findElement(By.xpath("//a[@title='Remove Product']")).click();
    }
    public String getConfimationMessage(){
//        driver.navigate().refresh();
//        waitForElement();
        return driver.findElement(confirmationMessageLocator).getText();
    }

    public boolean isProductAddedToCompare(String productName) {
        return driver.findElements(addedProductLocator).size() > 0;
    }



}
