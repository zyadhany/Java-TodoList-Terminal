public class PersonalList extends Todolist {
    private String owner;

    public PersonalList(String owner) {
        super();
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
