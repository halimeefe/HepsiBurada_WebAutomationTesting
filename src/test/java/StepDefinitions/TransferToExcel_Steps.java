package StepDefinitions;

import Pages.DialogContent;
import Utilities.BaseDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TransferToExcel_Steps {

    DialogContent dc = new DialogContent();

    WebDriverWait wait = new WebDriverWait(BaseDriver.getDriver(), Duration.ofSeconds(40));



    @And("The user scrolls to the bottom of the page")
    public void theUserScrollsToTheBottomOfThePage() {

        ((JavascriptExecutor) BaseDriver.getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight);"); // sayfanın en altına elemente scroll
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='footer-middle-left']>section:nth-child(2)>ul>li")));
        List<WebElement> categoryList=BaseDriver.getDriver().findElements(By.cssSelector("[class='footer-middle-left']>section:nth-child(2)>ul>li"));



    }

    @Then("The user transfers all category information to the excel file")
    public void theUserTransfersAllCategoryInformationToTheExcelFile() {

        By categories = By.cssSelector("[class='footer-middle-left']>section:nth-child(2)>ul>li");
        List<WebElement> categoryList = BaseDriver.getDriver().findElements(categories);

        Workbook workbook = new XSSFWorkbook();//Bir Excel çalışma kitabı oluşturdum
        Sheet sheet = workbook.createSheet("KATEGORİLER LİSTESİ");// özellikler adında bir dosya

        for (int i = 0; i < categoryList.size(); i++) {
            WebElement c = categoryList.get(i);
            Row row = sheet.createRow(i);
            String text = c.getText();
            String[] kategoriler = text.split("\n");
            for (int j = 0; j < kategoriler.length; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(kategoriler[j].trim());


            }

        }

        try
                (FileOutputStream outputStream = new FileOutputStream(" KATEGORİLER LİSTESİ.xlsx")){
               workbook.write(outputStream);
        }catch (IOException e){
            e.printStackTrace();

        }



    }
}
