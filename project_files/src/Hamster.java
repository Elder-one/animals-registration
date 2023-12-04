import java.text.ParseException;
import java.util.Collections;
import java.util.GregorianCalendar;

public class Hamster extends Pet{
    private Pet.species species;

    public Hamster(String name, Animal.gen gender, GregorianCalendar bDate) {
        super(name, gender, bDate);
        this.species = Pet.species.HAMSTER;
        Animal.animals.add(this);
    }

    public Pet.species getSpecies() {
        return this.species;
    }

    @Override
    public String toString() {
        return String.format("%5d %10s %s",
                this.getId(),
                "Hamster",
                super.toString());
    }
}