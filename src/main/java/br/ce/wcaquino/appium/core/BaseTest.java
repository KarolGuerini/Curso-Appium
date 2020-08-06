package br.ce.wcaquino.appium.core;

import org.junit.After;
import org.junit.AfterClass;

public class BaseTest {
	
	@AfterClass
	public static void finalizaClasse() {  // tem que ser est�tico pq � a nivel de classe
		 DriverFactory.killDriver();
	}

	@After
	public void tearDown() {
	   DriverFactory.getDriver().resetApp();
	}
}


