package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class Home {

        protected static WebDriver driver;

        public Home(WebDriver driver){
            PageFactory.initElements(driver,this);
            this.driver = driver;
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        private final String pageUrl = "https://coodesh.com/";

        public void abrirPagina(String endereco) {
            driver.get(endereco);
        }

        @FindBy(xpath = "/html/body/div[1]/main/div[5]/div/div[1]/span")
        public WebElement btnNovidadesConteudos;

        @FindBy(xpath = "/html/body/div[1]/main/div[5]/div/div[2]/div[2]/div/div[1]/div/div/a/article/h3")
        public WebElement textoArtigo;

        @FindBy(linkText = "Vagas")
        private WebElement linkSistemaVagas;

        public void clickLinkSistemaVagas(){
            linkSistemaVagas.click();
        }

        public String getTextoArtigo(){
            return textoArtigo.getText();
        }

}


