package lesson1.lesson;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
//        DecimalFormat twoNumbers = new DecimalFormat("00");
        Cinema cinema = new Cinema(new Time(9, 0), new Time(0, 0));
        System.out.println("1 - Add new movie to library");
        System.out.println("2 - Add new seance");
        System.out.println("3 - Remove movie from cinema");
        System.out.println("4 - Remove seance");
        System.out.println("5 - Show all seances");
        System.out.println("6 - Show cinema library");
        System.out.println("0 - Exit");
        boolean value = true;
        while (value) {
            System.out.print("Enter operation number: ");
            int operation = sc.nextInt();
            sc.nextLine();
            try {
                switch (operation) {
                    case 1:
                        System.out.print("Enter movie name: ");
                        String name = sc.nextLine();
                        System.out.println("Enter movie duration: ");
                        System.out.print("Hours: ");
                        int hour = sc.nextInt();
                        System.out.print("Minutes: ");
                        int minute = sc.nextInt();
                        if ((minute < 0 || minute >= 60) || (hour < 0 || hour >= 24)) {
                            System.out.println("Incorrect time value");
                        } else {
                            cinema.addMovie(new Movie(name, new Time(hour, minute)));
                        }
                        break;
                    case 2:
                        System.out.print("Enter movie name: ");
                        String movieName = sc.nextLine();
                        if (cinema.getMoviesLibrary().stream().noneMatch(movie -> movie.getTitle().equals(movieName))) {
                            System.out.println("Library hasn't such movie");
                            break;
                        }
                        Movie currentMovie = cinema.getMoviesLibrary().stream()
                                .filter(movie -> movie.getTitle().equals(movieName))
                                .findFirst().get();
                        System.out.println("Enter start time: ");
                        int startHour = 0;
                        int startMinute = 0;
                        boolean validTime = false;
                        while (!validTime) {
                            System.out.print("Hours: ");
                            startHour = sc.nextInt();
                            System.out.print("Minutes: ");
                            startMinute = sc.nextInt();
                            if ((startHour < 0 || startHour >= 60) || (startMinute < 0 || startMinute >= 24)) {
                                System.out.println("Incorrect time value. Try again");
                            } else {
                                validTime = true;
                            }
                            sc.nextLine();
                        }
                        System.out.print("Day: ");
                        String day = sc.next();
                        while (true) {
                            boolean limiter = false;
                            for (Days days : Days.values()) {
                                if (days.toString().equals(day.toUpperCase())) {
                                    limiter = true;
                                }
                            }
                            if (limiter) {
                                break;
                            } else {
                                System.out.println("Undefined day. Try again");
                                day = sc.next();
                            }
                        }
                        cinema.addSeance(new Seance(currentMovie, new Time(startHour, startMinute)), day);
                        break;
                    case 3:
                        System.out.print("Enter movie name: ");
                        String movieName2 = sc.nextLine();
                        if (cinema.getMoviesLibrary().stream().noneMatch(movie -> movie.getTitle().equals(movieName2))) {
                            System.out.println("Library hasn't such movie");
                            break;
                        }
                        Movie currentMovie2 = cinema.getMoviesLibrary().stream()
                                .filter(movie -> movie.getTitle().equals(movieName2))
                                .findFirst().get();
                        cinema.removeMovie(currentMovie2);
                        break;
                    case 4:
                        System.out.print("Enter movie name: ");
                        String movieName3 = sc.nextLine();
                        if (cinema.getMoviesLibrary().stream().noneMatch(movie -> movie.getTitle().equals(movieName3))) {
                            System.out.println("Library hasn't such movie");
                            break;
                        }
                        Movie currentMovie3 = cinema.getMoviesLibrary().stream()
                                .filter(movie -> movie.getTitle().equals(movieName3))
                                .findFirst().get();
                        System.out.println("Enter start time: ");
                        System.out.print("Hours: ");
                        int startHour3 = sc.nextInt();
                        System.out.print("Minutes: ");
                        int startMinute3 = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Day: ");
                        String day3 = sc.next();
                        while (true) {
                            boolean limiter = false;
                            for (Days days : Days.values()) {
                                if (days.toString().equals(day3.toUpperCase())) {
                                    limiter = true;
                                }
                            }
                            if (limiter) {
                                break;
                            } else {
                                System.out.println("Undefined day. Try again");
                                day3 = sc.next();
                            }
                        }
                        cinema.removeSeance(new Seance(currentMovie3, new Time(startHour3, startMinute3)), day3);
                        break;
                    case 5:
                        System.out.println(cinema.toString());
                        break;
                    case 6:
                        System.out.println(cinema.showCinemaLibrary());
                        break;
                    case 0:
                        value = false;
                        break;
                    default:
                        System.out.println("Undefined operation");
                }
            } catch (Exception e) {
                System.out.println("Incorrect input...");
                sc.nextLine();
            }
            System.out.println("=============================");
        }
    }
}
