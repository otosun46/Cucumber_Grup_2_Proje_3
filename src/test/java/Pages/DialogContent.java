/**
 * @Author:Otosun Tarih :07/10/2020
 */
package Pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class DialogContent extends _Parent {


    public DialogContent() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='login']")
    private WebElement sigIn;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(xpath = "//a[@title='Contact us']")
    private WebElement contactUs;

    @FindBy(xpath = "//a[@title='Specials']")
    private WebElement specials;

    @FindBy(xpath = "//a[@title='Best sellers']")
    private WebElement bestSeller;

    @FindBy(xpath = "//a[@title='My orders']")
    private WebElement orders;

    @FindBy(id = "SubmitLogin")
    private WebElement loginButton;

    @FindBy(id = "submitMessage")
    private WebElement sendMesageButton;

    @FindBy(id = "cookieconsent")
    private WebElement cookieConsent;

    @FindBy(xpath = "//div[@class='alert alert-danger']//li")
    private WebElement mesageAlert;

    @FindBy(id = "id_contact")
    private WebElement mesageHeading;

    @FindBy(xpath = "//select[@name='id_order']")
    private WebElement orderReference;

    @FindBy(xpath = "//select[@name='id_product']")
    private WebElement pruduct;

    @FindBy(id = "message")
    private WebElement mesageArea;

    @FindAll({
            @FindBy(css = "td[class=bold]>[for]")
    })
    private List<WebElement> productNameList;


    @FindBy(xpath = "//p[@class='alert alert-success']")
    private WebElement successMessage;

    @FindAll({
            @FindBy(xpath = "(//div[@id='order-detail-content']//following::label[2])[1]")
    })
    private List<WebElement> orderProductName;



    @FindAll({
            @FindBy(css = "ul[class='block_content products-block']>li")//(css="h5[itemprop=name]>[itemprop=url]")
    })
    private List<WebElement> products;

    @FindAll({
            @FindBy(css="h5[itemprop=name]")
    })
    private List<WebElement> denemeList;

    @FindAll({
            @FindBy(css="div[class=right-block]")
    })
    private List<WebElement> deneme1List;

    @FindAll({
            @FindBy(css = "div[class='product-container']>div+div>div>span+span")
    })
    private List<WebElement> productsOfSale;

    @FindAll({
            @FindBy(css = "tbody>tr>td[class='history_link bold footable-first-column']")
    })
    private List<WebElement> orderReferens;

    //span[class='discount']

    public void findElementAndClickFunction(String element) {
        switch (element) {
            case "sigIn":
                myElement = sigIn;
                break;

            case "loginButton":
                myElement = loginButton;
                break;
            case "specials":
                myElement = specials;
                break;

            case "sendMesageButton":
                myElement = sendMesageButton;
                break;

            case "bestSeller":
                myElement = bestSeller;
                break;

            case "contactUs":
                myElement = contactUs;
                break;
            case "orders":
                myElement = orders;
                break;


        }
        clickFunction(myElement);
    }

    public void findElementAndSelectOption(String listName, String secenek) {
        switch (listName) {
            case "option":
             //   myElementList = option;
                break;
            case "tabOption":
             //   myElementList = tabOption;
                break;

        }
        beklet(200);
        selectOptionByString(myElementList, secenek);
    }

    public void findElementAndSendKeysFunction(String element, String value) {
        switch (element) {
            case "email":
                myElement = email;
                break;
            case "password":
                myElement = password;
                break;
            case "mesageArea":
                myElement = mesageArea;
                break;
        }
        sendKeysFunction(myElement, value);
    }

    public void findElementAndVerifyContainsText(String elementName, String msg) {
        switch (elementName) {
            case "mesageAlert":
                myElement = mesageAlert;
                break;

            case "successMessage":
                myElement = successMessage;
                break;
        }
        verifyElementContainsText(myElement, msg);
    }

    public void findElementAndSelectMenu(String elementName, String index) {
        switch (elementName) {
            case "mesageHeading":
                myElement = mesageHeading;
                break;

            case "orderReference":
                myElement = orderReference;
                break;
            case "pruduct":
                myElement = pruduct;
                break;

        }
        selectMenu(myElement, index);
    }

    public void selectMenu(WebElement menuName,String index){
//        System.out.println("Select menuye girdi");
        Select menuSecim = new Select(menuName);
        menuSecim.selectByIndex(Integer.parseInt(index));
    }

    public void findElementListAndNumberOfLstOrPrintItemsOfList(String elementName, int numberOfItems) {
        myElementList = new ArrayList<>();
        switch (elementName) {
            case "products":
                myElementList = products;
                break;
            case "productsOfSale":
                myElementList = productsOfSale;
                break;
            case "orderReferens":
                myElementList = orderReferens;
                break;
            case "orderProductName":
                myElementList = orderProductName;
                break;
            case "productNameList":
                myElementList = productNameList;
                break;
            case "denemeList":
                myElementList = denemeList;
                break;
            case "deneme1List":
                myElementList = deneme1List;
                break;
        }
        if (numberOfItems > 0)
            verifyTheNumberOfItemsOnTheList(waitVisibleListAllElement(myElementList), numberOfItems);
        else
            printToList(myElementList);

    }

    public List<WebElement> findElementList(String elementList) {
        myElementList = new ArrayList<>();
        switch (elementList) {
            case "orderReferens":
                myElementList = orderReferens;
                break;
        }
        return myElementList;
    }
    public void verifyTheNumberOfItemsOnTheList(List<WebElement> elementList,int numberOfItems){
        System.out.println("Number of items= "+elementList.size());
        Assert.assertTrue(elementList.size()==numberOfItems);
    }

    public  void printToList(List<WebElement> webElmList) {
        for (WebElement e : webElmList) {
            System.out.println(e.getText());
            System.out.println("------------------------------------------------------------");
        }
    }

    public void findWebElementListAndClickEachOneElementWithForeachAndPrintOfList(String clickElementList, String printElementList) {

        System.out.println("************************************************************");
        System.out.println("List printing started");
        int list = 1;
        for (WebElement element : findElementList(clickElementList)) {
            clickFunction(element);
            beklet(2000);
            System.out.println("List:" + list++);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            findElementListAndNumberOfLstOrPrintItemsOfList(printElementList, 0);
        }
        System.out.println("List printing finished");
        System.out.println("************************************************************");
    }
}
