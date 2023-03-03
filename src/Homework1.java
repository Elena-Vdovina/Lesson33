import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Homework1 {
  // Расширьте программу Task2MonthsEnums. Добавьте ещё один enum, который будет описывать
// времена года (зима, лето, весна, осень) и укажет, к какому именно времени года относится
// выбранный месяц.
  enum Month {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER,
  }

  enum TimeOfYear {
    WINTER,
    SPRING,
    SUMMER,
    AUTUMN,
  }

  public static Map<Month, Integer> buildMonthsMap() {
    Map<Month, Integer> months = new HashMap<>();

    months.put(Month.JANUARY, 31);
    months.put(Month.FEBRUARY, 28);
    months.put(Month.MARCH, 31);
    months.put(Month.APRIL, 30);
    months.put(Month.MAY, 31);
    months.put(Month.JUNE, 30);
    months.put(Month.JULY, 31);
    months.put(Month.AUGUST, 31);
    months.put(Month.SEPTEMBER, 30);
    months.put(Month.OCTOBER, 31);
    months.put(Month.NOVEMBER, 30);
    months.put(Month.DECEMBER, 31);

    return months; // возвращаем готовый словарь с месяцами и днями
  }

  public static Map<Month, TimeOfYear> bildTimeMap() {
    Map<Month, TimeOfYear> times = new HashMap<>();

    times.put(Month.JANUARY, TimeOfYear.WINTER);
    times.put(Month.FEBRUARY, TimeOfYear.WINTER);
    times.put(Month.MARCH, TimeOfYear.SPRING);
    times.put(Month.APRIL, TimeOfYear.SPRING);
    times.put(Month.MAY, TimeOfYear.SPRING);
    times.put(Month.JUNE, TimeOfYear.SUMMER);
    times.put(Month.JULY, TimeOfYear.SUMMER);
    times.put(Month.AUGUST, TimeOfYear.SUMMER);
    times.put(Month.SEPTEMBER, TimeOfYear.AUTUMN);
    times.put(Month.OCTOBER, TimeOfYear.AUTUMN);
    times.put(Month.NOVEMBER, TimeOfYear.AUTUMN);
    times.put(Month.DECEMBER, TimeOfYear.WINTER);

    return times;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Enter the month: ");
    String month = inputReader.readLine();
    Month monthToLook = Month.valueOf(month.toUpperCase());
    Map<Month, Integer> monthDays = buildMonthsMap();
    Map<Month, TimeOfYear> timeMonth = bildTimeMap();

    if (monthDays.containsKey(monthToLook)) {
      System.out.printf("The month '%s' contains %d days%n", month, monthDays.get(monthToLook));
      System.out.printf("The month '%s' has ordinal number %d%n", month, monthToLook.ordinal() + 1);
      System.out.printf("The month '%s' is '%s'%n", month, timeMonth.get(monthToLook));

      int nextMonthIndex = (monthToLook.ordinal() + 1);
      Month nextMonth = Month.values()[nextMonthIndex % Month.values().length];
      System.out.printf("The next month is '%s' contains %d days%n", nextMonth, monthDays.get(nextMonth));
      System.out.printf("The month '%s' is '%s'%n", nextMonth, timeMonth.get(nextMonth));
    } else {
      System.out.println("No such month: " + month);
    }
  }
}

