import java.util.ArrayList;

public class Application {
    private Animal chosenOne;
    private Page startPage;
    private Page observeAll;
    private Page chooseSpecies;
    private Page observeGroups;
    private Page observeDraftSpecies;
    private Page observeHorses;
    private Page addNewHorse;
    private Page observeCamels;
    private Page addNewCamel;
    private Page observeDonkeys;
    private Page addNewDonkey;
    private Page observePetSpecies;
    private Page observeCats;
    private Page addNewCat;
    private Page observeDogs;
    private Page addNewDog;
    private Page observeHamsters;
    private Page addNewHamster;
    private Page observeAnimalTricks;

    public class Page {
        public static class Option<T extends Option.BoundFunction> {
            public static Integer count = 0;
            private Integer order;
            private String content;
            private BoundFunction func;

            public interface BoundFunction {
                public void execute();
            }
            public Option(String content, T func) {
                this.func = func;
                this.content = content;
                this.order = count + 1;
                count += 1;
            }

            public void choose() {
                this.func.execute();
            }

            @Override
            public String toString() {
                return String.format("%2d: %s", this.order, this.content);
            }
        }

        private Page rootPage;

        private ArrayList<Option> options;
        public Page(Page rootPage) {
            if (rootPage == null) {
                this.rootPage = this;
            } else {
                this.rootPage = rootPage;
            }
            this.options = new ArrayList<Option>();
            this.addOption(new Option("<-- back :", new Option.BoundFunction() {
                @Override
                public void execute() {
                    Page.this.rootPage.openPage();
                }
            }));
        }

        public Page getRoot() {
            return this.rootPage;
        }

        public void addOption(Option option) {
            this.options.add(option);
        }

        public void openPage() {
            System.out.println(System.lineSeparator().repeat(50));
            for(Option opt : this.options) {
                System.out.println(opt);
            }
            System.out.print("Choose an option --> ");
        }
    }


    public Application() {
        this.startPage = new Page(null);
        this.observeGroups = new Page(this.startPage);
        this.observeAll = new Page(this.startPage);
        this.chooseSpecies = new Page(this.observeAll);
        this.observeDraftSpecies = new Page(this.observeGroups);
        this.observePetSpecies = new Page(this.observeGroups);
        this.observeCats = new Page(this.observePetSpecies);
        this.observeDogs = new Page(this.observePetSpecies);
        this.observeHamsters = new Page(this.observePetSpecies);
        this.observeHorses = new Page(this.observeDraftSpecies);
        this.observeCamels = new Page(this.observeDraftSpecies);
        this.observeDonkeys = new Page(this.observeDraftSpecies);
        this.addNewCat = new Page(this.chooseSpecies);
        this.addNewDog = new Page(this.chooseSpecies);
        this.addNewHamster = new Page(this.chooseSpecies);
        this.addNewHorse = new Page(this.chooseSpecies);
        this.addNewCamel = new Page(this.chooseSpecies);
        this.addNewDonkey = new Page(this.chooseSpecies);
        this.observeAnimalTricks = new Page(this.startPage);

        this.startPage.addOption(new Page.Option("Observe animal groups", new Page.Option.BoundFunction() {
            @Override
            public void execute() {
                Application.this.observeGroups.openPage();
            }
        }));

        this.startPage.addOption(new Page.Option("Observe all animals", new Page.Option.BoundFunction() {
            @Override
            public void execute() {
                Application.this.observeAll.openPage();
            }
        }));

        this.startPage.addOption(new Page.Option("Observe animal groups", new Page.Option.BoundFunction() {
            @Override
            public void execute() {
                Application.this.observeGroups.openPage();
            }
        }));
    }
}
