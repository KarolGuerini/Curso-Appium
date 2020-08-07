package br.ce.wcaquino.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;
import br.ce.wcaquino.appium.page.SplashPage;

public class SplashTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private SplashPage page = new SplashPage();
	
	@Test
	public void deveAguardarSpashSumir() {
		
		//acessar o menu splash
		menu.acessarSplash();
		
		//verificar que o splash está sendo exibido
		page.isTelaSplashVisisvel();
		
		
		//aguardar a saída do splash
		page.aguardarSplashSumir();
		
		
		// verificar que o formulário está aparecendo
		Assert.assertTrue(page.existeUmElementoPorTexto("Formulário"));
		
		
		
	}
	
	

}
