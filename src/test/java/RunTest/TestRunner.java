package RunTest;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

	@RunWith(Cucumber.class)
//	@CucumberOptions(features = "src/test/java/Cadastro_Cotacao.feature",
	@CucumberOptions(features = "src/test/java/",
		glue = { "" }, monochrome = true, dryRun = false)
	
public class TestRunner {

}
