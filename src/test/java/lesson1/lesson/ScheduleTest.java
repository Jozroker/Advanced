package lesson1.lesson;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleTest {

    @BeforeAll
    static void before() {
        System.out.println("Starting schedule class test");
    }

    Movie movie = new Movie("title", new Time(2, 0));
    Seance seance = new Seance(movie, new Time(10, 0));
    Schedule schedule = new Schedule();

    @Test
    void addSeance() {
        boolean actual = schedule.getSeances().isEmpty();
        assertTrue(actual);
        schedule.addSeance(seance);
        assertFalse(schedule.getSeances().isEmpty());
        assertTrue(schedule.getSeances().contains(seance));
        System.out.println("schedule add seance test is successful");
    }

    @Test
    void removeSeance() {
        schedule.removeSeance(seance);
        assertFalse(schedule.getSeances().contains(seance));
        System.out.println("schedule delete seance test is successful");
    }

    @AfterAll
    static void after() {
        System.out.println("ending schedule class test");
    }
}