package br.ce.wcaquino.appium.core;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;

public class BaseTest {
	
	@Rule
	public TestName testName = new TestName();
	
	@AfterClass
	public static void finalizaClasse() {  // tem que ser estático pq é a nivel de classe
		 DriverFactory.killDriver();
	}

	@After
	public void tearDown() {
	
	  // DriverFactory.getDriver().resetApp();
	}
	
	public void esperar(long tempo) {
		
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}


