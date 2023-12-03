import java.text.ParseException;
import java.util.Collections;
import java.util.GregorianCalendar;

public class Cat extends Pet{
    private Pet.species species;

    public Cat(String name, Animal.gen gender, GregorianCalendar bDate) {
        super(name, gender, bDate);
        this.species = Pet.species.CAT;
        Animal.animals.add(this);
        Collections.sort(animals);
    }

    public Pet.species getSpecies() {
        return this.species;
    }

    @Override
    public String toString() {
        return String.format("%10s %s","Cat",super.toString());
    }
}
