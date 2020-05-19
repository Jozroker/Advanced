package lesson1.lesson;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeTest {

    int hour = 10;
    int minute = 10;
    Time time1 = new Time(hour, minute);
    Time time2 = new Time(10, 10);

    @BeforeAll
    static void before() {
        System.out.println("Starting time class test");
    }

    @Test
    void getMin() {
        int expected = minute;
        int actual = time1.getMin();
        Assertions.assertEquals(expected, actual);
        System.out.println("minute test is successful");
    }

    @Test
    void getHour() {
        int expected = hour;
        int actual = time1.getHour();
        Assertions.assertEquals(expected, actual);
        System.out.println("hour test is successful");
    }

    @Test
    void testEquals() {
        Assertions.assertEquals(time1, time2);
        System.out.println("equals test is successful");
    }

    @AfterAll
    static void after() {
        System.out.println("ending time class test");
    }
}