package qa.planet;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestsConfig {
    @BeforeAll
    static void beforeAll() {
        //Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        //Configuration.browser = "chrome";
        //Configuration.holdBrowserOpen = true;
        Configuration.timeout = 10000;
        Configuration.pageLoadStrategy = "eager";
    }
}
