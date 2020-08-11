package br.ce.wcaquino.appium.page;

import java.util.Set;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;
import br.ce.wcaquino.appium.core.DriverFactory;

public class WebViewPage extends BasePage {
	
	

	public void entrarContextoWeb() {
		Set<String> contextHandles = DriverFactory.getDriver().getContextHandles(); //mostra os contextos existentes 
	    DriverFactory.getDriver().context((String) contextHandles.toArray()[1]);  //indice 1 é do contexto web

	}
	
	public void sairContextoWeb() {
		Set<String> contextHandles = DriverFactory.getDriver().getContextHandles(); //mostra os contextos existentes 
	    DriverFactory.getDriver().context((String) contextHandles.toArray()[0]);  //indice 0 é do contexto app

	}
	
	public void setEmail(String valor) {
		DriverFactory.getDriver().findElement(By.id("email")).sendKeys(valor);
	}
	public void setSenha(String valor) {
		DriverFactory.getDriver().findElement(By.id("senha")).sendKeys(valor);
	}
	public void entrar() {
		clicar(By.xpath("//button[@type='submit']"));
	}
	
	public  String validarEntrada() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}
	

	}


