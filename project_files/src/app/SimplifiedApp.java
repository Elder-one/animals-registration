package app;

import species.*;
import java.util.*;
import tools.Counter;
import tools.SpeciesModifier;
import static tools.Inputs.*;


public class SimplifiedApp {
    private static String animalsHeadline =
            String.format("%5s %10s %12s %8s %13s",
                                "ID", "SPECIES", "NAME",
                                "GENDER", "BORN")
            + "\n" +
            "-".repeat(5+10+12+8+13+4);
    public class StartPage {
        public static void run() {
            boolean interrupted = false;
            int resp = 0;
            while (true) {
                System.out.println(System.lineSeparator().repeat(50));
                if (interrupted) {
                    System.out.println("---------------------------");
                    System.out.println("Animal addition interrupted");
                    System.out.println("---------------------------");
                }
                interrupted = false;
                System.out.println(" 1: Show animal groups");
                System.out.println(" 2: Show all animals");
                System.out.println(" 3: Add new animal");
                System.out.println("-1: Quit");
                resp = getIntResponse("Choose option --> ");
                switch (resp) {
                    case 1:
                        GroupsPage.run();
                        break;
                    case 2:
                        AllAnimalsPage.run();
                        break;
                    case 3:
                        try (Counter counter = new Counter()) {
                            counter.add();
                        } catch (Counter.AnimalAdditionInterrupted e) {
                            interrupted = true;
                        }
                        break;
                    case -1:
                        return;
                    default:
                        System.out.println("Incorrect input");
                }
            }
        }
    }

    public class AddNewAnimal {
        public static int run() {
            int resp = 0;
            String name = null;
            GregorianCalendar bDate = null;
            Animal.gen animalGender = null;
            while(true) {
                System.out.println(System.lineSeparator().repeat(50));
                System.out.println(" 1: Create new Cat");
                System.out.println(" 2: Create new Dog");
                System.out.println(" 3: Create new Hamster");
                System.out.println(" 4: Create new Horse");
                System.out.println(" 5: Create new Camel");
                System.out.println(" 6: Create new Donkey");
                System.out.println("-1: Cancel");
                resp = getIntResponse("Your option --> ");

                if (resp > 0 && resp < 7) {
                    name = inputName();
                    if (name == null) {
                        return -1;
                    }
                    animalGender = inputGender();
                    if (animalGender == null) {
                        return -1;
                    }
                    bDate = inputBirthDate();
                    if (bDate == null) {
                        return -1;
                    }
                    switch (resp) {
                        case 1:
                            Cat cat = new Cat(name, animalGender, bDate);
                            return 0;
                        case 2:
                            Dog dog = new Dog(name, animalGender, bDate);
                            return 0;
                        case 3:
                            Hamster hamster = new Hamster(name, animalGender, bDate);
                            return 0;
                        case 4:
                            Horse horse = new Horse(name, animalGender, bDate);
                            return 0;
                        case 5:
                            Camel camel = new Camel(name, animalGender, bDate);
                            return 0;
                        case 6:
                            Donkey donkey = new Donkey(name, animalGender, bDate);
                            return 0;
                    }
                } else if (resp == -1) {
                    return -1;
                }
            }
        }
    }

    public class GroupsPage {
        public static void run() {
            int resp = 0;
            while (true) {
                System.out.println(System.lineSeparator().repeat(50));
                System.out.println(" 1: Pet animals");
                System.out.println(" 2: Draft animals");
                System.out.println("-1: Back");
                resp = getIntResponse("Choose option --> ");
                switch (resp) {
                    case 1:
                        PetAnimals.run();
                        break;
                    case 2:
                        DraftAnimals.run();
                        break;
                    case -1:
                        return;
                    default:
                        System.out.println("Incorrect input");
                }
            }
        }
    }

    public class AllAnimalsPage {
        public static void run() {
            int resp = 0;
            while (true) {
                System.out.println(System.lineSeparator().repeat(50));
                System.out.println(animalsHeadline);
                for (Animal animal : Animal.animals) {
                    System.out.println(animal);
                }
                while (true) {
                    resp = getIntResponse("Choose animal id or -1 to return --> ");
                    if (resp == -1) {
                        return;
                    } else if (Animal.getAnimal(resp) == null) {
                        continue;
                    } else {
                        AnimalProfile.run(Animal.getAnimal(resp));
                        break;
                    }
                }

            }
        }
    }

