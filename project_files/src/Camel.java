import java.text.ParseException;
import java.util.Collections;
import java.util.GregorianCalendar;

public class Camel extends Draft{
    private Draft.species species;

    public Camel(String name, Animal.gen gender, GregorianCalendar bDate) {
        super(name, gender, bDate);
        this.species = Draft.species.CAMEL;
        Animal.animals.add(this);
        Collections.sort(animals);
    }

    public Draft.species getSpecies() {
        return this.species;
    }

    @Override
    public String toString() {
        return String.format("%5d %10s %s",
                this.getId(),
                "Camel",
                super.toString());
    }
}
