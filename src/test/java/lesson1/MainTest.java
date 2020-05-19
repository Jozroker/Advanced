package lesson1;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

class MainTest {

    private Main adder = new Main();

    @BeforeAll
    static void init(){
        System.out.println("Before all");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Before each");
    }

    @AfterEach
    void tearDown() {
        System.out.println("After each");
    }

    @RepeatedTest(2)
    void add() {
        int expected = 5;
        int actual = adder.add(2,3);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    void addTwoTens() {
        int actual = adder.add(10,10);
        int expected = 20;
        Assertions.assertEquals(actual, expected);
    }

    @ParameterizedTest
    @CsvSource({"1, 0, 1",
                "2, 3, 5",
                "8, 7, 15"})
//                "2000000000, 2000000000, 4000000000"})
    void add(int a, int b, long expected) {
        long actual = adder.add(a, b);
        Assertions.assertEquals(actual, expected);
    }

    @ParameterizedTest
    @EnumSource(value = Some.class, names = {"ONE", "TWO"})
    public void testEnum(Some some) {
        System.out.println(some);
    }

    enum Some {
        ONE, TWO, THREE
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After all");
    }
}