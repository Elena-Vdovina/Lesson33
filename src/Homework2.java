import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Homework2 {
  // Совместите программы Task1Months и Task2MonthsEnums, чтобы число дней в месяце читалось
// из файла res/months.csv, но сохранялось Map<Month, Integer>.
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

  public static Map<Month, Integer> buildMonthsMap(File inputFile) throws IOException {
    BufferedReader inputFileReader = new BufferedReader(new FileReader(inputFile));
    Map<Month, Integer> months = new HashMap<>();

    Month[] month_ = Month.values();
    for (Month month : month_) {
      int days = Integer.parseInt(inputFileReader.readLine());
      months.put(month, days);
    }
    inputFileReader.close();
    return months;
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
    try {
      Map<Month, Integer> monthDays = buildMonthsMap(new File("res/months.csv"));

      Map<Month, TimeOfYear> timeMonth = bildTimeMap();

      if (monthDays.containsKey(monthToLook)) {
        System.out.printf("The month '%s' contains %d days%n", month, monthDays.get(monthToLook));
        System.out.printf("The month '%s' has ordinal number %d%n", month, monthToLook.ordinal() + 1);
        System.out.printf("The month '%s' ist '%s'%n", month, timeMonth.get(monthToLook));

        int nextMonthIndex = (monthToLook.ordinal() + 1);
        Month nextMonth = Month.values()[nextMonthIndex % Month.values().length];
        System.out.printf("The next month is '%s' contains %d days%n", nextMonth, monthDays.get(nextMonth));
        System.out.printf("The month '%s' is '%s'%n", nextMonth, timeMonth.get(nextMonth));
      } else {
        System.out.println("No such month: " + month);
      }
    } catch (FileNotFoundException e) {
      System.err.println("File not found: " + e.getMessage());
    }
  }
}

