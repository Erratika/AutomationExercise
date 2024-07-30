import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        // Change to match the location of your feature files
        features = {"src/test/resources"},
        // change to match the location of the package containing your step def files
        glue = {"dev.erratika.AutomationExercise.stepdefinitions"},
        plugin = {"pretty", "html:target/testReport.html", "json:target/jsonReport.json"},
        publish = true
)
public class TestRunner {
}
