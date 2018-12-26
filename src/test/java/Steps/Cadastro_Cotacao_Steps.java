package Steps;

import org.junit.Assert;
import Pages.Cadastro_Cotacao_Page;
import RunTest.Utils;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class Cadastro_Cotacao_Steps {
	Cadastro_Cotacao_Page cadastroPage = new Cadastro_Cotacao_Page();
	@Quando("^clicar no botão \"([^\"]*)\" nova cotação\\.$")
	public void clicarBotaoIniciar(String btnIniciar) {
		cadastroPage.clicarBtnIniciar();
	}
	
	@Entao("^digitar informações pessoais\\.$")
	public void digitarDadosPessoais() {
		try {
		cadastroPage.DadosPessoais();
//		Utils.logPrint("digitar informações pessoais");
		Utils.logPrintBase64("digitar informações pessoais BASE64");
		}catch(Exception ex){
			Utils.logPrintBase64("Error ao executar step: digitar informações pessoais");
		}
	}

	@Entao("^clicar botão \"([^\"]*)\"\\.$")
	public void clicarBotaoEnviar(String btnEnviar) {
		cadastroPage.clicarBtnEnviar();
	}
	
	@Entao("^digitar informações de endereço\\.$")
	public void digitarEndereco() throws InterruptedException {
		cadastroPage.dadosEndereco();
//		Utils.logPrint("digitar informações de endereço");
		Utils.logPrintBase64("digitar informações de endereço BASE64");
	}
	
	@Entao("^escolher plano\\.$")
	public void escolherPlano() throws InterruptedException {
		cadastroPage.selecionarPlano();
//		Utils.logPrint("escolher plano");
		Utils.logPrintBase64("escolher plano BASE64");
	}
	
	@Entao("^digitar data vencimento\\.$")
	public void digitarVencimento() {
		cadastroPage.digitarData();
	}
	
	@Entao("^escolher tipo comunicação\\.$")
	public void escolherComunicacao() throws InterruptedException{
		cadastroPage.selecionarComunicacao();
//		Utils.logPrint("escolher tipo comunicação");
		Utils.logPrintBase64("escolher tipo comunicação BASE64");
	}
	
	@Entao("^validar resumo contrato\\.$")
	public void validarResumo() throws InterruptedException {
		cadastroPage.validarResumoContrato();
		boolean blnPlanoExibido = cadastroPage.validarResumoContrato();
		if(blnPlanoExibido) {
			Utils.logPass("Plano escolhido visualizado na tela de resumo");
		}else {
			Utils.logFail("Plano escolhido não corresponde ao visualizado na tela de resumo");
		}
		Assert.assertTrue("Não exibiu o plano correto!", blnPlanoExibido );
		cadastroPage.clicarContratar();
//		Utils.logPrint("clicar botão contratar");
		Utils.logPrintBase64("clicar botão contratar BASE64");
	}
}
