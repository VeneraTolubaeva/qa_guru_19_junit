package qa.planet;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LemurrrParamTest {

    @BeforeEach
    void setUp(){
        Configuration.pageLoadStrategy = "eager";
    }

    @CsvSource(value = {
            "Акции, Товары для животных",
            "Магазины, Магазины в г. Санкт-Петербург",
            "Бренды, Бренды",
            "Статьи, Статьи о животных",
            "Помоги приюту, Купить Prime - помочь приюту",
            "Ветаптека, Ветеринарная аптека"
    })
    @ParameterizedTest(name = "Тестирование раздела {0}")
    void lemurrrHeadersBtnTest(String btnHeader, String result) {
        open("https://lemurrr.ru/");
        //$(".city-confirmation__modal").$(byText("Да, спасибо")).click();
        $$x("//ul//li//a").find(Condition.text(btnHeader)).click();
        $("h1").shouldHave(Condition.text(result));
    }

    static Stream<Arguments> loyaltyTest(){
        return Stream.of(
        Arguments.of(List.of("Условия бонусной программы ЛемуриЯ", "Условия реферальной программы",
                "Регистрация бонусной карты","Проверка бонусного счёта", "Адреса магазинов", "О компании", "Контакты",
                "Вакансии", "Франшиза", "Акции", "Новости", "Бренды", "Партнерам", "Оферта", "Программа лояльности",
                "Условия покупки", "Доставка товара"))
        );
    }
    @MethodSource
    @ParameterizedTest(name = "Тестирование программы лояльности ")
    void loyaltyTest(List<String> result) {
        open("https://lemurrr.ru/loyalty");
        $$x("//ul[@class='menu__list']/li").filter(visible).shouldHave(CollectionCondition.texts(result));
    }
    @ValueSource(strings = {
            "ADA",
            "Advocat",
            "AiryVest",
            "Alcott",
            "Alleva",
            "AlphaPet"
    }
    )
    @ParameterizedTest(name = "тестирование кнопки {0} на странице бренды")
    void brandWallTest(String brandBtn) {

        open("https://lemurrr.ru/brandwall");

        $$x("//li[@class='brands__entry'][3]/div[@class='entry__brands']//ul//li[@class='column__entry']/a").findBy(Condition.text(brandBtn)).click();
        $("h1").shouldHave(Condition.text(brandBtn));

    }
}