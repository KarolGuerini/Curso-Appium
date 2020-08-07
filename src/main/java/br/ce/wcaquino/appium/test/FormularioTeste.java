package br.ce.wcaquino.appium.test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.core.DriverFactory;
import br.ce.wcaquino.appium.page.FormularioPage;
import br.ce.wcaquino.appium.page.MenuPage;

public class FormularioTeste extends BaseTest{
	
	//private AndroidDriver<MobileElement> driver;
	
	
	private MenuPage menu = new MenuPage();
	
	private FormularioPage page = new FormularioPage();
	
	

	@Before
	public void inicializarAppium() throws MalformedURLException {
		//driver = DriverFactory.getDriver();
		
	    //Selecionar a op��o formul�rio
		menu.AcessarFormulario();
		
	    //driver.findElement(By.xpath("//android.widget.TextView[@text='Formul�rio']")).click();  //modo mais simples, por�m n�o muito confi�vel
	    //driver.findElement(By.xpath("//android.widget.TextView[@text='Formul�rio']")).click();  //modo padr�o xpath: //class[@atrib='value']
	}
	
	
	
	
	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
	    
	    
	    //digitar o nome
		page.escreverNome("Karol");
		
		//dsl.escrever(MobileBy.AccessibilityId("nome"), "Karol");
		
	   // MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome")); // o m�todo driver vai me retornar um mobileElement de campo nome
	   // campoNome.sendKeys("Karol");   // dentro desse elemento mobile, no campo nome, eu vou digitar "Karol" 
	    
	    //checar nome digitado
		Assert.assertEquals("Karol", page.obterNome());
		
	   // String text = campoNome.getText();
	    //Assert.assertEquals("Karol", text);
	
	}
	
	

	@Test
	public void deveInteragirCombo() throws MalformedURLException {
		
	    
	    //clicar no combo
		page.selecionarCombo("Nintendo Switch");
		
	    //driver.findElement(MobileBy.AccessibilityId("console")).click();
	    
	    //selecionar a op��o desejada
	    // driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
		
	    
	    //verificar a op��o selecionada
		 Assert.assertEquals("Nintendo Switch", page.obterValorCombo());
		
	      // String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();  // xpath modo: //class/class
	      // Assert.assertEquals("Nintendo Switch", text);    
	
	}
	
	
	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {
	    //verificar status ds elementos  
		Assert.assertFalse(page.isCheckMarcado());
	    Assert.assertTrue(page.isSwitchMarcado());
	    

	    //MobileElement check = driver.findElement(By.className("android.widget.CheckBox"));
	    //MobileElement switc = driver.findElement(By.className("android.widget.Switch"));  //n�o pode ser switch pois � uma palavra reservada
	    
	    //Assert.assertTrue(check.getAttribute("checked").equals("false"));  // false pois a condi��o incial dele antes do teste � false
	    //Assert.assertTrue(switc.getAttribute("checked").equals("true"));  // tue pois a condi��o incial dele antes do teste � true
	    
	    
	    //clicar nos elementos 
	    page.clicarCheck();
	    page.clicarSwitch();
	    
	    //dsl.clicar(By.className("android.widget.CheckBox"));
	    //dsl.clicar(MobileBy.AccessibilityId("switch"));
	    
	    //check.click();
	    //switc.click();
	    
	    //verificar estados alterados 
	    Assert.assertTrue(page.isCheckMarcado());    
	    Assert.assertFalse(page.isSwitchMarcado());
	}
	
	
	
	@Test
	public void deveRealizarCadastro() throws MalformedURLException {
		
	    //preencher campos
		page.escreverNome("Karol Guerini");
		page.clicarCheck();
		page.clicarSwitch();
		page.selecionarCombo("Nintendo Switch");
		
		//dsl.escrever(By.className("android.widget.EditText"), "Karol Guerini");
	    //dsl.clicar(By.className("android.widget.CheckBox"));
	    //dsl.clicar(By.className("android.widget.Switch"));
	    //dsl.selecionarCombo(By.className("android.widget.Spinner"), "Nintendo Switch");
		
		
	    //driver.findElement(By.className("android.widget.EditText")).sendKeys("Karol Guerini");
	    //driver.findElement(By.className("android.widget.CheckBox")).click();
	    //driver.findElement(By.className("android.widget.Switch")).click();
	    //driver.findElement(By.className("android.widget.Spinner")).click();
	    //driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
	   
	    
	    //clicar em salvar 
		page.salvar();
		
	    //dsl.clicarPorTexto("SALVAR");
	    //driver.findElement(By.xpath("//*[@text='SALVAR']")).click();
	    
	    //verifica��es
	    Assert.assertEquals("Nome: Karol Guerini",page.obterNomeCadastrado());
	    Assert.assertEquals("Console: switch",page.obterConsoleCadastrado());
	    Assert.assertTrue(page.obterSwitchCadastrado().endsWith("Off"));  
	    Assert.assertTrue(page.obterCheckCadastado().endsWith("Marcado"));
	    

	    //MobileElement nome = driver.findElement(By.xpath("//android.widget.TextView[@text='Nome: Karol Guerini']"));
	    // Assert.assertEquals("Nome: Karol Guerini", nome.getText());
	    
	    //MobileElement combo = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]")); //busca pelo text que inicie pelo texto Console:
	    //Assert.assertEquals("Console: switch", combo.getText());
	    
	    //MobileElement switc = //busca pelo text que inicie pelo texto Switch.
	   //Assert.assertTrue(dsl.clicarPorTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));endsWith("Off"));  //dentro do switch, v� se o texto termina com Off
	    
	   // MobileElement check = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]")); 
	   // Assert.assertTrue(check.getText().endsWith("Marcado")); 
	  
	}
	
	@Test
	public void deveRealizarCadastroDemorado() throws MalformedURLException {
	    
	    //preencher campos
		page.escreverNome("Karol Guerini");
	   
	    
	    //clicar em salvar 
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //espera o elemento aparecer na tela e pode ser usado tanto em cada caso de teste como na configura��o do Driver 
		page.salvarDemorado();
		esperar(3000);  // uma op��o para esperar o elemento na tela, mas n�o � muito usual 
		
		
	    
	    //verifica��es
	    Assert.assertEquals("Nome: Karol Guerini",page.obterNomeCadastrado());
	  
	}
	

	
}	
	
		
		


