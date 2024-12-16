import java.util.ArrayList;

public class WorkList extends Todolist {
    private ArrayList<String> owners;

    public WorkList() {
        super();
    }

    public void addOwner(String owner) {
        owners.add(owner);
    }
    
    public void removeOwner(String owner) {
        owners.remove(owner);
    }
}
