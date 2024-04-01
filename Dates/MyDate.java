import java.util.GregorianCalendar;

public class MyDate {
    private int year;
    private int month;
    private int day;

    public static void main(String[] args) {
        MyDate date1 = new MyDate();
        MyDate date2 = new MyDate(34355555133101L);
        System.out.println("First Date: " + date1.getYear() + "-" + date1.getMonth() + "-" + date1.getDay());
        System.out.println("Second Date: " + date2.getYear() + "-" + date2.getMonth() + "-" + date2.getDay());
    }

    public MyDate() {
        this(System.currentTimeMillis());
    }

    public MyDate(long current) {
        GregorianCalendar greg = new GregorianCalendar();
        greg.setTimeInMillis(current);
        year = greg.get(GregorianCalendar.YEAR);
        month = greg.get(GregorianCalendar.MONTH);
        day = greg.get(GregorianCalendar.DAY_OF_MONTH);
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setDate(long elapsedTime) {
        GregorianCalendar greg = new GregorianCalendar();
        greg.setTimeInMillis(elapsedTime);
        year = greg.get(GregorianCalendar.YEAR);
        month = greg.get(GregorianCalendar.MONTH);
        day = greg.get(GregorianCalendar.DAY_OF_MONTH);
    }
}
