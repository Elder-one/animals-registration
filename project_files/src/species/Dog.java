package species;

import java.util.GregorianCalendar;

public class Dog extends Pet {
    private Pet.species species;

    public Dog(String name, Animal.gen gender, GregorianCalendar bDate) {
        super(name, gender, bDate);
        this.species = Pet.species.DOG;
        Animal.animals.add(this);
    }

    public Pet.species getSpecies() {
        return this.species;
    }

    @Override
    public String toString() {
        return String.format("%5d %10s %s",
                this.getId(),
                "Dog",
                super.toString());
    }
}