package br.ce.wcaquino.appium.test;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.core.DriverFactory;
import br.ce.wcaquino.appium.page.CliquesPage;
import br.ce.wcaquino.appium.page.MenuPage;

public class CliquesTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private CliquesPage page = new CliquesPage();
	
	
   @Before
	public void setup() {
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		menu.acessarCliques();
	}
	
	@Test
	public void deveRealizarCliqueLongo() {
		
		//clique longo
		page.cliqueLongo();
		
		
		//verificar texto
		Assert.assertEquals("Clique Longo", page.obterTextoCampo());	
	}

	@Test
	public void deveRealizarCliqueDuplo() {
		
		//clique duplo	
		page.clicarPorTexto("Clique duplo");
		page.clicarPorTexto("Clique duplo");

		
		//verificar texto
		Assert.assertEquals("Duplo Clique", page.obterTextoCampo());	
	}
}
