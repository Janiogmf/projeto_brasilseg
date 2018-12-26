package RunTest;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class Utils {
	static ExtentTest extentTest = TestRule.getExtentTest();
	static String extentFolderPrint = TestRule.getFolderPrint();
	
	//print de tela em formato arquivo png gravado em pasta user.dir
	public static void logPrint(String strLog) {
		try {
			efetuarPrintTela(strLog);
			extentTest.log(Status.INFO, strLog, 
				MediaEntityBuilder
				.createScreenCaptureFromPath(
						System.getProperty("user.dir") + "\\src\\test\\resources\\" + extentFolderPrint + "\\" + strLog + ".png")
				.build()
				);
		} catch (IOException e) {
			System.out.println("Não foi possivel gravar print da tela no report HTML, verificar log de execução");
			e.printStackTrace();
		}
	}
	
	private static void efetuarPrintTela(String strLog) {
		File scrFile =  ((TakesScreenshot) TestRule.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile,
					new File(System.getProperty("user.dir") + "\\src\\test\\resources\\" + extentFolderPrint + "\\" + strLog + ".png"));
		} catch (IOException e) {
			System.out.println("Não foi possivel tirar print da tela, verificar log de execução");
			e.printStackTrace();
		}
	}
	
	//Print de tela em formato BASE64.
	public static void logPrintBase64(String strLog) {
		try {
			String base64=efetuarPrintTelaBase64();
			extentTest.log(Status.INFO, strLog, 
				MediaEntityBuilder
			    .createScreenCaptureFromBase64String(base64)						
				.build()
				);
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	private static String efetuarPrintTelaBase64() {
		String scrFileBase64 =  ((TakesScreenshot) TestRule.getDriver()).getScreenshotAs(OutputType.BASE64);
		return scrFileBase64;
	}
		
	//Wait para aguardar que elemento esteja visivel e clicavel.
	public static WebElement waitElementClicavel(WebElement escolherPlano) {
		WebDriverWait wait = new WebDriverWait(TestRule.getDriver(), 10);
		wait.until(ExpectedConditions.elementToBeClickable(escolherPlano));
		return escolherPlano;	
	}	
	
	//Wait para aguardar que elemento esteja visivel e clicavel tipo list.
	public static WebElement waitElementClicavelList(List<WebElement> element) {
		WebDriverWait wait = new WebDriverWait(TestRule.getDriver(), 10);
		wait.until(ExpectedConditions.elementToBeClickable((By) element));
		return (WebElement) element;	
	}

	//Log de execução realizada com sucesso.
	public static void logPass(String strMensagem) {
		extentTest.log(Status.PASS, strMensagem);	
	}

	//Log de execução realizada com falhas.
	public static void logFail(String strMensagem) {
		extentTest.log(Status.FAIL, strMensagem);	
	}
}
