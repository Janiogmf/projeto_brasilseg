package Pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import Locators.Cadastro_Cotacao_Locators;
import RunTest.TestRule;
import RunTest.Utils;

public class Cadastro_Cotacao_Page extends Cadastro_Cotacao_Locators {
	public Cadastro_Cotacao_Page() {
		PageFactory.initElements(TestRule.getDriver(), this);
	}
	
	public void clicarBtnIniciar() {
		Utils.waitElementClicavel(btnIniciar);
		btnIniciar.click();
	}
	public void DadosPessoais() {
		Utils.waitElementClicavel(nome);
		nome.sendKeys("Fulano de Moraes Sousa");
		Utils.waitElementClicavel(cpf);
		cpf.sendKeys("52652636588");
		Utils.waitElementClicavel(data_nascimento);
		data_nascimento.sendKeys("13/05/1984");
		Utils.waitElementClicavel(agencia);
		agencia.click();
		agencia.sendKeys("18233");
		Utils.waitElementClicavel(conta_corrente);
		conta_corrente.click();
		conta_corrente.sendKeys("1925633");
		conta_corrente.submit();
		Utils.waitElementClicavel(telefone);
		telefone.click();
		telefone.sendKeys("11982566666");
		Utils.waitElementClicavel(email);
		email.sendKeys("fulano@teste.com.br");
	}


	public void clicarBtnEnviar() {
		Utils.waitElementClicavel(btnEnviar);
		btnEnviar.click();
	}

	public void dadosEndereco() throws InterruptedException {
		Utils.waitElementClicavel(cep);
		cep.click();
		cep.sendKeys("05729090");		
		Thread.sleep(1000);	
		for(int i=0; i<btnsEndereco.size(); i++) {
			if(btnsEndereco.get(i).getText().contains("Buscar")) {
				btnsEndereco.get(i).click();
			} 
		}
		num_logradouro.sendKeys("63");
		complemento.sendKeys("APTO 174");
		for(int i=0; i<btnsEndereco.size(); i++) {
			if(btnsEndereco.get(i).getText().contains("Gravar Endereco")) {
				btnsEndereco.get(i).click();
			} 
		}
	}

	public void selecionarPlano() throws InterruptedException {
		Utils.waitElementClicavel(btnProximo);
		TestRule.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		int indexPlano = 0;
		for (int i = 0; i<tagCarouselPlanos.size(); i++) {
			TestRule.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			for (int x = 0; x<descPlano.size(); x++) {
				if(descPlano.get(x).getText().equals("Plano Completo")) {
					indexPlano = x;
				}
			}
			if(descPlano.get(indexPlano).getText().equals("Plano Completo")) {
//				Utils.waitElementClicavelList(escolherPlano);
				Thread.sleep(500);
				escolherPlano.get(i).click();
			}
			else {
				btnProximo.click();
			}
		}
	}

	public void digitarData() {
		diaVencimento.sendKeys("15");
	}

	public void selecionarComunicacao() throws InterruptedException {
		Thread.sleep(500);
		radioComunicacao.click();
		btnEnviar.click();
	}

	public boolean validarResumoContrato() throws InterruptedException {
		Thread.sleep(500);
		String strMensagemExibida = "Plano Completo";
		if(strMensagemExibida.equals("Plano Completo")) {
			return true;
		}else {
			return false;
		}	
	}
	
	public void clicarContratar() throws InterruptedException {
		Utils.waitElementClicavel(btnContratar);
		btnContratar.click();
		Thread.sleep(1500);
		Utils.waitElementClicavel(labelCotacaoN);
	}
}
