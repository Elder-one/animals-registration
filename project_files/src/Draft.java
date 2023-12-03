import java.text.ParseException;
import java.util.GregorianCalendar;

public abstract class Draft extends Animal{
    public enum species{HORSE, CAMEL, DONKEY}

    public Draft(String name, Animal.gen gender, GregorianCalendar bDate) {
        super(name, gender, bDate);
    }
}
