public class TodoProgram {
    private int state;

    public TodoProgram() {
        state = 0;
    }

    /**
     * Run the Todo Program
     * state 0: Display main menu
     * state 1: Login user
     *  
     */
    public void run() {
        UserInterface ui = new UserInterface();

        while (state != -1) {
            state = ui.RunState(state);
        }
    }

    public static void main(String[] args) {
        TodoProgram program = new TodoProgram();
        program.run();
    }   
}
