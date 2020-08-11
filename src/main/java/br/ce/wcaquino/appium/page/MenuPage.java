package br.ce.wcaquino.appium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.wcaquino.appium.core.BasePage;
import br.ce.wcaquino.appium.core.DriverFactory;

public class MenuPage extends BasePage{

	
	public void AcessarFormulario() {
		clicarPorTexto("Formulário");
		
	}
	
	public void acessarSplash() {
		clicarPorTexto("Splash");
	}
	
	public void acessarAlertas() {
		clicarPorTexto("Alertas");
	}
	
	public void acessarMenuAbas() {
		clicarPorTexto("Abas");
	}
	
	public void acessarAccordion() {
		clicarPorTexto("Accordion");
	}
	
	public void acessarCliques() {
		clicarPorTexto("Cliques");
	}
	
	public void acessarSwipe() {
		clicarPorTexto("Swipe");
		
	}
	
	public void clicarSwipeList() {
		
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
		scrollDown();
		
		clicarPorTexto("Swipe List");
		
	}
	
	public void clicarDragAndDrop() {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
		scrollDown();
		
		clicarPorTexto("Drag and drop");		
	}
	
	public void acessarSeuBarrigaHibrido() {
		clicarPorTexto("SeuBarriga Híbrido");
		
	}
	
	public void acessarSeuBarrigaNativo() {
		clicarPorTexto("SeuBarriga Nativo");
		
	}
}
