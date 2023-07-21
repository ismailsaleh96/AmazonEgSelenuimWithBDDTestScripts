package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import stepDefination.TestBase;


@CucumberOptions(
        features = "src\\main\\resources\\Features",
        glue = {"stepDefination"},
        plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        tags = "@regression"

)

public class TestRunner extends AbstractTestNGCucumberTests {
        @Parameters({"browserName"})
        @BeforeTest
        public void beforeTest(String browserName) throws InterruptedException {
                TestBase.setBrowser(browserName);
        }

}