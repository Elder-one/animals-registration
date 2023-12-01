import java.text.ParseException;
import java.util.ArrayList;

public abstract class Pet extends Animal {
    public static class Trick {
        Pet pet;
        String name;
        String description;

        public Trick(Pet pet, String name, String desc) {
            this.pet = pet;
            this.name = name;
            this.description = desc;
        }

        @Override
        public String toString() {
            return String.format("%12s %s", this.name, this.description);
        }
    }

    private ArrayList<Trick> tricks;
    public enum species{CAT, DOG, HAMSTER};

    public Pet(String name, Animal.gen gender, String bDate) throws ParseException {
        super(name, gender, bDate);
        this.tricks = new ArrayList<Trick>();
    }

    public void learnTrick(Trick trick) {
        this.tricks.add(trick);
    }
    public ArrayList<Trick> getTrickList() {
        return this.tricks;
    }
}
