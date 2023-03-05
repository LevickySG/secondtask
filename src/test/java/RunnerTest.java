import com.codeborne.selenide.logevents.SelenideLogger;
import hooks.WebHooks;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"},
        features = "src/test/resources/features",
        glue = "Steps",
        tags = "@TEST"
)
public class RunnerTest extends WebHooks {
    @BeforeClass
    public static void before() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().
                screenshots(true).
                        savePageSource(false)
        );
    }
}
