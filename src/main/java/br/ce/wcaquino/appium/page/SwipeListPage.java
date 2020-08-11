package br.ce.wcaquino.appium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.wcaquino.appium.core.BasePage;
import br.ce.wcaquino.appium.core.DriverFactory;
import io.appium.java_client.TouchAction;

public class SwipeListPage extends BasePage {
	
	public void swipeElementRigth(String opcao) {
		swipeElement(DriverFactory.getDriver().findElement(By.xpath("//*[@text='"+opcao+"']/..")),0.9, 0.1);
		
	}
	
	public void swipeElementLetft(String opcao) {
		swipeElement(DriverFactory.getDriver().findElement(By.xpath("//*[@text='"+opcao+"']/..")),0.1, 0.9);  // O /.. sobe um nível a pasta 
		
	}
	public void clicarBotaoMais() {
		WebElement botao= DriverFactory.getDriver().findElement(By.xpath("//*[@text='(+)']/.."));
		new TouchAction(DriverFactory.getDriver()).tap(botao, -60, 0).perform();
	}

}
