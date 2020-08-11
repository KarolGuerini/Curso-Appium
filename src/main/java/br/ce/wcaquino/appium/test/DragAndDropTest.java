package br.ce.wcaquino.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.DragNDropage;
import br.ce.wcaquino.appium.page.MenuPage;

public class DragAndDropTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private DragNDropage page = new DragNDropage();
	
	
	private String[] estadoInicial = new String[] {"Esta","� uma lista","Drag em Drop!","Fa�a um clique longo,","e arraste para","qualquer local desejado."};
	private String[] estadoIntermediario = new String[] {"� uma lista","Drag em Drop!","Fa�a um clique longo,","e arraste para","Esta","qualquer local desejado."};
	private String[] estadoFinal = new String[] {"Fa�a um clique longo,","� uma lista","Drag em Drop!","e arraste para","Esta","qualquer local desejado."};

	
	@Test
	
	public void deveEfetuarDragAndDrop() {
		
		//acessar menu
		menu.clicarDragAndDrop();
		
		//verificar estado inicial
		Assert.assertArrayEquals(estadoInicial, page.obterLista());
		//page.obterLista();
		
			
		// arrastar "Esta" para "e arraste para"
		page.arrastar("Esta", "e arraste para");
		
		//verificar estado intermedi�rio
		Assert.assertArrayEquals(estadoIntermediario, page.obterLista());
		
		//arrastar "Fa�a um clique longo" para "� uma lista"
		page.arrastar("Fa�a um clique longo,", "� uma lista");

		
		//verificar estado final 
		Assert.assertArrayEquals(estadoFinal, page.obterLista());
		

	}

}
