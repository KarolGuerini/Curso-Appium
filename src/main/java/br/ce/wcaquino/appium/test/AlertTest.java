package br.ce.wcaquino.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.AlertaPage;
import br.ce.wcaquino.appium.page.MenuPage;

public class AlertTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AlertaPage page = new AlertaPage();
	
	
	
	@Test
	public void deveConfirmarAlerta() {
		//acessar o menu alerta 
		menu.acessarAlertas();
		
		
		//clicar em alerta confirm
		page.clicarAlertaConfirm();
		
		
	    //verificar o texto
		Assert.assertEquals("Info", page.obterTituloAlerta());
		Assert.assertEquals("Confirma a operação?", page.obterMensagemAlerta());
		
		
		//confirmar o alerta
		page.confirmar();
		
		//verificar nova mensagem  
		Assert.assertEquals("Confirmado", page.obterMensagemAlerta());
		
		
		//sair 
		page.sair();
		
		
		
	
		
		
	}
	
;
	
}
