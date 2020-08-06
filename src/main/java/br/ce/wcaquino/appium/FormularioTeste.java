package br.ce.wcaquino.appium;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class FormularioTeste {
	
	private AndroidDriver<MobileElement> driver;

	@Before
	public void inicializarAppium() throws MalformedURLException {
		driver = DriverFactory.getDriver();
		
	    //Selecionar a op��o formul�rio
	    driver.findElement(By.xpath("//android.widget.TextView[@text='Formul�rio']")).click();  //modo mais simples, por�m n�o muito confi�vel
	    //driver.findElement(By.xpath("//android.widget.TextView[@text='Formul�rio']")).click();  //modo padr�o xpath: //class[@atrib='value']
	}
	
	@After
	public void tearDown() {
	   DriverFactory.killDriver();
	}
	
	
	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
	    
	    
	    //digitar o nome 
	    MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome")); // o m�todo driver vai me retornar um mobileElement de campo nome
	    campoNome.sendKeys("Karol");   // dentro desse elemento mobile, no campo nome, eu vou digitar "Karol" 

	    
	    
	    //checar nome digitado
	    String text = campoNome.getText();
	    Assert.assertEquals("Karol", text);
	
	}
	

	@Test
	public void deveInteragirCombo() throws MalformedURLException {
		
	    
	    //clicar no combo
	    driver.findElement(MobileBy.AccessibilityId("console")).click();
	    
	    
	    //selecionar a op��o desejada
	    driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
	    
	    //verificar a op��o selecionada
	    String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();  // xpath modo: //class/class
	    Assert.assertEquals("Nintendo Switch", text);    
	
	}
	
	
	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {
	    
	  
	    //verificar status ds elementos 
	    MobileElement check = driver.findElement(By.className("android.widget.CheckBox"));
	    MobileElement switc = driver.findElement(By.className("android.widget.Switch"));  //n�o pode ser switch pois � uma palavra reservada 
	    Assert.assertTrue(check.getAttribute("checked").equals("false"));  // false pois a condi��o incial dele antes do teste � false
	    Assert.assertTrue(switc.getAttribute("checked").equals("true"));  // tue pois a condi��o incial dele antes do teste � true
	    
	    
	    //clicar nos elementos 
	    check.click();
	    switc.click();
	    
	    //verificar estados alterados 
	    Assert.assertFalse(check.getAttribute("checked").equals("false")); 
	    Assert.assertFalse(switc.getAttribute("checked").equals("true"));  
	    
	
	}
	
	
	@Test
	public void deveResolverDesafio() throws MalformedURLException {
	    
	   
	    
	    //preencher campos
	    driver.findElement(By.className("android.widget.EditText")).sendKeys("Karol Guerini");
	    driver.findElement(By.className("android.widget.CheckBox")).click();
	    driver.findElement(By.className("android.widget.Switch")).click();
	    driver.findElement(By.className("android.widget.Spinner")).click();
	    driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
	   
	    
	    //clicar em salvar 
	    driver.findElement(By.xpath("//*[@text='SALVAR']")).click();
	    
	    //verifica��es
	    MobileElement nome = driver.findElement(By.xpath("//android.widget.TextView[@text='Nome: Karol Guerini']"));
	    Assert.assertEquals("Nome: Karol Guerini", nome.getText());
	    
	    MobileElement combo = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]")); //busca pelo text que inicie pelo texto Console:
	    Assert.assertEquals("Console: switch", combo.getText());
	    
	    MobileElement switc = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]")); //busca pelo text que inicie pelo texto Switch:
	    Assert.assertTrue(switc.getText().endsWith("Off"));  //dentro do switch, v� se o texto termina com Off
	    
	    MobileElement check = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]")); 
	    Assert.assertTrue(check.getText().endsWith("Marcado")); 
	  
	}
}	
	
		
		

