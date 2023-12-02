import java.text.ParseException;

public class Camel extends Draft{
    private Draft.species species;

    public Camel(String name, Animal.gen gender, String bDate) throws ParseException {
        super(name, gender, bDate);
        this.species = Draft.species.CAMEL;
    }

    public Draft.species getSpecies() {
        return this.species;
    }
}
