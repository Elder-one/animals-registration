import java.util.ArrayList;
import java.util.Scanner;

public class SimplifiedApp {
    public class StartPage {
        public static void run() {
            int resp = 0;
            while (true) {
                System.out.println(System.lineSeparator().repeat(50));
                System.out.println(" 1: Show animal groups");
                System.out.println(" 2: Show all animals");
                System.out.println("-1: Quit");
                resp = getIntResponse("Choose option --> ");
                switch (resp) {
                    case 1:
                        GroupsPage.run();
                        break;
                    case 2:
                        AllAnimalsPage.run();
                        break;
                    case -1:
                        return;
                    default:
                        System.out.println("Incorrect input");
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
                for (Animal animal : Animal.animals) {
                    System.out.println(String.format("%10s %s",
                                        animal.getClass().getName(),
                                        animal));
                }
                resp = getIntResponse("Choose animal id or -1 to return --> ");
                while (true) {
                    if (resp == -1) {
                        return;
                    } else if (Animal.getAnimal(resp) == null) {
                        resp = getIntResponse("Choose animal id or -1 to return --> ");
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
                for (Animal animal : Animal.animals) {
                    if (animal instanceof Cat) {
                        System.out.println(animal);
                    }
                }
                resp = getIntResponse("Choose animal id to open profile\n" +
                        "or -1 to return --> ");
                while (true) {
                    if (resp == -1) {
                        return;
                    } else if (Animal.getAnimal(resp) == null) {
                        resp = getIntResponse("Choose animal id to open profile\n" +
                                "or -1 to return --> ");
                    } else {
                        AnimalProfile.run(Animal.getAnimal(resp));
                    }
                }

            }
        }
    }

    public class Dogs {
        public static void run() {
            int resp = 0;
            while (true) {
                System.out.println(System.lineSeparator().repeat(50));
                for (Animal animal : Animal.animals) {
                    if (animal instanceof Dog) {
                        System.out.println(animal);
                    }
                }
                resp = getIntResponse("Choose animal id to open profile\n" +
                        "or -1 to return --> ");
                while (true) {
                    if (resp == -1) {
                        return;
                    } else if (Animal.getAnimal(resp) == null) {
                        resp = getIntResponse("Choose animal id to open profile\n" +
                                "or -1 to return --> ");
                    } else {
                        AnimalProfile.run(Animal.getAnimal(resp));
                    }
                }

            }
        }
    }

    public class Hamsters {
        public static void run() {
            int resp = 0;
            while (true) {
                System.out.println(System.lineSeparator().repeat(50));
                for (Animal animal : Animal.animals) {
                    if (animal instanceof Hamster) {
                        System.out.println(animal);
                    }
                }
                resp = getIntResponse("Choose animal id to open profile\n" +
                        "or -1 to return --> ");
                while (true) {
                    if (resp == -1) {
                        return;
                    } else if (Animal.getAnimal(resp) == null) {
                        resp = getIntResponse("Choose animal id to open profile\n" +
                                "or -1 to return --> ");
                    } else {
                        AnimalProfile.run(Animal.getAnimal(resp));
                    }
                }

            }
        }
    }

    public class Horses {
        public static void run() {
            int resp = 0;
            while (true) {
                System.out.println(System.lineSeparator().repeat(50));
                for (Animal animal : Animal.animals) {
                    if (animal instanceof Horse) {
                        System.out.println(animal);
                    }
                }
                resp = getIntResponse("Choose animal id to open profile\n" +
                        "or -1 to return --> ");
                while (true) {
                    if (resp == -1) {
                        return;
                    } else if (Animal.getAnimal(resp) == null) {
                        resp = getIntResponse("Choose animal id to open profile\n" +
                                "or -1 to return --> ");
                    } else {
                        AnimalProfile.run(Animal.getAnimal(resp));
                    }
                }

            }
        }
    }

    public class Camels {
        public static void run() {
            int resp = 0;
            while (true) {
                System.out.println(System.lineSeparator().repeat(50));
                for (Animal animal : Animal.animals) {
                    if (animal instanceof Camel) {
                        System.out.println(animal);
                    }
                }
                resp = getIntResponse("Choose animal id to open profile\n" +
                        "or -1 to return --> ");
                while (true) {
                    if (resp == -1) {
                        return;
                    } else if (Animal.getAnimal(resp) == null) {
                        resp = getIntResponse("Choose animal id to open profile\n" +
                                "or -1 to return --> ");
                    } else {
                        AnimalProfile.run(Animal.getAnimal(resp));
                    }
                }

            }
        }
    }

    public class Donkeys {
        public static void run() {
            int resp = 0;
            while (true) {
                System.out.println(System.lineSeparator().repeat(50));
                for (Animal animal : Animal.animals) {
                    if (animal instanceof Donkey) {
                        System.out.println(animal);
                    }
                }
                resp = getIntResponse("Choose animal id to open profile\n" +
                        "or -1 to return --> ");
                while (true) {
                    if (resp == -1) {
                        return;
                    } else if (Animal.getAnimal(resp) == null) {
                        resp = getIntResponse("Choose animal id to open profile\n" +
                                "or -1 to return --> ");
                    } else {
                        AnimalProfile.run(Animal.getAnimal(resp));
                    }
                }

            }
        }
    }

    public class AnimalProfile {
        public static void run(Animal animal) {
            int resp = 0;
            while (true) {
                System.out.println(animal);
                System.out.println("Mastered tricks:");
                if (animal instanceof Pet) {
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
                System.out.println(" 1: Train new trick (Pets only!!!)");
                System.out.println(" 2: Edit the species");
                System.out.println("-1: Back");
            }
        }
    }

    public static int getIntResponse(String message) {
        System.out.print(message);
        Scanner s = new Scanner(System.in);
        int response = s.nextInt();
        return response;
    }
}
