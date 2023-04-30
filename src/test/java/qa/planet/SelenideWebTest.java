package qa.planet;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import qa.planet.domain.Locale;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SelenideWebTest {
    @BeforeEach
    void setup() {
        open("https://selenide.org");
    }
    static Stream<Arguments> selenideLocaleTest() {
        return Stream.of(
                Arguments.of(Locale.EN, List.of("Quick start", "Docs", "FAQ", "Blog", "Javadoc", "Users", "Quotes")),
                Arguments.of(Locale.RU, List.of("С чего начать?", "Док", "ЧАВО", "Блог", "Javadoc", "Пользователи", "Отзывы"))
        );
    }

    @MethodSource
    @ParameterizedTest
    void selenideLocaleTest(Locale siteLocale, List<String> expectedButtons) {
        $$("#languages a").find(text(siteLocale.name())).click();

        $$(".main-menu-pages a").filter(visible)
                .shouldHave(CollectionCondition.texts((expectedButtons)));
    }
}
