#language: pt
#encoding: iso-8859-1
#autor: janio.marinho@confitec.com.br

@Cadastro_Nova_Cota��o
Funcionalidade: Registrar cadastro
  Cliente faz registro de uma cota��o de seguro de vida.

  @Nova_Cota��o
  Cenario: Gerar nova cota��o
  	Quando clicar no bot�o "Iniciar" nova cota��o. 
  	Entao digitar informa��es pessoais.
    E clicar bot�o "Enviar".
    Entao digitar informa��es de endere�o.    
    E escolher plano.
    Entao digitar data vencimento.
    E escolher tipo comunica��o. 
    Entao validar resumo contrato.