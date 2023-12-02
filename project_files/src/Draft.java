import java.text.ParseException;

public abstract class Draft extends Animal{
    public enum species{HORSE, CAMEL, DONKEY}

    public Draft(String name, Animal.gen gender, String bDate) throws ParseException {
        super(name, gender, bDate);
    }
}
