package br.ce.wcaquino.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.AccordionPage;
import br.ce.wcaquino.appium.page.MenuPage;

public class AccordionTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AccordionPage page = new AccordionPage();
	
	
	@Test
	
	public void deveInteragirComAccordion() {
		//acessar menu Accordion
		menu.acessarAccordion();
		
		
		//clicar na op��o 1
		page.selecionarOp1();
		
		
		//verificar se est� na op��o 1
		Assert.assertEquals("Esta � a descri��o da op��o 1", page.obterValorOp1());
		
		
	}

}
