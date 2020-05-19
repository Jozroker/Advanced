package lesson1.lesson;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

class CinemaTest {

    @BeforeAll
    static void before() {
        System.out.println("Starting cinema class test");
    }

    Cinema cinema = new Cinema(new Time(9,9), new Time(20,20));
    Movie movie = new Movie("title", new Time(2, 0));
    Seance seance = new Seance(movie, new Time(10, 0));
    Schedule schedule = new Schedule();

    @Test
    void addMovie() {
        assertFalse(cinema.getMoviesLibrary().contains(movie));
        cinema.addMovie(movie);
        assertTrue(cinema.getMoviesLibrary().contains(movie));
        System.out.println("cinema add movie test is successful");
    }

    @Test
    void addSeance() {
        assertTrue(cinema.getSchedules().isEmpty());
        cinema.addSeance(seance, "monday");
        final boolean[] exist = {false};
        cinema.getSchedules().values().forEach(e -> {
            if (e.getSeances().contains(seance)) {
                exist[0] = true;
            }
        });
        assertTrue(exist[0]);
        System.out.println("cinema add seance test is successful");
    }

    @Test
    void removeMovie() {
        cinema.removeMovie(movie);
        assertFalse(cinema.getMoviesLibrary().contains(movie));
        System.out.println("cinema remove movie test is successful");
    }

    @Test
    void removeSeance() {
        cinema.addSeance(seance, "monday");
        cinema.removeSeance(seance, "friday");
        final boolean[] exist = {false};
        cinema.getSchedules().values().forEach(e -> {
            if (e.getSeances().contains(seance)) {
                exist[0] = true;
            }
        });
        assertTrue(exist[0]);
        cinema.removeSeance(seance, "monday");
        final boolean[] exist2 = {false};
        cinema.getSchedules().values().forEach(e -> {
            if (e.getSeances().contains(seance)) {
                exist2[0] = true;
            }
        });
        assertFalse(exist2[0]);
        System.out.println("cinema remove movie test is successful");
    }

    @AfterAll
    static void after() {
        System.out.println("ending cinema class test");
    }
}