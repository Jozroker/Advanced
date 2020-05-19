package lesson1.lesson;

import java.util.Comparator;

public class TimeComparator implements Comparator<Time> {

    @Override
    public int compare(Time t1, Time t2) {
        return ((t1.getHour() * 60) + t1.getMin()) -
                ((t2.getHour() * 60) + t2.getMin());
    }
}
