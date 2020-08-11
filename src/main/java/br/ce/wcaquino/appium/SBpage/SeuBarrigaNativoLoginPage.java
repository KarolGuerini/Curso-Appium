package br.ce.wcaquino.appium.SBpage;

import java.util.Set;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;
import br.ce.wcaquino.appium.core.DriverFactory;

public class SeuBarrigaNativoLoginPage extends BasePage {
	
	public void entrarContextoWeb() {
		Set<String> contextHandles = DriverFactory.getDriver().getContextHandles(); //mostra os contextos existentes 
	    DriverFactory.getDriver().context((String) contextHandles.toArray()[1]);  //indice 1 é do contexto web

	}
	
	
	public void setEmail(String email) {
		escrever(By.className("android.widget.EditText"), email);
		
	}
	
    public void setSenha(String senha) {
    	escrever(By.xpath("//android.widget.EditText[2]"), senha); //dentro dessa classe, ele é o segundo, por isso o [2]
		
	}
    public void entrar() {
    	clicarPorTexto("ENTRAR");
		
   	}
}
