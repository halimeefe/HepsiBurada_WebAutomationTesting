package StepDefinitions;

import Pages.DialogContent;
import Utilities.BaseDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartLimit_Steps {


    DialogContent dc = new DialogContent();

    WebDriverWait wait = new WebDriverWait(BaseDriver.getDriver(), Duration.ofSeconds(40));

    @Given("The user goes to HepsiBurada Website")
    public void theUserGoesToHepsiBuradaWebsite() {
        BaseDriver.getDriver().get("https://www.hepsiburada.com/");
        BaseDriver.getDriver().manage().window().maximize();

    }
    @When("The user searches for Faber Castel köşeli kurşun kalem in the searc box")
    public void theUserSearchesForFaberCastelKoseliKursunKalemInTheSearcBox() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='searchBoxOld-M1esqHPyWSuRUjMCALPK']")));
        dc.clickFunc(dc.searchBox1);
        dc.sendKeysFunc(dc.searchBox,"Faber Castel köşeli kurşun kalem");
        dc.clickFunc(dc.searchButton);


    }




    @And("The user clicks on the first product that appears")
    public void theUserClicksOnTheFirstProductThatAppears() {
        dc.clickFunc(dc.Pencil);
    }

    @And("The User selects {int} items from the product")
    public void theUserSelectsItemsFromTheProduct(int arg0) throws InterruptedException {

         String anaPencere = BaseDriver.getDriver().getWindowHandle();
        for (String pencere : BaseDriver.getDriver().getWindowHandles()) {
            if (!pencere.equals(anaPencere)) {
                BaseDriver.getDriver().switchTo().window(pencere);
                break;
            }
        }

     wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id='quantity']")));
        dc.clickFunc(dc.adetInput);
        dc.adetInput.clear();
        dc.sendKeysFunc(dc.adetInput,"501");
        dc.clickFunc(dc.addToCart1);




    }

    @And("The user confirms the message that {int} items have been added to the cart")
    public void theUserConfirmsTheMessageThatItemsHaveBeenAddedToTheCart(int arg0) {

        WebElement productInCartElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".checkoutui-ProductOnBasketHeader-nOvp_U8bHbLzgKbSUFaz")));
        String productInCartText = productInCartElement.getText();
        System.out.println(productInCartText);


    }

    @And("The user then verifies if there are {int} items in the cart")
    public void theUserThenVerifiesIfThereAreItemsInTheCart(int arg0) {
        dc.clickFunc(dc.goToBasket);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='quantity']")));
        WebElement quantityInput = BaseDriver.getDriver().findElement(By.cssSelector("input[name='quantity']"));
        String value = quantityInput.getAttribute("value");
        System.out.println("Sepete görünen ürün sayısı:"+value);


    }

    @And("The user changes the quantity of the product in the cart to {int} pieces")
    public void theUserChangesTheQuantityOfTheProductInTheCartToPieces(int arg0) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='quantity']")));
        dc.clickFunc(dc.adetInputt);
        dc.adetInputt.clear();
        dc.sendKeysFunc(dc.adetInputt,"501");
    }

    @Then("The user confirms that products cannot be added to the cart with more than {int} items")
    public void theUserConfirmsThatProductsCannotBeAddedToTheCartWithMoreThanItems(int arg0) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hb-toast-text")));
        WebElement elementText = BaseDriver.getDriver().findElement(By.cssSelector(".hb-toast-text"));
        String elementTextt = elementText.getText();
        System.out.println("Ürünler neden sepete eklenemedi : " + elementTextt);

        BaseDriver.getDriver().navigate().back();
    }



}
