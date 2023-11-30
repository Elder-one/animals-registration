import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public abstract class Animal {
    private String name;
    public enum gen{MALE, FEMALE};
    private gen gender;
    private GregorianCalendar birth_date;

    public Animal(String name, gen gender, String b_date) throws ParseException {
        this.name = name;
        this.gender = gender;
        setBirth_date(b_date);
    }

    public int getAgeInMonths() {
        Date b_date = this.birth_date.getTime();
        Date cur_date = new Date();
        long diff_millies = cur_date.getTime() - b_date.getTime();
        TimeUnit timeUnit = TimeUnit.DAYS;
        return (int)timeUnit.convert(diff_millies, TimeUnit.MILLISECONDS) / 30;
    }

    public void setName(String value) {
        this.name = value;
    }

    public void setGender(gen value) {
        this.gender = value;
    }

    public void setBirth_date(String value) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(
                "yyyy-MM-dd");
        Date date = formatter.parse(value);
        GregorianCalendar calendar = (GregorianCalendar)GregorianCalendar.getInstance();
        calendar.setTime(date);
        this.birth_date = calendar;
    }

    public String getName() {
        return this.name;
    }

    public gen getGender() {
        return this.gender;
    }

    public String getBirthDate() {
        SimpleDateFormat formatter = new SimpleDateFormat(
                "yyyy-MM-dd");
        return formatter.format(this.birth_date.getTime());
    }
}
