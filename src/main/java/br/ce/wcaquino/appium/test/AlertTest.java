package br.ce.wcaquino.appium.test;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.core.DriverFactory;
import br.ce.wcaquino.appium.page.AlertaPage;
import br.ce.wcaquino.appium.page.MenuPage;

public class AlertTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AlertaPage page = new AlertaPage();
	
	
	@Before
	public void setup() {
		//acessar o menu alerta 
		menu.acessarAlertas();	
	}
	
	
	@Test
	public void deveConfirmarAlerta() {
		
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
	
	@Test
	
	public void deveClicarForaAlerta() {
		
		//clicar alerta simples
	    DriverFactory.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		page.clicarAlertaSimples();
	
		
		//clicar fora da caixa 
		esperar(5000);
		page.clicarForaCaixa();
		
		//verificar que a mensagem não está presente
		esperar(5000);
		Assert.assertTrue(page.existeUmElementoPorTexto("ALERTA SIMPLES"));
		//Assert.assertFalse(page.existeUmElementoPorTexto("Pode clicar no OK ou fora da caixa para sair"));  // false pq eu quer que ele mostre que não existe esse elemento
		
		
		
	}
	

	
}
