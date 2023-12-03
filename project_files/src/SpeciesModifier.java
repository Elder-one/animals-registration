import java.text.ParseException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class SpeciesModifier {

    public static class UnableToModify extends Exception {
        public UnableToModify() {
            super("Cannot convert your animal to this species");
        }
    }

    private static void inheritTricks(Pet pet, ArrayList<Pet.Trick> trickList) {
        for (Pet.Trick trick : trickList) {
            pet.learnTrick(trick);
        }
    }

    public static Pet convToPet(Animal animal, Pet.species target) {
        String name = animal.getName();
        GregorianCalendar bDate = animal.getBirthDate();
        int id = animal.getId();
        Animal.gen gender = animal.getGender();
        if (animal instanceof Draft) {
            Animal.animals.remove(animal);
            if (target == Pet.species.CAT) {
                Pet result = new Cat(name, gender, bDate);
                result.setId(id);
                return result;
            } else if (target == Pet.species.DOG) {
                Pet result = new Dog(name, gender, bDate);
                result.setId(id);
                return result;
            } else {
                Pet result = new Hamster(name, gender, bDate);
                result.setId(id);
                return result;
            }
        }
        else {
            Pet pet = (Pet)animal;
            ArrayList<Pet.Trick> trickList = pet.getTrickList();
            Animal.animals.remove(animal);
            if (target == Pet.species.DOG) {
                Pet result = new Dog(name, gender, bDate);
                inheritTricks(result, trickList);
                result.setId(id);
                return result;
            } else if (target == Pet.species.CAT) {
                Pet result = new Cat(name, gender, bDate);
                inheritTricks(result, trickList);
                result.setId(id);
                return result;
            } else {
                Pet result = new Hamster(name, gender, bDate);
                inheritTricks(result, trickList);
                result.setId(id);
                return result;
            }
        }
    }

    public static Draft convToDraft(Animal animal, Draft.species target) {
        String name = animal.getName();
        GregorianCalendar bDate = animal.getBirthDate();
        int id = animal.getId();
        Animal.gen gender = animal.getGender();
        Animal.animals.remove(animal);
        if (target == Draft.species.HORSE) {
            Draft result = new Horse(name, gender, bDate);
            result.setId(id);
            return result;
        } else if (target == Draft.species.CAMEL) {
            Draft result = new Camel(name, gender, bDate);
            result.setId(id);
            return result;
        } else {
            Draft result = new Donkey(name, gender, bDate);
            result.setId(id);
            return result;
        }
    }
}
