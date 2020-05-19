package lesson1.lesson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Cinema {

    private Map<Days, Schedule> schedules = new TreeMap<>();
    private List<Movie> moviesLibrary = new ArrayList<>();
    private Time open;
    private Time close;

    public Cinema(Time open, Time close) {
        this.open = open;
        this.close = close;
    }

    public void addMovie(Movie movie) {
        if (moviesLibrary.contains(movie)) {
            System.out.println("Library already exist such movie");
        } else {
            moviesLibrary.add(movie);
        }
    }

    public void addSeance(Seance currentSeance, String day) {
        if (!schedules.containsKey(Days.valueOf(day.toUpperCase()))) {
            schedules.put(Days.valueOf(day.toUpperCase()), new Schedule());
        }
        schedules.forEach((key, value) -> {
            if (key.toString().equals(day.toUpperCase())) {
                TimeComparator tc = new TimeComparator();
                if (value.getSeances().stream().noneMatch(seance ->
                        (((tc.compare(currentSeance.getStartTime(), seance.getStartTime()) >= 0) &&
                                (tc.compare(currentSeance.getStartTime(), seance.getEndTime()) <= 0)) ||
                                ((tc.compare(currentSeance.getEndTime(), seance.getStartTime()) >= 0) &&
                                        (tc.compare(currentSeance.getEndTime(), seance.getEndTime()) <= 0))))) {
                    if (tc.compare(currentSeance.getStartTime(), open) < 0 &&
                            tc.compare(currentSeance.getEndTime(), close) > 0) {
                        System.out.println("Cinema will be closed");
                    } else {
                        value.addSeance(currentSeance);
                    }
                } else {
                    System.out.println("Such time in this schedule is occupied");
                }
            }
        });
    }

    public void removeMovie(Movie movie) {
        moviesLibrary.remove(movie);
        schedules.values().forEach(schedule -> schedule.getSeances().removeIf(seance -> seance.getMovie().equals(movie)));
    }

    public void removeSeance(Seance seance, String day) {
        schedules.forEach((key, value) -> {
            if (key.toString().equals(day.toUpperCase())) {
                value.removeSeance(seance);
            }
        });
    }

    public String showCinemaLibrary() {
        return "Movies:\n" +
                moviesLibrary.stream()
                        .map(elem -> "    " + elem.toString())
                        .collect(Collectors.joining("\n"));
    }

    @Override
    public String toString() {
        if (schedules.isEmpty()) {
            return "Cinema hasn't active seances";
        } else {
            return "Cinema{\n" +
                    "   Schedules:\n" + schedules
                    .entrySet()
                    .stream()
                    .map(elem -> {
                        return "        " + elem.getKey().toString() + "-> Schedule: " + elem.getValue().toString();
                    })
                    .collect(Collectors.joining("\n")) +
                    ",\nopen=" + open.toString() +
                    ",\nclose=" + close.toString() +
                    "\n}";
        }
    }

    public List<Movie> getMoviesLibrary() {
        return moviesLibrary;
    }

    public Map<Days, Schedule> getSchedules() {
        return schedules;
    }
}
