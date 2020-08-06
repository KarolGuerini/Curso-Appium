package br.ce.wcaquino.appium.page;

import org.junit.Assert;
import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.DSL;
import io.appium.java_client.MobileBy;

public class FormularioPage {
	
	private DSL dsl = new DSL();
	
	public void escreverNome(String nome) {
		dsl.escrever(MobileBy.AccessibilityId("nome"), nome);

	}

	public String obterNome() {
		return dsl.obterTexto(MobileBy.AccessibilityId("nome"));
	}
	
	public void selecionarCombo(String valor) {
		dsl.selecionarCombo(MobileBy.AccessibilityId("console"), valor);
	}
	
	public String obterValorCombo() {
		return dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
	}
	
	public void clicarCheck() {
		dsl.clicar(By.className("android.widget.CheckBox"));
	}
	public void clicarSwitch() {
		 dsl.clicar(MobileBy.AccessibilityId("switch"));
	}
	
	public boolean isCheckMarcado() {
		return dsl.isCkeckMarcado(By.className("android.widget.CheckBox"));

	}
	
	public boolean isSwitchMarcado() {
		return dsl.isCkeckMarcado(MobileBy.AccessibilityId("switch"));	
	}
	
	public void salvar() {
		  dsl.clicarPorTexto("SALVAR");
	}
	
	public String obterNomeCadastrado() {
		return 	dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]"));
	
	}
	
	public String obterConsoleCadastrado() {
		  return dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));

	}
	
	
	public String obterCheckCadastado() {
		return dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
		
		

	}
	public String obterSwitchCadastrado() {
		return  dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]")); 

	}
	  
	
}
