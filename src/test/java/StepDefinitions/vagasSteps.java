package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import pages.Vagas;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class vagasSteps {


    ProfilesIni profile = new ProfilesIni();
    FirefoxProfile myprofile = profile.getProfile("automacao");

    FirefoxOptions firefoxOptions = new FirefoxOptions();
    FirefoxDriver driver = new FirefoxDriver(firefoxOptions.setProfile(myprofile));
    //ChromeDriver driver = new ChromeDriver();
    //FirefoxDriver driver = new FirefoxDriver();
    Vagas vagas = new Vagas(driver);

    @Dado("que esteja na tela de vagas")
    public void que_esteja_na_tela_de_vagas() {
        vagas.abrirPagina();
    }

    @Quando("buscar pela empresa {string}")
    public void buscar_pela_empresa(String empresa) throws InterruptedException {
        vagas.buscaPorEmpresa(empresa);
    }

    @Então("deverá ser apresentado {string} resultados contendo os titulos")
    public void deverá_ser_apresentado_resultados_contendo_os_titulos(String string, List<String> titulos) {
        assertEquals(vagas.tituloVagasRetornoBusca(),titulos);
    }

    @Quando("clicar no titulo da vaga")
    public void clicar_no_titulo_da_vaga() {
        vagas.clicktituloVagasRetornoBusca();
    }
    @Então("a pagina deve ser exibida com sucesso")
    public void a_pagina_deve_ser_exibida_com_sucesso() {
        assertEquals(true,vagas.paginaVagaCarregada());
    }

    @Quando("clicar no botão Candidatar-se")
    public void clicar_no_botão_candidatar_se() {
        vagas.clicarBtnCandidatarse();
    }

    @Então("o modal deve ser")
    public void o_modal_deve_ser() {
        assertEquals(true,vagas.carregamentoModalCandidatar());
    }

    @Então("o modal deve ser aberto corretamente")
    public void o_modal_deve_ser_aberto_corretamente() {
        assertEquals(true,vagas.carregamentoModalCandidatar());
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }
}
