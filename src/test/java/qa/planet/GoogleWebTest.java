package qa.planet;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@DisplayName("WEB - тесты для демонстрации возможностей JUnit")
public class GoogleWebTest extends TestsConfig {
    @BeforeEach
    void setup() {
        open("https://www.google.com/");
    }
    @CsvSource(value = {
            "selenide | https://ru.selenide.org",
            "JUnit | https://junit.org"
    },
    delimiter = '|')
    // OR
    //@CsvFileSource(resources = "/successfulSearchTest.csv")
    @ParameterizedTest(name = "Для поискового запроса '{0}' в выдаче присутствует url: {1}")
    @Tags({
            @Tag("BLOCKER"),
            @Tag("WEB"),
            @Tag("SMOKE")
    })
    void successfulSearchTests(String searchQuery, String expectedUrl) {
        $("[name=q]").setValue(searchQuery).pressEnter();
        $("[id=search]").shouldHave(text(expectedUrl));
    }

}
