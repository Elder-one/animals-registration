package species;

import species.Draft;

import java.util.GregorianCalendar;

public class Horse extends Draft{
    private Draft.species species;

    public Horse(String name, Animal.gen gender, GregorianCalendar bDate) {
        super(name, gender, bDate);
        this.species = Draft.species.HORSE;
        animals.add(this);
    }

    public Draft.species getSpecies() {
        return this.species;
    }

    @Override
    public String toString() {
        return String.format("%5d %10s %s",
                this.getId(),
                "Horse",
                super.toString());
    }
}
