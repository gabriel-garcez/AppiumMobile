package stepDefinitions;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import managers.AndroidDriverManager;


public class Steps {
	
private AndroidDriver<MobileElement> driver;
	
	@Test
	@Given("^O Aplicativo estar aberto na primeira pagina$")
	public void o_Aplicativo_estar_aberto_na_primeira_pagina() throws Throwable {
	driver = AndroidDriverManager.createCapabilities();
	Thread.sleep(8000);
	}
	
	@Given("^Clicar na pagina inicial$")
	public void clicar_na_pagina_inicial() throws Throwable {
	(new TouchAction(driver)).tap(416, 668).perform();
	Thread.sleep(8000);
	}

	@Given("^Informar a placa invalida$")
	public void informar_a_placa_invalida() throws Throwable {
	MobileElement el1 = (MobileElement) driver.findElementById("com.devplank.masterplaca:id/et_placa_letra");
	el1.sendKeys("AA9");
	MobileElement el2 = (MobileElement) driver.findElementById("com.devplank.masterplaca:id/et_placa_numero");
	el2.sendKeys("6234");	
	}

	@Given("^clicar no botao pesquisar$")
	public void clicar_no_botao_pesquisar() throws Throwable {
	 MobileElement el3 = (MobileElement) driver.findElementById("com.devplank.masterplaca:id/fab_consultar");
	el3.click();
	Thread.sleep(8000);
	}

	@Then("^Receber a mensagem de erro$")
	public void receber_a_mensagem_de_erro() throws Throwable {
	MobileElement el4 = (MobileElement) driver.findElementById("android:id/message");
	String mensagem = el4.getText();
	assertEquals("Por favor, verifique a placa digita.", mensagem);
	}
		
}
