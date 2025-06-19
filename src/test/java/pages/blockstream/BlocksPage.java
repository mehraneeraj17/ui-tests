package pages.blockstream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BlocksPage {
    private final WebDriver driver;
    private WebDriverWait wait;

    public BlocksPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
    }


    private final By blockTransactionCount = By.cssSelector(".transactions h3");
    private final By transactionBoxes = By.cssSelector("#transaction-box");
    private final By transactionBoxesInputs = By.cssSelector(".ins-and-outs .vins .vin");
    private final By transactionBoxesOutputs = By.cssSelector(".ins-and-outs .vouts .vout");
    private final By transactionHashName = By.cssSelector("div.header a");


    public String getBlockTransactionCount() {
        return driver.findElement(blockTransactionCount).getText();
    }

    public List<WebElement> getTransactionBoxes() {
        return driver.findElements(transactionBoxes);
    }

    public List<WebElement> getTransactionBoxesInputs(WebElement transactionBox) {

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(transactionBoxesInputs));
        return transactionBox.findElements(transactionBoxesInputs);
    }

    public List<WebElement> getTransactionBoxesOutputs(WebElement transactionBox) {
        return transactionBox.findElements(transactionBoxesOutputs);
    }

    public String getTransactionHash(WebElement transactionBox) {
        return transactionBox.findElement(transactionHashName).getText();
    }
}
