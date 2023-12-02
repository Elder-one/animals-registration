import java.text.ParseException;

public class Donkey extends Draft{
    private Draft.species species;

    public Donkey(String name, Animal.gen gender, String bDate) throws ParseException {
        super(name, gender, bDate);
        this.species = Draft.species.DONKEY;
    }

    public Draft.species getSpecies() {
        return this.species;
    }
}
