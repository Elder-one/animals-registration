import java.text.ParseException;
import java.util.Collections;
import java.util.GregorianCalendar;

public class Dog extends Pet{
    private Pet.species species;

    public Dog(String name, Animal.gen gender, GregorianCalendar bDate) {
        super(name, gender, bDate);
        this.species = Pet.species.DOG;
        Animal.animals.add(this);
        Collections.sort(animals);
    }

    public Pet.species getSpecies() {
        return this.species;
    }

    @Override
    public String toString() {
        return String.format("%10s %s","Dog",super.toString());
    }
}