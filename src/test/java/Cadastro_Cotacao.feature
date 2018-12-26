#language: pt
#encoding: iso-8859-1
#autor: janio.marinho@confitec.com.br

@Cadastro_Nova_Cotação
Funcionalidade: Registrar cadastro
  Cliente faz registro de uma cotação de seguro de vida.

  @Nova_Cotação
  Cenario: Gerar nova cotação
  	Quando clicar no botão "Iniciar" nova cotação. 
  	Entao digitar informações pessoais.
    E clicar botão "Enviar".
    Entao digitar informações de endereço.    
    E escolher plano.
    Entao digitar data vencimento.
    E escolher tipo comunicação. 
    Entao validar resumo contrato.