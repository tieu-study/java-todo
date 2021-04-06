import java.util.List;
import java.util.Scanner;

public class Display {
    protected Scanner scanner;

    public Display() {
        this.scanner = new Scanner(System.in);
    }

    public void showMenu(String [] menu) {
        for (int i = 0; i < menu.length; i ++) {
            System.out.print(i + ": "); 
            System.out.println(menu[i]);
        }
    }

    public void showTasks(List<Task> tasks) {
        int index = 0;
        for (Task task: tasks) {
            System.out.print(index ++);
            System.out.print(". " + "(" + task.category + ") ");
            System.out.println(task.title);
        }
    }

    public String showQuestion(String title) {
        System.out.print(title);
        return this.scanner.nextLine();
    }

    public int showChoice(String title) {
        System.out.print(title);
        while (!scanner.hasNextInt()) {
            String input = scanner.next();
            System.out.printf("\"%s\" is not a valid option.\n", input);
        }
        return scanner.nextInt();
    }

    public void showLine() {
        System.out.println("_________________________");
    }

    public void clear() {
        this.scanner.nextLine();
    }

    public void showText(String text) {
        System.out.println(text);
    }
}
