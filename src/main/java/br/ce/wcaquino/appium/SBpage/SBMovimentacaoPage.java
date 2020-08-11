package br.ce.wcaquino.appium.SBpage;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;

public class SBMovimentacaoPage extends BasePage {
	
	public void salvar() {
		clicarPorTexto("SALVAR");
	}
	
		public void setDescricao(String desc) {
			escrever(By.className("android.widget.EditText"),desc ); //esse pode ser por classe pq ele é o primeiro que aparece dentro do grupo
			
		}
		
		public void setInteressado(String interessado) {
			escrever(By.xpath("//android.widget.EditText[2]"), interessado);//essa classe se repete, então preciso dizer quando ele aparece, que nesse caso é o segundo 
		}
		
		public void setValor(String valor) {
			escrever(By.xpath("//android.widget.EditText[3]"), valor);//essa classe se repete, então preciso dizer quando ele aparece, que nesse caso é o terceiro 

		}
		
		public void setConta(String conta) {
			selecionarCombo(By.xpath("//android.widget.Spinner[2]"), conta);
		}
}
