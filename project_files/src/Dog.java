import java.text.ParseException;

public class Dog extends Pet{
    private Pet.species species;

    public Dog(String name, Animal.gen gender, String bDate) throws ParseException {
        super(name, gender, bDate);
        this.species = Pet.species.DOG;
    }

    public Pet.species getSpecies() {
        return this.species;
    }
}