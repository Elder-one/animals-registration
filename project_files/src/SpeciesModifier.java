import java.text.ParseException;
import java.util.ArrayList;

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

    public static Pet convToPet(Animal animal, Pet.species target) throws UnableToModify {
        String name = animal.getName();
        String bDate = animal.getBirthDate();
        int id = animal.getId();
        Animal.gen gender = animal.getGender();
        if (animal instanceof Draft) {
            Animal.animals.remove(animal);
            if (target == Pet.species.CAT) {
                try {
                    Pet result = new Cat(name, gender, bDate);
                    result.setId(id);
                    return result;
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else if (target == Pet.species.DOG) {
                try {
                    Pet result = new Dog(name, gender, bDate);
                    result.setId(id);
                    return result;
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    Pet result = new Hamster(name, gender, bDate);
                    result.setId(id);
                    return result;
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        else {
            Pet pet = (Pet)animal;
            ArrayList<Pet.Trick> trickList = pet.getTrickList();
            Animal.animals.remove(animal);
            if (target == Pet.species.DOG) {
                try {
                    Pet result = new Dog(name, gender, bDate);
                    inheritTricks(result, trickList);
                    result.setId(id);
                    return result;
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else if (target == Pet.species.CAT) {
                try {
                    Pet result = new Cat(name, gender, bDate);
                    inheritTricks(result, trickList);
                    result.setId(id);
                    return result;
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    Pet result = new Hamster(name, gender, bDate);
                    inheritTricks(result, trickList);
                    result.setId(id);
                    return result;
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        throw new UnableToModify();
    }

    public static Draft convToDraft(Animal animal, Draft.species target) throws UnableToModify {
        String name = animal.getName();
        String bDate = animal.getBirthDate();
        int id = animal.getId();
        Animal.gen gender = animal.getGender();
        Animal.animals.remove(animal);
        if (target == Draft.species.HORSE) {
            try {
                Draft result = new Horse(name, gender, bDate);
                result.setId(id);
                return result;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else if (target == Draft.species.CAMEL) {
            try {
                Draft result = new Camel(name, gender, bDate);
                result.setId(id);
                return result;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Draft result = new Donkey(name, gender, bDate);
                result.setId(id);
                return result;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        throw new UnableToModify();
    }
}
