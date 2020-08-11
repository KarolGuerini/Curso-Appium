package br.ce.wcaquino.appium.SBpage;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;

public class SBNativoContasPage extends BasePage {
	
	
	public void setConta(String nome) {
		escrever(By.className("android.widget.EditText"), nome);
	}
	
	public void salvarConta() {
		clicarPorTexto("SALVAR");
	}
	
	public void selecionarConta(String conta) {
		cliqueLongo(By.xpath("//*[@text='"+conta+"']"));

	}
	
	public void excluirConta() {
		clicarPorTexto("EXCLUIR");

	}

}
