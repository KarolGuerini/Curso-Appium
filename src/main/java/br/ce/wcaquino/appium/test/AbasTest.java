package br.ce.wcaquino.appium.test;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.core.DriverFactory;
import br.ce.wcaquino.appium.page.AbasPage;
import br.ce.wcaquino.appium.page.MenuPage;

public class AbasTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AbasPage page = new AbasPage();
	
	
	

	@Test
	public void deveInteragirComAbas() {
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //espera o elemento aparecer na tela e pode ser usado tanto em cada caso de teste como na configuração do Driver 
	
		
		//acessar abas
		menu.acessarMenuAbas();
		
		
		//verificar que está na aba1
		Assert.assertTrue(page.isAba1());
		
		//acessar aba 
		page.selecionarAba2();
		
		//verificar que está na aba2
		Assert.assertTrue(page.isAba2());
		

		
		
	}
	
}
