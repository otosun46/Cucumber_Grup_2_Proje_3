/**
 * @Author:Otosun Tarih :07/10/2020
 */
package Pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DialogContent extends _Parent {

//    public DialogContent() {
//        PageFactory.initElements(driver, this);
//    }

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

    @FindBy(xpath = "//li[@class='facebook']")
    private WebElement facebook;

    @FindBy(xpath = "//li[@class='twitter']")
    private WebElement twitter;

    @FindBy(xpath = "//li[@class='youtube']")
    private WebElement youTube;

    @FindBy(xpath = "//li[@class='google-plus']")
    private WebElement googlePlus;

    @FindBy(xpath = "//span[text()='Selenium Framework']")
    private WebElement facebooklogosu;

    @FindBy(xpath = "//a[@aria-label='Twitter']")
    private WebElement twitterlogosu;

    @FindBy(css = "div[id=logo-icon-container]")
    private WebElement youTubelogosu;

    @FindBy(xpath = "//div[@id='headingSubtext']/span")
    private WebElement googlePlusLogosu;

    @FindBy(xpath = "(//a[@title='Dresses'])[2]")
    private WebElement dresses;

    @FindBy(xpath = "(//a[@class='product-name'])[4]")
    private WebElement printedDressAddToCart;

    @FindBy(xpath = "//div[@class='layer_cart_product col-xs-12 col-md-6']/h2")
    private WebElement successProductAdd;

    @FindBy(xpath = "//span[text()='Add to cart']")
    private WebElement addToCart;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    private WebElement proceedToCheckout;

    @FindBy(xpath = "//span[@title='Continue shopping']")
    private WebElement continueShopping;

    @FindBy(xpath = "//i[@class='icon-trash']")
    private WebElement deleteIcon;

    @FindBy(xpath = "//p[@class='alert alert-warning']")//bunun textinin empty oldugunu dogrulayacagiz
    private WebElement cart;

    @FindAll({
            @FindBy(xpath = "//i[@class='icon-trash']")
    })
    private List<WebElement> deleteIconLst;

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
            @FindBy(css = "ul[class='block_content products-block']>li")
    })
    private List<WebElement> products;

    @FindAll({
            @FindBy(css = "h5[itemprop=name]")
    })
    private List<WebElement> denemeList;

    @FindAll({
            @FindBy(css = "ul[class='product_list grid row']>li")
    })
    private List<WebElement> productList;

    @FindAll({
            @FindBy(css = "div[class='product-container']>div+div>div>span+span")
    })
    private List<WebElement> productsOfSale;

    @FindAll({
            @FindBy(css = "tbody>tr>td[class='history_link bold footable-first-column']")
    })
    private List<WebElement> orderReferens;

    /**
     * Parametre olarak ismi girilen WebElementi bulur ve dondurur.
     *
     * @param webElementName
     * @return
     */
    public WebElement findWebElement(String webElementName) {
        switch (webElementName) {
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
            case "facebook":
                myElement = facebook;
                break;
            case "twitter":
                myElement = twitter;
                break;
            case "youTube":
                myElement = youTube;
                break;
            case "googlePlus":
                myElement = googlePlus;
                break;
            case "dresses":
                myElement = dresses;
                break;
            case "proceedToCheckout":
                myElement = proceedToCheckout;
                break;
            case "printedDressAddToCart":
                myElement = printedDressAddToCart;
                break;
            case "deleteIcon":
                myElement = deleteIcon;
                break;
            case "addToCart":
                myElement = addToCart;
                break;
            case "continueShopping":
                myElement = continueShopping;
                break;
            case "email":
                myElement = email;
                break;
            case "password":
                myElement = password;
                break;
            case "mesageArea":
                myElement = mesageArea;
                break;
            case "facebooklogosu":
                myElement = facebooklogosu;
                break;
            case "twitterlogosu":
                myElement = twitterlogosu;
                break;
            case "youTubelogosu":
                myElement = youTubelogosu;
                break;
            case "googlePlusLogosu":
                myElement = googlePlusLogosu;
                break;
            case "mesageAlert":
                myElement = mesageAlert;
                break;
            case "successMessage":
                myElement = successMessage;
                break;
            case "successProductAdd":
                myElement = successProductAdd;
                break;
            case "cart":
                myElement = cart;
                break;
        }
        return myElement;
    }

    /**
     * Parametre olarak ismi girilen WebElementListi dondurur.
     *
     * @param webElementListName
     * @return
     */
    public List<WebElement> findWebElementList(String webElementListName) {
        switch (webElementListName) {
            case "products":
                myElementList = products;
                break;
            case "productList":
                myElementList = productList;
                break;
            case "deleteIconLst":
                myElementList = deleteIconLst;
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
        }
        return myElementList;
    }

    /**
     * Bu metod steps classtan calistirilacak parametre olarak string olarak tiklanacak WebElementin ismini alir.
     *
     * @param element
     */
    public void findElementAndClickFunction(String element) {
        clickFunction(findWebElement(element));
    }

    /**
     * Parametre olarak ismi gonderilen WebElementi bulur ve value parametresini secilen WebElemente gonderir.
     *
     * @param element
     * @param value
     */
    public void findElementAndSendKeysFunction(String element, String value) {
        sendKeysFunction(findWebElement(element), value);
    }

    /**
     * Bu metod steps classindan cagrilir.
     * Parametre olarak seceneklerin oldugu WebElementListesinin adini ve secim kriterini string olarak alir.
     * Secim parametresi sayi olursa index olarak degerlendirilir ve o indexli WebElement secilir.
     * Parametre sayi degilse WebElementin texti ile karsilastirilir ve kapsayan WebElement secilir.
     * @param listName
     * @param secenek
     */
    public void findElementAndSelectOption(String listName, String secenek) {
        findWebElementList(listName);
        printToList(myElementList);
        myElement = selectOptionByString(myElementList, secenek);
        clickFunction(myElement);       // bazi elemanlara bir kere tiklayinca secilmedigi tespit edildi cozum olarak;
        if (!addToCart.isDisplayed()) { //sonraki tiklanacak eleman addToCart eger bu eleman gorunmuyorsa
            clickFunction(myElement);   //myElemente bir kere daha tiklayacak
        }
    }

    /**
     * Parametre olarak ismi gonderilen WebElementi bulur ve gorundugunu dogrular.
     * @param elementName
     */
    public void findElementAndVerifyDisplayed(String elementName) {
        verifyMyElementIsDisplayed(findWebElement(elementName));
    }

    /**
     * Parametre olarak ismi gonderilen WebElementi bulur ve
     * parametre olarak giriilen msg nin WebElementin textinde bulundugunu dogrular.
     * @param elementName
     * @param msg
     */
    public void findElementAndVerifyContainsText(String elementName, String msg) {
        verifyElementContainsText(findWebElement(elementName), msg);
    }

    /**
     * Parametre olarak ismi girilen WebElementListin butun elemanlarina clickFunctioni uygular.
     * @param listName
     */
    public void findElementListAndClickToAllElement(String listName) {
        for (WebElement element : findWebElementList(listName)) {
            clickFunction(element);
        }
    }

    /**
     * Parametre olarak ismi girilen WebElementListin ikinci parametrede girilen sayi kadar elemana sahip oldugu dogrulanir.
     * Ikinci parametre "0" girilirse listedeki elemenlari yazdirir.
     * @param elementName
     * @param numberOfItems
     */
    public void findElementListAndNumberOfLstOrPrintItemsOfList(String elementName, int numberOfItems) {
        if (numberOfItems > 0)
            verifyTheNumberOfItemsOnTheList(waitVisibleListAllElement(findWebElementList(elementName)), numberOfItems);
        else
            printToList(findWebElementList(elementName));
    }

    public void findWebElementListAndClickEachOneElementWithForeachAndPrintOfList(String clickElementList, String printElementList) {
        System.out.println("************************************************************");
        System.out.println("List printing started");
        int list = 1;
        for (WebElement element : findWebElementList(clickElementList)) {
            clickFunction(element);
            //  beklet(2000);
            System.out.println("List:" + list++);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            findElementListAndNumberOfLstOrPrintItemsOfList(printElementList, 0);
        }
        System.out.println("List printing finished");
        System.out.println("************************************************************");
    }
}
