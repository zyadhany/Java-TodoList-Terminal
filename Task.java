public class Task {
    private static int idCounter = 1;
    private int id;
    private String title;
    private String description;
    private boolean isDone;
    private String dueDate;
    private int priority;
    private String category;
    private String notes;

    public Task(String title, String description, boolean isDone, String dueDate, int priority, String category, String notes) {
        this.id = idCounter++;
        this.title = title;
        this.description = description;
        this.isDone = isDone;
        this.dueDate = dueDate;
        this.priority = priority;
        this.category = category;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsDone() {
        return isDone;
    }
    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    public String getDueDate() {
        return dueDate;
    }
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String toString() {
        return "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", isDone=" + isDone +
                ", dueDate='" + dueDate + '\'' +
                ", priority=" + priority +
                ", category='" + category + '\'' +
                ", notes='" + notes + '\'';
    }
}
