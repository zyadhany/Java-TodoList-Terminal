import java.util.ArrayList;
import java.util.List;

public class Todolist {
    private List<Task> tasks;

    public Todolist() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(int id) {
        int index = -1;
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            tasks.remove(index);
        }
    }

    public void markTaskAsDone(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setIsDone(true);
            }
        }
    }

    public void displayTasks() {
        int cnt = 1;
        for (Task task : tasks) {
            System.out.print("Task " + cnt + ":");
            System.out.println(task.toString());
            cnt++;
        }
    }

    public void displayUnfinishedTasks() {
        int cnt = 1;
        for (Task task : tasks) {
            if (!task.getIsDone()) {
                System.out.print("Task " + cnt + ":");
                System.out.println(task.toString());
                cnt++;
            }
        }
    }

    public void displayFinishedTasks() {
        int cnt = 1;
        for (Task task : tasks) {
            if (task.getIsDone()) {
                System.out.print("Task " + cnt + ":");
                System.out.println(task.toString());
                cnt++;
            }
        }
    }

    public void displayTasksByCategory(String category) {
        int cnt = 1;
        for (Task task : tasks) {
            if (task.getCategory().equals(category)) {
                System.out.print("Task " + cnt + ":");
                System.out.println(task.toString());
                cnt++;
            }
        }
    }

    public void displayTasksByPriority(int priority) {
        int cnt = 1;
        for (Task task : tasks) {
            if (task.getPriority() == priority) {
                System.out.print("Task " + cnt + ":");
                System.out.println(task.toString());
                cnt++;
            }
        }
    }

    public void displayTasksSortedByPriority() {
        tasks.sort((t1, t2) -> t2.getPriority() - t1.getPriority());
        displayTasks();
    }

    public void displayTasksSortedByDueDate() {
        tasks.sort((t1, t2) -> t1.getDueDate().compareTo(t2.getDueDate()));
        displayTasks();
    }

    public void displayTasksSortedByCategory() {
        tasks.sort((t1, t2) -> t1.getCategory().compareTo(t2.getCategory()));
        displayTasks();
    }
}