    public class PetAnimals {
        public static void run() {
            int resp = 0;
            while (true) {
                System.out.println(System.lineSeparator().repeat(50));
                System.out.println(" 1: Cats");
                System.out.println(" 2: Dogs");
                System.out.println(" 3: Hamsters");
                System.out.println("-1: Back");
                resp = getIntResponse("Choose option --> ");
                switch (resp) {
                    case 1:
                        Cats.run();
                        break;
                    case 2:
                        Dogs.run();
                        break;
                    case 3:
                        Hamsters.run();
                        break;
                    case -1:
                        return;
                    default:
                        System.out.println("Incorrect input");
                }
            }
        }
    }

    public class DraftAnimals {
        public static void run() {
            int resp = 0;
            while (true) {
                System.out.println(System.lineSeparator().repeat(50));
                System.out.println(" 1: Horses");
                System.out.println(" 2: Camels");
                System.out.println(" 3: Donkeys");
                System.out.println("-1: Back");
                resp = getIntResponse("Choose option --> ");
                switch (resp) {
                    case 1:
                        Horses.run();
                        break;
                    case 2:
                        Camels.run();
                        break;
                    case 3:
                        Donkeys.run();
                        break;
                    case -1:
                        return;
                    default:
                        System.out.println("Incorrect input");
                }
            }
        }
    }

    public class Cats {
        public static void run() {
            int resp = 0;
            while (true) {
                System.out.println(System.lineSeparator().repeat(50));
                System.out.println(animalsHeadline);
                for (Animal animal : Animal.animals) {
                    if (animal instanceof Cat) {
                        System.out.println(animal);
                    }
                }
                resp = animalProfileLoop();
                if (resp == -1) {
                    return;
                }

            }
        }
    }

    public class Dogs {
        public static void run() {
            int resp = 0;
            while (true) {
                System.out.println(System.lineSeparator().repeat(50));
                System.out.println(animalsHeadline);
                for (Animal animal : Animal.animals) {
                    if (animal instanceof Dog) {
                        System.out.println(animal);
                    }
                }
                resp = animalProfileLoop();
                if (resp == -1) {
                    return;
                }

            }
        }
    }

    public class Hamsters {
        public static void run() {
            int resp = 0;
            while (true) {
                System.out.println(System.lineSeparator().repeat(50));
                System.out.println(animalsHeadline);
                for (Animal animal : Animal.animals) {
                    if (animal instanceof Hamster) {
                        System.out.println(animal);
                    }
                }
                resp = animalProfileLoop();
                if (resp == -1) {
                    return;
                }

            }
        }
    }

    public class Horses {
        public static void run() {
            int resp = 0;
            while (true) {
                System.out.println(System.lineSeparator().repeat(50));
                System.out.println(animalsHeadline);
                for (Animal animal : Animal.animals) {
                    if (animal instanceof Horse) {
                        System.out.println(animal);
                    }
                }
                resp = animalProfileLoop();
                if (resp == -1) {
                    return;
                }

            }
        }
    }

    public class Camels {
        public static void run() {
            int resp = 0;
            while (true) {
                System.out.println(System.lineSeparator().repeat(50));
                System.out.println(animalsHeadline);
                for (Animal animal : Animal.animals) {
                    if (animal instanceof Camel) {
                        System.out.println(animal);
                    }
                }
                resp = animalProfileLoop();
                if (resp == -1) {
                    return;
                }

            }
        }
    }

    public class Donkeys {
        public static void run() {
            int resp = 0;
            while (true) {
                System.out.println(System.lineSeparator().repeat(50));
                System.out.println(animalsHeadline);
                for (Animal animal : Animal.animals) {
                    if (animal instanceof Donkey) {
                        System.out.println(animal);
                    }
                }
                resp = animalProfileLoop();
                if (resp == -1) {
                    return;
                }
            }
        }
    }

