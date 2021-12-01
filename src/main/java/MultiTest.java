import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MultiTest {
    static WebDriver driver;

    public static void clickonElement(By by) {
        driver.findElement(by).click();
    }
    public static void typetax(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }
    public static String getTextFromElement(By by) {
        String text = driver.findElement(by).getText();
        return text;
    }
    public static String currentTimeSTamp() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("ddmmyyhhss");
        return sdf.format(date);
    }

    public static void waitForclickable(By by, int timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void waitForvisible(By by, int timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }

    @Test
    public void verifyuserShouldbeableToRegisterSuccesfully() {
        System.out.println(currentTimeSTamp());
        System.setProperty("webdriver.chrome.driver", "src/test/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        //click on register button
        clickonElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a"));
        //verify user is on register page
        Assert.assertTrue(driver.getCurrentUrl().contains(("register")));
        typetax(By.name("Firstname"), "Unnati");
        typetax(By.name("Last name"), "Patel");
        //select day from dropdown
        Select selectDay = new Select(driver.findElement(By.name("DateofBirthday")));
        selectDay.selectByVisibleText("14");
        //select month from dropdown
        Select selectmonth = new Select(driver.findElement(By.name("DateofBirthmonth")));
        selectmonth.selectByValue("5");
        //Enter email
        String email = "unnatip145+" + currentTimeSTamp() + "@gmail.com";
        System.out.println(email);
        driver.findElement(By.name("Email")).sendKeys(email);
        waitForvisible(By.id("Newsletter"), 20);
        clickonElement(By.id("Newsletter"));
        //Enter Password
        typetax(By.id("password"), "patel14");
        typetax(By.id("confirmPassword"), "patel14");
        waitForclickable(By.name("register-button"), 10);
        clickonElement(By.name("register-button"));
        String actualregisterSuccessMessage = getTextFromElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a"));
        String expectedRegisterSuccesssMessage = "Your registertion completed....";
        Assert.assertEquals(actualregisterSuccessMessage, expectedRegisterSuccesssMessage);
        Assert.assertTrue(actualregisterSuccessMessage.equals(expectedRegisterSuccesssMessage));
    }
    @Test
    public void newsComments(){
        //click on news details
        click(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[5]/div[2]/div[2]/div[3]/a"));
        //type title
        sendkeyText(By.id("AddNewComment_CommentTitle"),"Nice Website");
        //type comment
        sendkeyText(By.id("AddNewComment_commentText"),"nopcommerce website is good");
        //click on new comment
        click(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/form/div[2]/button"));
        String actual=getTextFromElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/form/div[2]/button"));
        String expected="News comment is succesfully added";
        Assert.assertTrue(actual.equals(expected), "News comment is succesfully added");
    }

    //verifyuserabletonavigateDesktoppage-verify user is able to navigate to desktop page
    @Test
    public void verifyuserabletonavigateDesktoppage() {
        click(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[1]/h1"));
        click(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[1]/h1"));
    }
    
        @Test
        public void verifyRegisterusershouldbeableToReferAProductToFriend(){
//call usershouldbeabletoRegisterSuccesfully to verifyregistershouldbe ableto refer a product
verifyuserShouldbeableToRegisterSuccesfully();
click(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a"));
click(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div[2]/h2/a"));
click(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div/form/div[2]/div[1]/div[2]/div[10]/div[3]/button"));
sendkeyText(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div/div[1]/input"), "Nice Website");
sendkeyText((By.xpath("//*[@id=\"PersonalMessage\"]")), "Nice Product");




        }




    private void sendkeyText(By xpath, String text) {
    }

    private void click(By xpath) {
    }


}
