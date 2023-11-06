package Pages;

import Utilities.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DialogContent extends Parent{

    public DialogContent() {
        PageFactory.initElements(BaseDriver.getDriver(), this);


    }



   @FindBy (css = "input[type='text']")
    public WebElement searchBox;//clickten önce

    @FindBy (css = "[class='searchBoxOld-M1esqHPyWSuRUjMCALPK']")
    public WebElement searchBox1;// clickten sonra

   @FindBy (className = "searchBoxOld-yDJzsIfi_S5gVgoapx6f")
    public WebElement searchButton;

   @FindBy (css = "[class='productListContent-frGrtf5XrVXRwJ05HUfU productListContent-rEYj2_8SETJUeqNhyzSm']>:nth-child(4)")
    public  WebElement Pencil;

   @FindBy (css = "[id='quantity']")
    public WebElement adetInput;

   @FindBy (css = "[name='quantity']")
   public WebElement adetInputt;

   @FindBy (css = "[id='addToCart']")
    public WebElement addToCart1;

  @FindBy (xpath = "//*[text()='Sepete git']")
  public WebElement goToBasket;





}
