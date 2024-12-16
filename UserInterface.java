import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class UserInterface {
    Scanner input;
    // map untervase to index
    // list index to interface
    ArrayList<String> interfaces;
    Map<String, Integer> interfaceIndex;


    public UserInterface() {
        input = new Scanner(System.in);
        interfaces = new ArrayList<>();
        interfaces.add("MainMenu");
        interfaces.add("LoginUser");
        interfaces.add("RegisterUser");
        interfaces.add("TodoMenu");
        interfaces.add("PersonalListMenu");
        interfaces.add("WorkListMenu");
        interfaces.add("addTask");
        interfaces.add("removeTask");
        interfaces.add("displayTasks");
        interfaces.add("markTaskAsDone");
        interfaces.add("LogOut");
        interfaces.add("Exit");

        interfaceIndex = new HashMap<>();
        for (int i = 0; i < interfaces.size(); i++) {
            interfaceIndex.put(interfaces.get(i), i);
        }
    }

    public int RunState(int state) {
        String interfaceName = interfaces.get(state);
        switch (interfaceName) {
            case "MainMenu":
                return MainMenu();
            case "LoginUser":
                return LoginUser();
            case "RegisterUser":
                return RegisterUser();
            case "TodoMenu":
                return TodoMenu();
            case "PersonalListMenu":
                return PersonalListMenu();
            case "WorkListMenu":
                return WorkListMenu();
            case "LogOut":
                return LogOut();
            case "addTask":
                return addTask();
            case "removeTask":
                return removeTask();
            case "displayTasks":
                return displayTasks();
            case "markTaskAsDone":
                return markTaskAsDone();
            case "Exit":
                return -1;
            default:
                System.out.println("Invalid state");
        }

        return state;
    }

    public int addTask() {
        String title, description, dueDate, category, notes;
        int priority;

        try {
            System.out.println("Enter task title:");
            title = input.nextLine();
            System.out.println("Enter task description:");
            description = input.nextLine();
            System.out.println("Enter task due date:");
            dueDate = input.nextLine();
            System.out.println("Enter task priority:");
            priority = input.nextInt();
            input.nextLine();
            System.out.println("Enter task category:");
            category = input.nextLine();
            System.out.println("Enter task notes:");
            notes = input.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid input");
            input.nextLine();
            return interfaceIndex.get("PersonalListMenu");
        }

        Task task = new Task(title, description, false, dueDate, priority, category, notes);
        Global.personalList.addTask(task);

        return interfaceIndex.get("PersonalListMenu");
    }

    public int removeTask() {
        int id;

        try {
            System.out.println("Enter task id to remove:");
            id = input.nextInt();
            input.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid input");
            input.nextLine();
            return interfaceIndex.get("PersonalListMenu");
        }

        Global.personalList.removeTask(id);
        return interfaceIndex.get("PersonalListMenu");
    }

    public int displayTasks() {
        Global.personalList.displayUnfinishedTasks();
        
        return interfaceIndex.get("PersonalListMenu");
    }

    public int markTaskAsDone() {
        int id;
        try {
            System.out.println("Enter task id to mark as done:");
            id = input.nextInt();
            input.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid input");
            input.nextLine();
            return interfaceIndex.get("PersonalListMenu");
        }

        Global.personalList.markTaskAsDone(id);
        return interfaceIndex.get("PersonalListMenu");
    }

    public int PersonalListMenu() {
        System.out.println("Welcome to Personal List Menu!");
        System.out.println("1. Add task");
        System.out.println("2. Remove task");
        System.out.println("3. Display Unfinished tasks");
        System.out.println("4. Mark task as done");
        System.out.println("5. previous menu");
        System.out.println("6. Exit");

        try {
            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                return interfaceIndex.get("addTask");
            } else if (choice == 2) {
                return interfaceIndex.get("removeTask");
            } else if (choice == 3) {
                return interfaceIndex.get("displayTasks");
            } else if (choice == 4) {
                return interfaceIndex.get("markTaskAsDone");
            } else if (choice == 5) {
                return interfaceIndex.get("TodoMenu");
            } else if (choice == 6) {
                return interfaceIndex.get("Exit");
            }

            System.out.println("Invalid choice");
        } catch (Exception e) {
            System.out.println("Invalid input");
            input.nextLine();
        }

        return interfaceIndex.get("PersonalListMenu");
    }

    public int WorkListMenu() {
        System.out.println("Welcome to Work List Menu!");
        System.out.println("Not implemented yet");
        return interfaceIndex.get("TodoMenu");
    }

    public int MainMenu() {
        System.out.println("Welcome to Todo Program!");
        System.out.println("1. Login user");
        System.out.println("2. Register user");
        System.out.println("3. Exit");

        try {
            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                return interfaceIndex.get("LoginUser");
            } else if (choice == 2) {
                return interfaceIndex.get("RegisterUser");
            } else if (choice == 3) {
                return interfaceIndex.get("Exit");
            }
            System.out.println("Invalid choice");
        } catch (Exception e) {
            System.out.println("Invalid input");
            input.nextLine();
        }

        return interfaceIndex.get("MainMenu");
    }

    public int TodoMenu(){
        System.out.println("Welcome to Todo Menu!");
        System.out.println("1. Open personal list");
        System.out.println("2. Open Work list");
        System.out.println("3. Log out");
        System.out.println("4. Exit");

        try {
            int choice = input.nextInt();
            input.nextLine();
            
            if (choice == 1) {
                return interfaceIndex.get("PersonalListMenu");
            } else if (choice == 2) {
                return interfaceIndex.get("WorkListMenu");
            } else if (choice == 3) {
                return interfaceIndex.get("LogOut");
            }
            else if (choice == 4) {
                return interfaceIndex.get("Exit");
            }

            System.out.println("Invalid choice");
        } catch (Exception e) {
            System.out.println("Invalid input");
            input.nextLine();
        }

        return interfaceIndex.get("TodoMenu");
    }

    public int LoginUser() {
        System.out.println("Enter username:");
        String username = input.nextLine();
        System.out.println("Enter password:");
        String password = input.nextLine();

        for (ArrayList<String> user : Global.users) {
            if (user.get(0).equals(username) && user.get(1).equals(password)) {
                Global.username = username;
                Global.getPersonalList();
                return interfaceIndex.get("TodoMenu");
            }
        }
        
        System.out.println("Invalid username or password");
        return interfaceIndex.get("MainMenu");
    }

    public int RegisterUser() {
        System.out.println("Enter username:");
        String username = input.nextLine();
        System.out.println("Enter password:");
        String password = input.nextLine();

        int found = 0;
        for (ArrayList<String> user : Global.users) {
            if (user.get(0).equals(username)) {
                found = 1;
                break;
            }
        }

        if (found == 1) {
            System.out.println("Username already exists");
            return interfaceIndex.get("MainMenu");
        }


        ArrayList<String> user = new ArrayList<>();
        user.add(username);
        user.add(password);
        Global.users.add(user);

        System.out.println("User registered successfully");
        return interfaceIndex.get("MainMenu");
    }

    public int LogOut() {
        Global.username = "";
        Global.personalList = null;
        return interfaceIndex.get("MainMenu");
    }
}
