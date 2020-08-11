package br.ce.wcaquino.appium.SBpage;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;

public class SBHomePage extends BasePage {
	
	public String obterSaldoConta(String conta) {
		return obterTexto(By.xpath("//*[@text='"+conta+"']/following-sibling::android.widget.TextView"));
	}

}
