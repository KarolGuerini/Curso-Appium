package br.ce.wcaquino.appium.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {

	private static AndroidDriver<MobileElement> driver;
	
	public static  AndroidDriver<MobileElement> getDriver() {  // se não tiver driver ele vai criar um  driver
		if(driver == null) {
		//creatTesObjectDriver();
		creatDriver();
			
		}
		return driver;
		
	}

	private static void creatDriver() {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Testing Company\\eclipse-workspace\\CursoAppium\\src\\main\\resources\\CTAppium_1_2.apk");
	 
	    try {
			driver= new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);   //vai inicializar o driver
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	    
	    driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    
	   
	}
	
	/*private static void creatTesObjectDriver() {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("testobject_api_key", "DEBC363BB2984C57B25405F22DC83452");	
	    desiredCapabilities.setCapability("appiumVersion", "1.17.1");
	    //desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    //desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Testing Company\\eclipse-workspace\\CursoAppium\\src\\main\\resources\\CTAppium_1_2.apk");
	 
	    try {
			driver= new AndroidDriver<MobileElement>(new URL("https://us1.appium.testobject.com/wd/hub"), desiredCapabilities);
			//driver= new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);//vai inicializar o driver
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	    
	    driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    }
	    
	    PARA EXECUTAR NA NUVEM, USAR OS COMANDOS ACIMA
	   */

	
	public static void killDriver() {   //ele fecha se já tiver um driver aberto e quando alguém pedir um outro driver após isso, ele vai criar um novo driver 
		if (driver !=null) {
			driver.quit();
			driver = null;
		}
		
	}
}
