package Locators;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class Cadastro_Cotacao_Locators {	
	//Dados pessoais cadastro
	@FindBy(css = "a[href^='/cotacao']")
	protected WebElement btnIniciar;
	
	protected WebElement nome;
	protected WebElement cpf;
	protected WebElement data_nascimento;
	protected WebElement agencia;
	protected WebElement conta_corrente;
	protected WebElement telefone;
	protected WebElement email;
	
	@FindBy(css = "button[type='submit']")
	protected WebElement btnEnviar;
	
	//Endereço cadastro
	protected WebElement cep;
	@FindBys({
			  @FindBy(css = "button[class='btn btn-primary racinput1']"),
			})
	protected List<WebElement> btnsEndereco;
	protected WebElement num_logradouro;
	protected WebElement complemento;	
	
	//Escolha plano
	
	@FindBy(css = "a[class='carousel-control-next'")
	protected WebElement btnProximo;
	
	@FindBys({
		  @FindBy(css = "div[class*='carousel-item']")
		})
    protected List<WebElement> tagCarouselPlanos;
	@FindBys({
			@FindBy(css = "h5[class='card-title']")
			})
	protected List<WebElement> descPlano;
	
	@FindBys({
			  @FindBy(css = "h5[class='card-title']")
			})
	protected List<WebElement> plano;
	
	@FindBys({
			  @FindBy(css = "button[id='SelPlano']")
			})
	protected List<WebElement> escolherPlano;
	
	//Vencimento e comunicação
	
	protected WebElement diaVencimento;
	@FindBy(css = "input[value='email']")
	protected WebElement radioComunicacao;
	
	@FindBys({
			@FindBy(css = "div[class='col-sm-4 col-lg-4']")
			})
	protected List<WebElement> planoEcolhido;
	
	@FindBy(css = "button[type='button']")
	protected WebElement btnContratar;	
	
	@FindBy(css = "label[class='form-label']")
	protected WebElement labelCotacaoN;
}