    public class AnimalProfile {
        public static void run(Animal animal) {
            int resp = 0;
            boolean isPet = animal instanceof Pet;
            while (true) {
                System.out.println(System.lineSeparator().repeat(50));
                System.out.println(animalsHeadline);
                System.out.println(animal);
                System.out.println("----------------");
                System.out.println("Mastered tricks:");
                if (isPet) {
                    Pet pet = (Pet)animal;
                    ArrayList<Pet.Trick> trickList = pet.getTrickList();
                    if (trickList.isEmpty()) {
                        System.out.println("None");
                    }
                    for (Pet.Trick trick : trickList) {
                        System.out.println(trick);
                    }
                }
                else {
                    System.out.println("Draft animals cannot be trained");
                }
                System.out.println("----------------");
                System.out.println(" 1: Train new trick (Pets only!!!)");
                System.out.println(" 2: Edit the species");
                System.out.println("-1: Back");
                resp = getIntResponse("Choose option --> ");
                switch (resp) {
                    case 1:
                        if (isPet) {
                            TrainNewTrick.run((Pet)animal);
                        }
                        break;
                    case 2:
                        EditSpecies.run(animal);
                        return;
                    case -1:
                        return;
                    default:
                        break;
                }
            }
        }
    }

    public class EditSpecies {
        public static void run(Animal animal) {
            int resp = 0;
            while (true) {
                System.out.println(System.lineSeparator().repeat(50));
                System.out.println("Choose destination group:");
                System.out.println(" 1: Pet");
                System.out.println(" 2: Draft animal");
                System.out.println("-1: Cancel");
                resp = getIntResponse("Your option --> ");
                switch (resp) {
                    case 1:
                        ConvToPet.run(animal);
                        return;
                    case 2:
                        ConvToDraft.run(animal);
                        return;
                    case -1:
                        return;
                    default:
                        break;
                }
            }
        }
    }

    public class ConvToPet {
        public static void run(Animal animal) {
            int resp = 0;
            while (true) {
                System.out.println(System.lineSeparator().repeat(50));
                System.out.println(" 1: Convert to Cat");
                System.out.println(" 2: Convert to Dog");
                System.out.println(" 3: Convert to Hamster");
                System.out.println("-1: Cancel");
                resp = getIntResponse("Your option --> ");
                switch (resp) {
                    case 1:
                        animal = SpeciesModifier.convToPet(animal, Pet.species.CAT);
                        return;
                    case 2:
                        animal = SpeciesModifier.convToPet(animal, Pet.species.DOG);
                        return;
                    case 3:
                        animal = SpeciesModifier.convToPet(animal, Pet.species.HAMSTER);
                        return;
                    case -1:
                        return;
                    default:
                        break;
                }
            }
        }
    }

    public class ConvToDraft {
        public static void run(Animal animal) {
            int resp = 0;
            while (true) {
                System.out.println(System.lineSeparator().repeat(50));
                System.out.println(" 1: Convert to Horse");
                System.out.println(" 2: Convert to Camel");
                System.out.println(" 3: Convert to Donkey");
                System.out.println("-1: Cancel");
                resp = getIntResponse("Your option --> ");
                switch (resp) {
                    case 1:
                        animal = SpeciesModifier.convToDraft(animal, Draft.species.HORSE);
                        return;
                    case 2:
                        animal = SpeciesModifier.convToDraft(animal, Draft.species.CAMEL);
                        return;
                    case 3:
                        animal = SpeciesModifier.convToDraft(animal, Draft.species.DONKEY);
                        return;
                    case -1:
                        return;
                    default:
                        break;
                }
            }
        }
    }

    public class TrainNewTrick {
        public static void run(Pet pet) {
            String name = "";
            String desc = "";
            while (true) {
                name = getStringResponse("Name of the trick --> ");
                if (!name.isEmpty()) break;
            }
            while (true) {
                desc = getStringResponse("Trick's description --> ");
                if (!desc.isEmpty()) break;
            }
            pet.learnTrick(new Pet.Trick(pet, name, desc));
        }
    }

    public static int animalProfileLoop () {
        while (true) {
            int resp = getIntResponse("Choose animal id to open profile\n" +
                    "or -1 to return --> ");
            if (resp == -1) {
                return -1;
            } else if (Animal.getAnimal(resp) == null) {
                continue;
            } else {
                AnimalProfile.run(Animal.getAnimal(resp));
                return 0;
            }
        }
    }

}
