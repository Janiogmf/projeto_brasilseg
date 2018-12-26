package RunTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TestRule {
	private static WebDriver browser;
	private static ExtentHtmlReporter htmReporter;
	private static ExtentReports extentReport;
	private static ExtentTest extentTest;
	private static String extentFolderPrint;
	
	@Before
	public void beforeCenario(Scenario cenario) throws InterruptedException {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd HH.mm.ss").format(new Date());
		System.out.println("Horário "+timeStamp);
		if(extentReport == null) {
			extentReport = new ExtentReports();
			htmReporter  = new ExtentHtmlReporter("src/test/resources/"+cenario.getName()+" "+timeStamp+"/"+cenario.getId()+".html");
			htmReporter.loadXMLConfig("src/test/resources/config-extent-reports/extent-config.xml");
			extentReport.attachReporter(htmReporter);
		}
		extentFolderPrint = cenario.getName()+" "+timeStamp;		
		extentTest = extentReport.createTest(cenario.getId());
		
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
		browser = new ChromeDriver();
		browser.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		browser.manage().window().maximize();
		browser.get("localhost:3000");
	}
	@After
	public void afterCenario(Scenario cenario) {
		if(cenario.isFailed()) {
		Utils.logPrint("Print Tela Falha");
		extentTest.log(Status.FAIL, "Cenario "+ cenario.getName() +" executado com falhas!");
		extentReport.flush();
		}else {
				Utils.logPrint("Print Tela Sucesso");
				extentTest.log(Status.PASS, "Cenario "+ cenario.getName() +" executado com sucesso!");
				extentReport.flush();
				}
//	browser.close();	
	}
	
	public static WebDriver getDriver() {
		return browser;
	}
	
	public static ExtentTest getExtentTest() {
		return extentTest;
	}
	
	public static String getFolderPrint() {
		return extentFolderPrint;
	}
	
}
