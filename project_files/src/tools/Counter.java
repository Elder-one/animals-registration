package tools;

import app.SimplifiedApp;

public class Counter implements AutoCloseable {
    private static Integer count = 0;
    private Integer status = null;

    public static class AnimalAdditionInterrupted extends Exception {
        AnimalAdditionInterrupted() {
            super("animal addition interrupted");
        }
    }

    public Counter() {
        this.status = 0;
    }

    public void add() {
        this.status = SimplifiedApp.AddNewAnimal.run();
        if (this.status == 0) {
            count += 1;
        }
    }
    @Override
    public void close() throws AnimalAdditionInterrupted {
        if (this.status == -1) {
            throw new AnimalAdditionInterrupted();
        }
    }
}
