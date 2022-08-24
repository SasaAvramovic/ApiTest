package api.runners;

//this is what I currently use on the project, but I also used TestNG
//in retrospect, TestNG might have actually been a better option here...

import api.data_containers.GeneralData;
import api.helpers.GetActualData;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"api/steps"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        tags = "@runAll"
)

public class CucumberRunner {
    static GeneralData generalData;

    @BeforeClass
    public static void beforeTests() {
        generalData.requestUri = "http://localhost:3000/houses";
        generalData.allResponseData = GetActualData.getAllData();
    }
}
