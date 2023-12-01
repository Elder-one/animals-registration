import java.text.ParseException;

public class Cat extends Pet{
    private Pet.species species;

    public Cat(String name, Animal.gen gender, String bDate) throws ParseException {
        super(name, gender, bDate);
        this.species = Pet.species.CAT;
    }

    public Pet.species getSpecies() {
        return this.species;
    }
}
