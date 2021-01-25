package StepDefinitions;


import io.cucumber.java.pt.*;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;
import pages.Home;
import pages.Vagas;

public class homeSteps {

    WebDriver driver = new FirefoxDriver();
    Home home = new Home(driver);
    Vagas vagas = new Vagas(driver);

    @Dado("abra a pagina {string}")
    public void abra_a_pagina(String endereco) {
        home.abrirPagina(endereco);
    }

    //Cenário: : Verificar a se a página inicial esta sendo carregada corretamente
    @Então("deve ser apresentado o texto de um artigo carregado {string}")
    public void deve_ser_apresentado_o_texto_de_um_artigo_carregado(String textoArtigoEsperado) {
        assertEquals(home.getTextoArtigo(),textoArtigoEsperado);
    }

    // Navegar pela página e ir ao sistema de vagas no menu superior
    @Quando("clicar no link do sistemas de vagas")
    public void clicar_no_link_do_sistemas_de_vagas() {
       home.clickLinkSistemaVagas();
    }

    @Então("o sistema de vagas deverá ser aberto permitindo o usuário buscar e visualizar vagas")
    public void o_sistema_de_vagas_deverá_ser_aberto_permitindo_o_usuário_buscar_e_visualizar_vagas() {
        vagas.elementosPresentesPosCarregamento();
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }

}
