package br.ce.wcaquino.appium.page;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;
import br.ce.wcaquino.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class FormularioPage extends BasePage {
	
	
	public void escreverNome(String nome) {
		escrever(MobileBy.AccessibilityId("nome"), nome);

	}

	public String obterNome() {
		return obterTexto(MobileBy.AccessibilityId("nome"));
	}
	
	public void selecionarCombo(String valor) {
		selecionarCombo(MobileBy.AccessibilityId("console"), valor);
	}
	
	public String obterValorCombo() {
		return obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
	}
	
	public void clicarCheck() {
		clicar(By.className("android.widget.CheckBox"));
	}
	public void clicarSwitch() {
		 clicar(MobileBy.AccessibilityId("switch"));
	}
	
	public boolean isCheckMarcado() {
		return isCkeckMarcado(By.className("android.widget.CheckBox"));

	}
	
	public boolean isSwitchMarcado() {
		return isCkeckMarcado(MobileBy.AccessibilityId("switch"));	
	}
	
	public void clicarSeekBar(double posicao) {
		
		int delta = 50;
       MobileElement seek = DriverFactory.getDriver().findElement(MobileBy.AccessibilityId("slid"));
       int y = (int) (seek.getLocation().y + (seek.getSize().height / 2));
       System.out.println(y);
       
       int xInicial = seek.getLocation().x + delta;
       int x = (int) (xInicial + ((seek.getSize().width- 2*delta) * posicao));
       System.out.println(x);
       
       tap(x, y);
       
       
	}
	
	public void salvar() {
		  clicarPorTexto("SALVAR");
	}
	
	public void salvarDemorado() {
		  clicarPorTexto("SALVAR DEMORADO");
	}
	
	public String obterNomeCadastrado() {
		return 	obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]"));
	
	}
	
	public String obterConsoleCadastrado() {
		  return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));

	}
	
	
	public String obterCheckCadastado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
		
		

	}
	public String obterSwitchCadastrado() {
		return  obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]")); 

	}
	
	
	  
	
}
