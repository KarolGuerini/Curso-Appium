package br.ce.wcaquino.appium;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.DSL;
import br.ce.wcaquino.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;

public class FormularioTeste {
	
	//private AndroidDriver<MobileElement> driver;
	
	private DSL dsl = new DSL();
	

	@Before
	public void inicializarAppium() throws MalformedURLException {
		//driver = DriverFactory.getDriver();
		
	    //Selecionar a opção formulário
		dsl.clicarPorTexto("Formulário");
		
	    //driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();  //modo mais simples, porém não muito confiável
	    //driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();  //modo padrão xpath: //class[@atrib='value']
	}
	
	@After
	public void tearDown() {
	   DriverFactory.killDriver();
	}
	
	
	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
	    
	    
	    //digitar o nome
		dsl.escrever(MobileBy.AccessibilityId("nome"), "Karol");
		
		
	   // MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome")); // o método driver vai me retornar um mobileElement de campo nome
	   // campoNome.sendKeys("Karol");   // dentro desse elemento mobile, no campo nome, eu vou digitar "Karol" 
	    
	    //checar nome digitado
		Assert.assertEquals("Karol", dsl.obterTexto(MobileBy.AccessibilityId("nome")));
		
	   // String text = campoNome.getText();
	    //Assert.assertEquals("Karol", text);
	
	}
	
	

	@Test
	public void deveInteragirCombo() throws MalformedURLException {
		
	    
	    //clicar no combo
		dsl.selecionarCombo(MobileBy.AccessibilityId("console"), "Nintendo Switch");
	      //driver.findElement(MobileBy.AccessibilityId("console")).click();
	    
	    
	    //selecionar a opção desejada
	      // driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
		
	    
	    //verificar a opção selecionada
		String text = dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
		 Assert.assertEquals("Nintendo Switch", text);
		
	      // String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();  // xpath modo: //class/class
	      // Assert.assertEquals("Nintendo Switch", text);    
	
	}
	
	
	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {
	    //verificar status ds elementos  
		Assert.assertFalse(dsl.isCkeckMarcado(By.className("android.widget.CheckBox")));
	    Assert.assertTrue(dsl.isCkeckMarcado(MobileBy.AccessibilityId("switch")));

	    //MobileElement check = driver.findElement(By.className("android.widget.CheckBox"));
	    //MobileElement switc = driver.findElement(By.className("android.widget.Switch"));  //não pode ser switch pois é uma palavra reservada
	    
	    //Assert.assertTrue(check.getAttribute("checked").equals("false"));  // false pois a condição incial dele antes do teste é false
	    //Assert.assertTrue(switc.getAttribute("checked").equals("true"));  // tue pois a condição incial dele antes do teste é true
	    
	    
	    //clicar nos elementos 
	    dsl.clicar(By.className("android.widget.CheckBox"));
	    dsl.clicar(MobileBy.AccessibilityId("switch"));
	    
	    //check.click();
	    //switc.click();
	    
	    //verificar estados alterados 
	    Assert.assertTrue(dsl.isCkeckMarcado(By.className("android.widget.CheckBox")));
	    Assert.assertFalse(dsl.isCkeckMarcado(MobileBy.AccessibilityId("switch")));

	    
	
	}
	
	
	@Test
	public void deveRealizarCadastro() throws MalformedURLException {
		
	    //preencher campos
		dsl.escrever(By.className("android.widget.EditText"), "Karol Guerini");
	    dsl.clicar(By.className("android.widget.CheckBox"));
	    dsl.clicar(By.className("android.widget.Switch"));
	    dsl.selecionarCombo(By.className("android.widget.Spinner"), "Nintendo Switch");
		
		
	    //driver.findElement(By.className("android.widget.EditText")).sendKeys("Karol Guerini");
	    //driver.findElement(By.className("android.widget.CheckBox")).click();
	    //driver.findElement(By.className("android.widget.Switch")).click();
	    //driver.findElement(By.className("android.widget.Spinner")).click();
	    //driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
	   
	    
	    //clicar em salvar 
	    dsl.clicarPorTexto("SALVAR");
	    //driver.findElement(By.xpath("//*[@text='SALVAR']")).click();
	    
	    //verificações
	    Assert.assertEquals("Nome: Karol Guerini", dsl.obterTexto(By.xpath("//android.widget.TextView[@text='Nome: Karol Guerini']")));
	    Assert.assertEquals("Console: switch", dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]")));
	    Assert.assertTrue(dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]")).endsWith("Off"));  
	    Assert.assertTrue(dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]")).endsWith("Marcado"));
	    

	    //MobileElement nome = driver.findElement(By.xpath("//android.widget.TextView[@text='Nome: Karol Guerini']"));
	    // Assert.assertEquals("Nome: Karol Guerini", nome.getText());
	    
	    //MobileElement combo = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]")); //busca pelo text que inicie pelo texto Console:
	    //Assert.assertEquals("Console: switch", combo.getText());
	    
	    //MobileElement switc = //busca pelo text que inicie pelo texto Switch.
	   //Assert.assertTrue(dsl.clicarPorTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));endsWith("Off"));  //dentro do switch, vê se o texto termina com Off
	    
	   // MobileElement check = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]")); 
	   // Assert.assertTrue(check.getText().endsWith("Marcado")); 
	  
	}

	private boolean endsWith(String string) {
		// TODO Auto-generated method stub
		return false;
	}
}	
	
		
		


