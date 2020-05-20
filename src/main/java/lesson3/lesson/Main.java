package lesson3.lesson;

import org.apache.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Logger log = Logger.getLogger(Main.class);
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        log.info("Starting application");
        log.debug("Input number values");
        try {
            System.out.print("Enter first number: ");
            int firstNumber = sc.nextInt();
            System.out.print("Enter second number: ");
            int secondNumber = sc.nextInt();
            if (firstNumber + secondNumber > 10) {
                log.error("Sum more 10");
            } else {
                System.out.println("Result: " + (firstNumber + secondNumber));
            }
        } catch (InputMismatchException e) {
            log.error("Input Mismatch Exception");
        }
        log.info("Ending application");
    }
}
