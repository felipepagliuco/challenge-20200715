package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Vagas {

    private final WebDriver driver;

    public Vagas(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private final String pageUrl = "https://coodesh.com/vagas";

    public void abrirPagina() {
        driver.get(pageUrl);
    }

    @FindBy(name = "search")
    private WebElement campoBuscaCargo;

    @FindBy(name = "location")
    private WebElement campoBuscaLocalizacao;

    @FindBy(xpath = "/html/body/div[1]/main/div[1]/div/form/div[3]/button")
    private WebElement btnEncontrar;

    @FindBys({
            @FindBy(xpath = "/html/body/div[1]/main/div[2]/*/div/div/div[2]/div[1]/div/h1/a")
    })
    private List<WebElement> allTituloVagasRetornoBusca;

    @FindBy(xpath = "/html/body/div[1]/main/div[2]/div/div/div[2]/div/div[1]/header/div/h3")
    private WebElement labelResumoDaVaga;

    @FindBy(xpath= "/html/body/div[1]/main/div[2]/div/div/div[2]/div/div[1]/div/div[8]/div/button")
    private WebElement btnCanditatar;

    @FindBy(id = "fullname")
    private WebElement inputNome;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "phone")
    private WebElement phone;

    @FindBy(id = "contact_preference")
    private WebElement contact_preference;

    @FindBy(id = "contact_hour")
    private WebElement contact_hour;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "linkedin")
    private WebElement linkedin;

    @FindBy(id = "github")
    private WebElement github;

    @FindBy(id = "salary_range.max")
    private WebElement salary_range_max;

    @FindBy(xpath = "/html/body/div[5]/div/div/div[3]/button")
    private WebElement btnEnviar;

    public boolean carregamentoModalCandidatar(){
        if (inputNome.isDisplayed() && email.isDisplayed()
                && phone.isDisplayed() && contact_preference.isDisplayed()
                && contact_hour.isDisplayed() && city.isDisplayed() && linkedin.isDisplayed()
                && github.isDisplayed() && salary_range_max.isDisplayed() && btnEnviar.isDisplayed()){
            return true;
        }else{
            return false;
        }
    }

    public List<String> tituloVagasRetornoBusca(){
        List<String> tituloVagasRetornoBuscaList = new ArrayList<>();

        for (WebElement webElement : allTituloVagasRetornoBusca) {
            tituloVagasRetornoBuscaList.add(webElement.getText());
        }
        return tituloVagasRetornoBuscaList;
    }

    public void clicktituloVagasRetornoBusca(){
        Random r = new java.util.Random();
        WebElement randomElement = allTituloVagasRetornoBusca.get(r.nextInt(allTituloVagasRetornoBusca.size()));
        randomElement.click();
    }

    public boolean paginaVagaCarregada(){
        if (labelResumoDaVaga.isDisplayed() && btnCanditatar.isDisplayed()){
            return true;
        }else{
            return false;
        }
    }

    public void clicarBtnCandidatarse(){
        btnCanditatar.click();
    }

    public boolean elementosPresentesPosCarregamento() {
        if (campoBuscaCargo.isDisplayed() && campoBuscaLocalizacao.isDisplayed()
                && btnEncontrar.isDisplayed() == true){
            return true;
        }else
            return false;
    }

    public void TypeInField(String value,WebElement element){
        String val = value;
        element.clear();
        for (int i = 0; i < val.length(); i++){
            char c = val.charAt(i);
            String s = new StringBuilder().append(c).toString(); element.sendKeys(s); } }


//    public void buscaPorEmpresa(String empresa)  {
//        if (campoBuscaCargo.isDisplayed() == true) {
//            TypeInField(empresa, campoBuscaCargo);
//            btnEncontrar.click();
//        }
//    }

    public void buscaPorEmpresa(String empresa) {
        WebElement firstResult = new WebDriverWait(driver, 4)
                .until(ExpectedConditions.visibilityOf(campoBuscaCargo));

        campoBuscaCargo.click();

        TypeInField(empresa, campoBuscaCargo);
        btnEncontrar.click();
    }

}


