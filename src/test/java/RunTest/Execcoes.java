package RunTest;

import junit.framework.TestCase;

//import Pages.Cadastro_Cotacao_Page;

public class Execcoes extends TestCase {
	public void testExecutaCalculo() {
		float valor1 = 10;
		float valor2 = 5;
		float retorno1 = 15;
		
		float retorno2 = valor1 + valor2 + 1;
		
		assertEquals(retorno1, retorno2, 0);
		
	}
	
	
//	public void tratamentoexcecoes(String metodo) {
////		Cadastro_Cotacao_Page cadastroPage = new Cadastro_Cotacao_Page();
//		try {
//			
//		}catch(Exception e){
//			
//		}
//	}
}
