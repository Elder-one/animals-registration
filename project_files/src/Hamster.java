import java.text.ParseException;

public class Hamster extends Pet{
    private Pet.species species;

    public Hamster(String name, Animal.gen gender, String bDate) throws ParseException {
        super(name, gender, bDate);
        this.species = Pet.species.HAMSTER;
    }

    public Pet.species getSpecies() {
        return this.species;
    }
}