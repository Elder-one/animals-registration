import java.text.ParseException;
import java.util.Collections;
import java.util.GregorianCalendar;

public class Donkey extends Draft{
    private Draft.species species;

    public Donkey(String name, Animal.gen gender, GregorianCalendar bDate) {
        super(name, gender, bDate);
        this.species = Draft.species.DONKEY;
        Animal.animals.add(this);
        Collections.sort(animals);
    }

    public Draft.species getSpecies() {
        return this.species;
    }

    @Override
    public String toString() {
        return String.format("%10s %s","Donkey",super.toString());
    }
}
