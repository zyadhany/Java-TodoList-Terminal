import java.util.ArrayList;

public class Global {
    // Array list of Array list stroe username and password
    public static ArrayList<ArrayList<String>> users = new ArrayList<ArrayList<String>>();
    public static String username = "";
    
    public static ArrayList<PersonalList> personalLists = new ArrayList<PersonalList>();
    public static PersonalList personalList;


    public static void getPersonalList() {
        int index = -1;
        for (int i = 0; i < personalLists.size(); i++) {
            if (personalLists.get(i).getOwner().equals(username)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            personalList = new PersonalList(username);
            personalLists.add(personalList);
        } else {
            personalList = personalLists.get(index);
        }
    }
}
