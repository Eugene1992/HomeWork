package zadanie_02;

import java.time.LocalDate;

/**
 * Created by Sviatoslav on 15.03.2017.
 */
public class DateValidation {
    public static void main(String[] args) {
        System.out.println(validDate(15, 8, 2019));
        System.out.println(validDate(25, 7, 2156));
    }
    public static boolean validDate(int day, int month, int years){
        boolean check = true;
        LocalDate date = LocalDate.of(years, month, day);
        if (date.getYear() < 2001 || date.getYear() > 2099){
            check = false;
        }
        return check;
    }
}
