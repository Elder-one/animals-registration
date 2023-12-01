import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public abstract class Animal implements Comparable<Animal>{
    public static ArrayList<Animal> animals;
    private static Integer count = 0;
    private Integer id;
    private String name;
    public enum gen{MALE, FEMALE}

    private gen gender;
    private GregorianCalendar birthDate;

    public Animal(String name, gen gender, String bDate) throws ParseException {
        this.name = name;
        this.gender = gender;
        this.id = count;
        count += 1;
        setBirthDate(bDate);
        animals.add(this);
    }

    public int getId() {
        return this.id;
    }
    public void setId(int value) { this.id = value; }

    public int getAgeInMonths() {
        Date b_date = this.birthDate.getTime();
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

    public void setBirthDate(String value) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(
                "yyyy-MM-dd");
        Date date = formatter.parse(value);
        GregorianCalendar calendar = (GregorianCalendar)GregorianCalendar.getInstance();
        calendar.setTime(date);
        this.birthDate = calendar;
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
        return formatter.format(this.birthDate.getTime());
    }

    @Override
    public String toString() {
        String gender = "FEMALE";
        if (this.gender == Animal.gen.MALE) {
            gender = "MALE";
        }
        String sb = String.format("%5d ", this.id) +
                String.format("%12s ", this.name) +
                String.format("%8s ", gender) +
                String.format("%13s", this.getBirthDate());
        return sb;
    }

    @Override
    public int compareTo(Animal other) {
        return this.id - other.id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Animal other = (Animal)obj;
        return this.id == other.id;
    }
}
