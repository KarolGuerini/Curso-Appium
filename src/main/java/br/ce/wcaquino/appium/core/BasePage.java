package br.ce.wcaquino.appium.core;

import static br.ce.wcaquino.appium.core.DriverFactory.getDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class BasePage extends BaseTest{

	public void escrever(By by, String texto) {
		getDriver().findElement(by).sendKeys(texto);   	
	}
	

	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
		 
	}
	
	public void clicar(By by) {
		getDriver().findElement(by).click();
	}
	
	public void clicarPorTexto(String texto) {
		clicar(By.xpath("//*[@text='"+texto+"']"));
		
	}
	
	
	public void selecionarCombo(By by, String valor) {   
	    getDriver().findElement(by).click();
	    clicarPorTexto(valor); 
	    
	    //getDriver().findElement(By.xpath("//android.widget.CheckedTextView[@text='"+valor+"']")).click();   
	   	
	}
	
	public boolean isCkeckMarcado(By by) {
		 return getDriver().findElement(by).getAttribute("checked").equals("true");
	}
	
	public boolean existeUmElementoPorTexto(String texto) {
		List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='"+texto+"']"));
		return elementos.size()>0;
		
	}
	
	public String obterTituloAlerta() {
		return obterTexto(By.id("android:id/alertTitle"));
		
	}
	
	public String obterMensagemAlerta() {
		return obterTexto(By.id("android:id/message"));
		
	}
	public void tap(int x, int y) {
		new TouchAction(getDriver()).tap(x, y).perform();
	}
	
	public void scrollDown() {
		scroll(0.9, 0.1);
	}
	
	public void scrollUp() {
		scroll(0.1, 0.9);
	}
	
	public void swipeLeft() {
		swipe(0.1, 0.9);
	}
	
	public void swipeRigth() {
		swipe(0.9, 0.1);
	}
	
	public void scroll(double inicio, double fim) {
		Dimension size = getDriver().manage().window().getSize();
		
		int x = size.width /2;
		
		int y_inicial = (int) (size.height * inicio);
		int y_final = (int) (size.height * fim);
		
		new TouchAction(getDriver()).press(x, y_inicial).waitAction(Duration.ofMillis(500)).moveTo(x, y_final).release().perform();
		
	}
	
	public void swipe(double inicio, double fim) {
		Dimension size = getDriver().manage().window().getSize();
		
		int y = size.height /2;
		
		int x_inicial = (int) (size.width * inicio);
		int x_final = (int) (size.width * fim);
		
		new TouchAction(getDriver()).press( x_inicial, y).waitAction(Duration.ofMillis(500)).moveTo( x_final, y).release().perform();
		


	}
	
	public void swipeElement(MobileElement element, double inicio, double fim) {
		int y = element.getLocation().y + (element.getSize().height / 2);
		
		int x_inicial = (int) (element.getSize().width * inicio);
		int x_final = (int) (element.getSize().width * fim);
		
		new TouchAction(getDriver()).press( x_inicial, y).waitAction(Duration.ofMillis(500)).moveTo( x_final, y).release().perform();	
		
	}
	public void cliqueLongo(By by) {
		new TouchAction(DriverFactory.getDriver())
		.longPress(DriverFactory.getDriver()
				.findElement(by)).perform();
		
	}
	
	

	
}

