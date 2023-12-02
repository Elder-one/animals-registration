import java.text.ParseException;

public class Horse extends Draft{
    private Draft.species species;

    public Horse(String name, Animal.gen gender, String bDate) throws ParseException {
        super(name, gender, bDate);
        this.species = Draft.species.HORSE;
    }

    public Draft.species getSpecies() {
        return this.species;
    }
}
