package qa.planet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Демонстрационные тесты")
public class SimpleTest {
    @Test
    @Disabled ("Отключает тест при запуске тестов, если по какой-то причине его сейчас запускать не надо, но в будущем тест будет нужен. Можно добавить номер тикета в Jira")
    @DisplayName("Демонстрационный тест для проверки того, как работают аннотации и Assertions в junit")
    void simpleTest() {
        Assertions.assertEquals(3, 2+1, "2+1=3");
        Assertions.assertEquals(3, 1+2);
    }


}
