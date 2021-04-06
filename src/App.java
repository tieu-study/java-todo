import java.util.ArrayList;
import java.util.List;

public class App {
    private List<Task> tasks;
    private Boolean end;
    private Display display;
    private String [] menu;

    public App () {
        this.tasks = new ArrayList<>();
        this.end = false;
        this.display = new Display();

        this.menu = new String[]{"Create", "Edit", "Delete", "Exit"};
    }

    public static void main(String[] args){
        new App().start();
    }

    public void start() {
        while (!this.end) {
            this.display.showTasks(this.tasks);
            this.display.showLine();
            this.display.showMenu(this.menu);
            this.display.showLine();

            int choice = this.display.showChoice("Chose action: ");
            handle(choice);

            this.display.showLine();
            this.display.showText("");
        }
    }

    public void addTask() {
        this.display.clear();
        String title = this.display.showQuestion("Title: ");
        String category = this.display.showQuestion("Category: ");

        this.tasks.add(new Task(title, category));
    }

    public void removeTask() {
        int index = this.display.showChoice("Enter task index: ");
        try {
            this.tasks.remove(index);
        } catch (Exception e) {
            this.display.showText(e.toString());
        }
    }

    public void editTask() {
        int index = this.display.showChoice("Enter task index: ");
        this.display.clear();
        try {
            Task task = this.tasks.get(index);

            task.title = this.display.showQuestion("Title: ");
            task.category = this.display.showQuestion("Category: ");
        } catch (Exception e) {
            this.display.showText(e.toString());
        }
    }

    public void handle(int choice) {
        switch (choice) {
            case 0:
                this.addTask(); 
                break;
            case 1:
                this.editTask();
                break;
            case 2:
                this.removeTask();
                break;
            case 3:
                this.end = true;
                break;
            default:
                this.display.showText("Invalid index");
        }
    }
}
