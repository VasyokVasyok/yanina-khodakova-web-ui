import org.assertj.core.api.Assert;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestForTriangle {

    private static Logger logger = LoggerFactory.getLogger(TestForTriangle.class);
    Triangle tr;

    @BeforeEach
    void beforeEach() {
        logger.info("Тест начал выполняться");
    }

    @AfterEach
    void afterEach() {
        logger.info("Тест закончил выполнение");
    }

    /**
     * Проверка создания треугольника при некорректных данных
     */
    @DisplayName("Треугольник будет создан при некорректных значениях сторон?")
    @Test
    public void canBeTriangleBadDataTest() {
        tr = new Triangle(-2, 3, 4);
        Assertions.assertEquals(null, tr.d);
    }

    /**
     * Проверка создания треугольника при корректных данных
     */
    @DisplayName("Треугольник будет создан при корректных значениях сторон?")
    @Test
    public void canBeTriangleGoodDataTest() {
        tr = new Triangle(2, 3, 4);
        Assertions.assertTrue(tr.d > 0);
    }

    /**
     * Проверка отработки метода вычисления площади треугольника
     */
    @DisplayName("Работает ли функция расчета площади треугольника?")
    @Test
    public void workOfCalcSquareTest() {
        tr = new Triangle(2,3,4);
        Assertions.assertNotNull(tr.d);
        Assertions.assertEquals(String.format("%.6f", tr.d).replace(",", "."), "2.904738");
    }
}
