package br.ce.wcaquino.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;
import br.ce.wcaquino.appium.page.SwipeListPage;

public class SwipeListTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private SwipeListPage page = new SwipeListPage();
	
	
	
		
		@Test
		public void deveInteragirSwipeList() {
		
		//clicar swipe list
		menu.clicarSwipeList();
		
		//op��o 1 para a direita
		page.swipeElementRigth("Op��o 1");
		
		// clicar em + na op��o 1
		page.clicarBotaoMais();
		
		// verificar a op��o 1
		Assert.assertTrue(menu.existeUmElementoPorTexto("Op��o 1 (+)"));
		
		// op��o 4 para a direita
		page.swipeElementRigth("Op��o 4");
		
		//clicar em - na op��o 4
		menu.clicarPorTexto("(-)");
		
		// verificar a op��o 4
		Assert.assertTrue(menu.existeUmElementoPorTexto("Op��o 4 (-)"));
		
		// op��o 5 para a esquerda
		page.swipeElementLetft("Op��o 5 (-)");
		
		//verificar op��o 5
		Assert.assertTrue(menu.existeUmElementoPorTexto("Op��o 5"));

	}




}
