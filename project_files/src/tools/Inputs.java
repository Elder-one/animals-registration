package tools;

import species.Animal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Inputs {

    public static int getIntResponse(String message) {
        Integer result = null;
        while (true) {
            System.out.print(message);
            Scanner s = new Scanner(System.in);
            try {
                result = s.nextInt();
                return result;
            }
            catch (InputMismatchException e) {
                continue;
            }
        }
    }

    public static String getStringResponse(String msg) {
        System.out.print(msg);
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }

    public static Animal.gen inputGender() {
        int gender = 0;
        Animal.gen result = null;
        while (true) {
            System.out.println(System.lineSeparator().repeat(50));
            System.out.println("Choose gender:");
            System.out.println(" 1: MALE");
            System.out.println(" 2: FEMALE");
            System.out.println("-1: Cancel");
            gender = getIntResponse("Your option --> ");
            switch (gender) {
                case 1:
                    result = Animal.gen.MALE;
                    return result;
                case 2:
                    result = Animal.gen.FEMALE;
                    return result;
                case -1:
                    return null;
                default:
                    break;
            }
        }
    }

    public static String inputName() {
        String result = null;
        while (true) {
            System.out.println(System.lineSeparator().repeat(50));
            result = getStringResponse("Enter animal's name\n" +
                    "or -1 to cancel--> ");
            switch (result) {
                case "-1":
                    return null;
                case "":
                    continue;
                default:
                    return result;
            }
        }
    }

    public static GregorianCalendar inputBirthDate() {
        SimpleDateFormat formatter = new SimpleDateFormat(
                "yyyy-MM-dd");
        while(true) {
            System.out.println(System.lineSeparator().repeat(50));
            String bDate = getStringResponse("Enter animal's birth date\n" +
                    "Format: YYYY-MM-DD\n" +
                    "or -1 to cancel--> ");
            if (bDate.equals("-1")) {
                return null;
            }
            Date date = new Date();
            try {
                date = formatter.parse(bDate);
            }
            catch (ParseException e) {
                continue;
            }
            GregorianCalendar calendar = (GregorianCalendar) GregorianCalendar.getInstance();
            calendar.setTime(date);
            return calendar;
        }
    }
}
