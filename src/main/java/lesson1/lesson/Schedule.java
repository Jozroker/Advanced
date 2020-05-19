package lesson1.lesson;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Schedule {

    private Set<Seance> seances = new TreeSet<>();

    public void addSeance(Seance seance) {
        seances.add(seance);
    }

    public void removeSeance(Seance seance) {
        seances.remove(seance);
    }

    public Set<Seance> getSeances() {
        return seances;
    }

    @Override
    public String toString() {
        return seances.stream().map(Seance::toString).collect(Collectors.joining("\n                             "));
    }
}
