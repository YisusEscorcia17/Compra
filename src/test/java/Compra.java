import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Compra {
    private WebDriver chromeDriver;


    @Before
    public void abrirDriverC(){
        //encontrar el archivo exe de chrome driver
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver94.exe");
        // creamos opciones sobre nuestros driver
        ChromeOptions options = new ChromeOptions();
        options.setCapability("marionette", false);
        // nueva instancia de googledriver
        chromeDriver = new ChromeDriver(options);
        //maximisa el navegador
        chromeDriver.manage().window().maximize();

        //definimos el tiempo  de espera hasta que aceptemos un timeout
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void hacer_una_compra(){
        chromeDriver.get("http://automationpractice.com/index.php");
        chromeDriver.findElement(By.xpath("//*[@title='Log in to your customer account']")).click();

        WebElement botonEmail = chromeDriver.findElement(By.xpath("//*[@id='email']"));
        botonEmail.click();
        botonEmail.sendKeys("wuwamegrucru-7136@yopmail.com");


        WebElement botonPass = chromeDriver.findElement(By.xpath("//*[@id='passwd']"));
        botonEmail.click();
        botonPass.sendKeys("123456789");

        WebElement ClickAceptar = chromeDriver.findElement(By.xpath("//*[@id='SubmitLogin']"));
        ClickAceptar.click();

        WebElement BotnTshirt = chromeDriver.findElement(By.xpath("(//*[@title='T-shirts'])[2]"));
        BotnTshirt.click();

        //Crear Accion
        Actions accion = new Actions(chromeDriver);

        WebElement imagenCompra = chromeDriver.findElement(By.xpath("//*[@itemprop='image']"));

        accion.moveToElement(imagenCompra).moveToElement(chromeDriver.findElement(By.xpath("//*[@title='Add to cart']"))).click().build().perform();
    }

    @After
    public void cerrarDriverC(){
        // cerramos ventanas
        //chromeDriver.quit();
    }
    }