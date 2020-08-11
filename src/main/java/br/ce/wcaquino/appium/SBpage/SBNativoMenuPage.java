package br.ce.wcaquino.appium.SBpage;

import br.ce.wcaquino.appium.core.BasePage;

public class SBNativoMenuPage extends BasePage {
	
	public void acessarContas() {
		clicarPorTexto("CONTAS");
		
	}
	
	public void acessarMovimentacoes() {
		clicarPorTexto("MOV...");
	}
	
	public void acessarResumo() {
		clicarPorTexto("RESUMO");
	}
	
	public void acessarHome() {
		clicarPorTexto("HOME");
	}

}
