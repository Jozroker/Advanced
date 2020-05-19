package lesson1.lesson;

import jdk.nashorn.internal.AssertsEnabled;
import org.junit.jupiter.api.*;

import java.time.LocalTime;

class MovieTest {

    @BeforeAll
    static void before() {
        System.out.println("Starting movie class test");
    }
    String title = "title";
    Time duration = new Time(10,10);
    Movie movie1 = new Movie(title, duration);

    @Test
    void getTitle() {
        String expected = "title";
        String actual = movie1.getTitle();
        Assertions.assertEquals(expected, actual);
        System.out.println("title test is successful");
    }

    @Test
    void getDuration() {
        Time expected = new Time(10, 10);
        Time actual = movie1.getDuration();
        Assertions.assertEquals(expected, actual);
        System.out.println("duration test is successful");
    }

    Movie movie2 = new Movie(title, duration);

    @Test
    void testEquals() {
        Assertions.assertEquals(movie1, movie2);
        System.out.println("equals test is successful");
    }

    @AfterAll
    static void after() {
        System.out.println("ending movie class test");
    }
}