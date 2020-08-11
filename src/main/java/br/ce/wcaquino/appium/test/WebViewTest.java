package br.ce.wcaquino.appium.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;
import br.ce.wcaquino.appium.page.WebViewPage;

public class WebViewTest extends BaseTest {
	private MenuPage menu = new MenuPage();
	private WebViewPage page = new WebViewPage();
	

	@Test
	public void deveFazerLogin() {
		//acessar o menu
		menu.acessarSeuBarrigaHibrido();
		esperar(5000);
		page.entrarContextoWeb();
		
		//preencher o e-mail
		page.setEmail("kg@kg.com");
		
		
		//preencher a senha
		page.setSenha("123456");
		
		//clicar em entrar
		page.entrar();
		
		//confirmar se está logado
		Assert.assertEquals("Bem vindo, kg!", page.validarEntrada());
		
	}
	
	@After
	public void tearDown() {
		page.sairContextoWeb();
	}
}
