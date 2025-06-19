package tests.blockstream;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.blockstream.BlocksPage;

import java.util.List;


public class BlocksTests extends BaseTest {
    String blockPageURL = "https://blockstream.info/block/000000000000000000076c036ff5119e5a5a74df77abf64203473364509f7732";
    String expectedTransactionHeader = "25 of 2875 Transactions";
    BlocksPage blocksPage;

    @Test
    public void testCaseTransactionHeader() {
        getDriver().get(blockPageURL);
        blocksPage = new BlocksPage(getDriver());
        String header = blocksPage.getBlockTransactionCount();
        Assert.assertEquals(header, expectedTransactionHeader);
    }

    @Test
    public void testCaseTransactionHash() throws InterruptedException {
        getDriver().get(blockPageURL);
        blocksPage = new BlocksPage(getDriver());
        List<WebElement> transactionBoxes = blocksPage.getTransactionBoxes();

        for (WebElement transactionBox : transactionBoxes) {
            List<WebElement> inputs = blocksPage.getTransactionBoxesInputs(transactionBox);
            if (inputs.size() == 1) {
                List<WebElement> outputs = blocksPage.getTransactionBoxesOutputs(transactionBox);
                if (outputs.size() == 2) {
                    System.out.println(blocksPage.getTransactionHash(transactionBox));
                }
            }
        }
    }
}
