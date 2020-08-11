package br.ce.wcaquino.appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.wcaquino.appium.SBpage.SBHomePage;
import br.ce.wcaquino.appium.SBpage.SBMovimentacaoPage;
import br.ce.wcaquino.appium.SBpage.SBNativoContasPage;
import br.ce.wcaquino.appium.SBpage.SBNativoMenuPage;
import br.ce.wcaquino.appium.SBpage.SBResumoPage;
import br.ce.wcaquino.appium.SBpage.SeuBarrigaNativoLoginPage;
import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;

public class SeuBarrigaNativoTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private SeuBarrigaNativoLoginPage login = new SeuBarrigaNativoLoginPage();
	private SBNativoMenuPage menuSB = new SBNativoMenuPage();
	private SBNativoContasPage contas = new SBNativoContasPage();
	private SBMovimentacaoPage mov = new SBMovimentacaoPage();
	private SBHomePage home = new SBHomePage();
	private SBResumoPage resumo = new SBResumoPage();
	
	
	
	

	@Before
	public void setup() {
		
		esperar(5000);
		menu.acessarSeuBarrigaNativo();
		login.setEmail("kg@kg.com");
		login.setSenha("123456");
		login.entrar();
	}
	
	@Test
	
	public void deveInserirConta() {
		//entrar em contas 
		menuSB.acessarContas();
		
		//digitar o nome da conta 
		contas.setConta("Conta 123");
		
		//clicar em salvar
		contas.salvarConta();
		
		//verificar se foi cadastrada a conta
		Assert.assertTrue(contas.existeUmElementoPorTexto("Conta adicionada com sucesso"));
		
	}
	
	@Test
	
	public void deveExcluirContaSB() {
		//entrar em contas 
		menuSB.acessarContas();
		
		//fazer um clique longo em uma conta
		contas.selecionarConta("Conta 123");
		
		//clicar no bot�o excluir
		contas.excluirConta();
		
		
		//validar se a conta foi excluida 
		Assert.assertTrue(contas.existeUmElementoPorTexto("Conta exclu�da com sucesso"));
		
	}
	@Test
	
	public void deveValidarInclusaoMov() {
		//entrar em mov
		menuSB.acessarMovimentacoes();
		
		//validar descri��o
		mov.salvar();
		Assert.assertTrue(mov.existeUmElementoPorTexto("Descri��o � um campo obrigat�rio"));
		
		//validar interessado
		mov.setDescricao("Desc");
		mov.salvar();
		Assert.assertTrue(mov.existeUmElementoPorTexto("Interessado � um campo obrigat�rio"));

		
		//validar valor
		esperar(3000);
		mov.setInteressado("Intere");
		mov.salvar();
		Assert.assertTrue(mov.existeUmElementoPorTexto("Valor � um campo obrigat�rio"));
		
		//validar conta
		esperar(3000);
		mov.setValor("123");
		mov.salvar();
		Assert.assertTrue(mov.existeUmElementoPorTexto("Conta � um campo obrigat�rio"));
		
		//inserir conta com sucesso
		mov.setConta("Conta 123");
		esperar(3000);
		mov.salvar();
		Assert.assertTrue(mov.existeUmElementoPorTexto("Movimenta��o cadastrada com sucesso"));
		

	}
	
	@Test
	
	public void deveAtualizarSaldoAoExcluirMovimentacao() {
		//verificar saldo "Conta para saldo" = 534.00
		esperar(5000);
		Assert.assertEquals("534.00", home.obterSaldoConta("Conta para saldo"));
		
		//ir para resumo
		menuSB.acessarResumo();
		
		//excluir Movimenta��o 3
		resumo.excluirMovimentacao("Movimentacao 3, calculo saldo");
		
		//validar a mensagem de exclus�o
		Assert.assertTrue(resumo.existeUmElementoPorTexto("Movimenta��o removida com sucesso!"));
		
		//voltar ao home
		menuSB.acessarHome();
		
		//atualizar saldos
		esperar(2000);
		home.scroll(0.2, 0.9);
		
		//verificar saldo = -1000
		Assert.assertEquals("-1000.00", home.obterSaldoConta("Conta para saldo"));

		
		
		
		
	}
}
