import java.text.ParseException;
import java.util.Collections;
import java.util.GregorianCalendar;

public class Horse extends Draft{
    private Draft.species species;

    public Horse(String name, Animal.gen gender, GregorianCalendar bDate) {
        super(name, gender, bDate);
        this.species = Draft.species.HORSE;
        Animal.animals.add(this);
        Collections.sort(animals);
    }

    public Draft.species getSpecies() {
        return this.species;
    }

    @Override
    public String toString() {
        return String.format("%10s %s","Horse",super.toString());
    }
}
