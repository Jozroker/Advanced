package lesson1.lesson;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeanceTest {

    @BeforeAll
    static void before() {
        System.out.println("Starting seance class test");
    }

    Time start = new Time(10,10);
    Time duration = new Time (5, 5);
    Movie movie = new Movie("title1", duration);
    Seance seance1 = new Seance(movie, start);
    Seance seance2 = new Seance(movie, new Time(10, 10));

    @Test
    void testEquals() {
        Assertions.assertEquals(seance1, seance2);
        System.out.println("equals test is successful");
    }

    @Test
    void getMovieOneSeance() {
        Movie expected = seance1.getMovie();
        Movie actual = movie;
        Assertions.assertEquals(expected, actual);
        System.out.println("equals movie one seance test is successful");
    }

    @Test
    void getMovieTwoSeance() {
        Movie expected = seance1.getMovie();
        Movie actual = seance2.getMovie();
        Assertions.assertEquals(expected, actual);
        System.out.println("equals movie two seance test is successful");
    }

    @Test
    void getStartTime() {
        Time expected = new Time(10, 10);
        Time actual1 = seance1.getStartTime();
        Time actual2 = seance2.getStartTime();
        Assertions.assertEquals(expected, actual1);
        Assertions.assertEquals(expected, actual2);
        System.out.println("equals start time test is successful");
    }

    @Test
    void getEndTime() {
        int startHour = start.getHour();
        int startMinute = start.getMin();
        int durationHour = duration.getHour();
        int durationMinute = duration.getMin();
        int endHour = 0;
        int endMinute = 0;
        if (startHour + durationHour >= 60) {
            endHour = startHour + durationHour - 60 * (startHour + durationHour) % 60;
        } else {
            endHour = startHour + durationHour;
        }
        if (startMinute + durationMinute >= 60) {
            endMinute = startMinute + durationMinute - 60 * (startMinute + durationMinute) % 60;
        } else {
            endMinute = startMinute + durationMinute;
        }
        Time expected = new Time(endHour, endMinute);
        Time actual = seance1.getEndTime();
        Assertions.assertEquals(expected, actual);
        System.out.println("equals end time test is successful");
    }

    @AfterAll
    static void after() {
        System.out.println("ending seance class test");
    }
}