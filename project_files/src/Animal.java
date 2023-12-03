import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public abstract class Animal implements Comparable<Animal>{
    public static ArrayList<Animal> animals = new ArrayList<Animal>();
    private static Integer count = 0;
    private Integer id;
    private String name;
    public enum gen{MALE, FEMALE}

    private gen gender;
    private GregorianCalendar birthDate;

    public Animal(String name, gen gender, GregorianCalendar bDate) {
        this.name = name;
        this.gender = gender;
        this.id = count;
        count += 1;
        this.birthDate = bDate;
    }

    public static Animal getAnimal(int id) {
        int start = 0;
        int stop = animals.size() - 1;
        if (start > stop) {
            return null;
        }
        while(stop > start) {
            int center = (start + stop) / 2;
            if (animals.get(center).id < id) {
                start = center+1;
            } else if (animals.get(center).id > id) {
                stop = center-1;
            } else return animals.get(center);
        }
        if (animals.get(start).id != id) {
            return null;
        }
        else {
            return animals.get(start);
        }
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

    public String getBirthDateString() {
        SimpleDateFormat formatter = new SimpleDateFormat(
                "yyyy-MM-dd");
        Date date = this.birthDate.getTime();
        return formatter.format(date);
    }

    public void setName(String value) {
        this.name = value;
    }

    public void setGender(gen value) {
        this.gender = value;
    }

    public String getName() {
        return this.name;
    }

    public gen getGender() {
        return this.gender;
    }

    public GregorianCalendar getBirthDate() {
        return this.birthDate;
    }

    @Override
    public String toString() {
        String gender = "FEMALE";
        if (this.gender == Animal.gen.MALE) {
            gender = "MALE";
        }
        String sb = String.format("%12s ", this.name) +
                String.format("%8s ", gender) +
                String.format("%13s", this.getBirthDateString());
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
