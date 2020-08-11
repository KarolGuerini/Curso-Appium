package br.ce.wcaquino.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;

public class SwipeTest extends BaseTest {
	
	 private MenuPage menu = new MenuPage();
	
	
	@Test
	
	public void deveRealizarSwipe() {
		//acessar menu
		menu.acessarSwipe();
		
		//verificar o texto'a esquerda '
		Assert.assertTrue(menu.existeUmElementoPorTexto("a esquerda"));
		
		//swipe para direita
		menu.swipeRigth();
		
		//verificar o texto 'E veja se'
		Assert.assertTrue(menu.existeUmElementoPorTexto("E veja se"));

		
		//clicar botão direito
		menu.clicarPorTexto("›");
		
		//verificar o texto'Chegar até o fim'
		Assert.assertTrue(menu.existeUmElementoPorTexto("Chegar até o fim!"));
		
		//swipe para a esquerda
		menu.swipeLeft();

		
		//clicar botão esquerdo
		menu.clicarPorTexto("‹");	
		
		//verificar o texto'a esquerda '
		Assert.assertTrue(menu.existeUmElementoPorTexto("a esquerda"));

		
	}

}
