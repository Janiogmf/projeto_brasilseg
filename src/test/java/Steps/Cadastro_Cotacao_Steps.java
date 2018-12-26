package Steps;

import org.junit.Assert;
import Pages.Cadastro_Cotacao_Page;
import RunTest.Utils;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class Cadastro_Cotacao_Steps {
	Cadastro_Cotacao_Page cadastroPage = new Cadastro_Cotacao_Page();
	@Quando("^clicar no bot�o \"([^\"]*)\" nova cota��o\\.$")
	public void clicarBotaoIniciar(String btnIniciar) {
		cadastroPage.clicarBtnIniciar();
	}
	
	@Entao("^digitar informa��es pessoais\\.$")
	public void digitarDadosPessoais() {
		try {
		cadastroPage.DadosPessoais();
//		Utils.logPrint("digitar informa��es pessoais");
		Utils.logPrintBase64("digitar informa��es pessoais BASE64");
		}catch(Exception ex){
			Utils.logPrintBase64("Error ao executar step: digitar informa��es pessoais");
		}
	}

	@Entao("^clicar bot�o \"([^\"]*)\"\\.$")
	public void clicarBotaoEnviar(String btnEnviar) {
		cadastroPage.clicarBtnEnviar();
	}
	
	@Entao("^digitar informa��es de endere�o\\.$")
	public void digitarEndereco() throws InterruptedException {
		cadastroPage.dadosEndereco();
//		Utils.logPrint("digitar informa��es de endere�o");
		Utils.logPrintBase64("digitar informa��es de endere�o BASE64");
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
	
	@Entao("^escolher tipo comunica��o\\.$")
	public void escolherComunicacao() throws InterruptedException{
		cadastroPage.selecionarComunicacao();
//		Utils.logPrint("escolher tipo comunica��o");
		Utils.logPrintBase64("escolher tipo comunica��o BASE64");
	}
	
	@Entao("^validar resumo contrato\\.$")
	public void validarResumo() throws InterruptedException {
		cadastroPage.validarResumoContrato();
		boolean blnPlanoExibido = cadastroPage.validarResumoContrato();
		if(blnPlanoExibido) {
			Utils.logPass("Plano escolhido visualizado na tela de resumo");
		}else {
			Utils.logFail("Plano escolhido n�o corresponde ao visualizado na tela de resumo");
		}
		Assert.assertTrue("N�o exibiu o plano correto!", blnPlanoExibido );
		cadastroPage.clicarContratar();
//		Utils.logPrint("clicar bot�o contratar");
		Utils.logPrintBase64("clicar bot�o contratar BASE64");
	}
}
