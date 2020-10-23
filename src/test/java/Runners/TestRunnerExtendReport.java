/**
 * @Author:Otosun Tarih :19/10/2020
 */
package Runners;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

import org.testng.annotations.AfterClass;

@CucumberOptions(
        tags = {"@Regression"},
        features = {"src/test/java/FeaturesFiles"},
        glue = {"StepDefinitions"},
        dryRun = false,
        plugin = {   "com.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport/ExtentReportRegression.html"
                // to generate a extend report we need this plugin
        }
)
public class TestRunnerExtendReport extends AbstractTestNGCucumberTests {
        @AfterClass
        public static void afterClass(){
                Reporter.loadXMLConfig("src/test/java/XMLFiles/ReportSetting.xml");
                Reporter.setSystemInfo("User Name", "Grup+2");
                Reporter.setSystemInfo("Aplication Name", "Basqar");
                Reporter.setSystemInfo("Operation System Info", System.getProperty("os.name"));
                Reporter.setSystemInfo("Department", "QA");
                Reporter.setTestRunnerOutput("Test execution Cucumber report");

        }
}
