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
		
		//opção 1 para a direita
		page.swipeElementRigth("Opção 1");
		
		// clicar em + na opção 1
		page.clicarBotaoMais();
		
		// verificar a opção 1
		Assert.assertTrue(menu.existeUmElementoPorTexto("Opção 1 (+)"));
		
		// opção 4 para a direita
		page.swipeElementRigth("Opção 4");
		
		//clicar em - na opção 4
		menu.clicarPorTexto("(-)");
		
		// verificar a opção 4
		Assert.assertTrue(menu.existeUmElementoPorTexto("Opção 4 (-)"));
		
		// opção 5 para a esquerda
		page.swipeElementLetft("Opção 5 (-)");
		
		//verificar opção 5
		Assert.assertTrue(menu.existeUmElementoPorTexto("Opção 5"));

	}




}
