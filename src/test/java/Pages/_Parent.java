/**
 * @Author:Otosun Tarih :05/10/2020
 */
package Pages;

import Utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class _Parent {
    /**
     * Bu dosya diğer bütün page ler için ortak click ve sendkeys
     * için nekleme, scroll ve clear gibi bütün işleleri tek yereden
     * yapabilmek için eklendi.Bu class diğer pageler tarafından exten edilerek
     * kullanılacak.Böylece tüm pagelerdeki elemanların click ve sendkeys özelliği
     * hem bekleme hem scroll hem de clear özelliği kazanmış olacak.
     */

    WebDriver driver;
    WebDriverWait wait;


    List<WebElement> myElementList;
    WebElement myElement;

    public _Parent() {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void clickFunction(WebElement element) {
        scrollToElement(element); // eleman kadar scroll yap
        waitUntilClickable(element);// eleman clikable olana kadar bekle
        element.click();// click yap
    }

    public void sendKeysFunction(WebElement element, String value) {
        waitUntilVisible(element);// elelman görünüt olana kadar bekle
        scrollToElement(element);// elemana kadar scroll yap
        element.clear();// eleman clear yap
        element.sendKeys(value);// value yi gönder
    }

    public void waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilToBeSelected(WebElement element) {
        wait.until(ExpectedConditions.elementToBeSelected(element));
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void verifyElementContainsText(WebElement element, String text) {
        waitUntilVisible(element);
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
        System.out.println(element.getText());
        Assert.assertTrue(element.getText().toLowerCase().contains(text.toLowerCase()));
    }

    public List<WebElement> waitVisibleListAllElement(List<WebElement> elementList) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
        return elementList;
    }

    public void beklet(int milisaniye) {
        try {
            Thread.sleep(milisaniye);
        } catch (Exception ie) {
            ie.printStackTrace();
        }
    }

    public boolean girdiSayiMi(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    public WebElement selectOptionByString(List<WebElement> elementList, String str) {
        WebElement element=null;
        str = str.trim();
        if (girdiSayiMi(str)) {
            element=selectOptions(elementList, Integer.parseInt(str));
          //  clickFunction(element);
        } else {
            element=selectOptions(elementList, str);
          //  clickFunction(element);
        }
        return element;
    }

    public WebElement selectOptions(List<WebElement> elementList, String value) {
        WebElement elementSelected = null;
        for (WebElement element : elementList) {
            if (element.getText().toLowerCase().contains(value.toLowerCase())) {
                elementSelected = element;
                break;
            }
        }
        return elementSelected;
    }

    public WebElement selectOptions(List<WebElement> elementList, int index) {
        return elementList.get(index);
    }

    public void verifyMyElementIsDisplayed(WebElement element) {
        Set<String> sayfaidleri = driver.getWindowHandles();
        String anasayfaidsi = driver.getWindowHandle();
        for (String s : sayfaidleri) {
            if (!s.equals(anasayfaidsi))
                driver.switchTo().window(s);
        }
        Assert.assertTrue(element.isDisplayed(),"WebElement bulunamadi.");
        driver.switchTo().window(anasayfaidsi);
    }

    public void verifyTheNumberOfItemsOnTheList(List<WebElement> elementList, int numberOfItems) {
        System.out.println("Number of items= " + elementList.size());
        Assert.assertTrue(elementList.size() == numberOfItems);
    }

    public void printToList(List<WebElement> webElmList) {
        for (WebElement e : webElmList) {
            System.out.println(e.getText());
            System.out.println("------------------------------------------------------------");
        }
    }

}
