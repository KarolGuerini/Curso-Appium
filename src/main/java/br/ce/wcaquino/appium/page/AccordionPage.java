package br.ce.wcaquino.appium.page;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;

public class AccordionPage extends BasePage {
	
	public void selecionarOp1() {
		clicarPorTexto("Opção 1");
		
	}
	public String obterValorOp1() {
		return obterTexto(By.xpath("//android.widget.TextView[@text='Esta é a descrição da opção 1']"));
		
		
	}

}
