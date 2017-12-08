import java.util.Scanner;

public class Demo {
    private final static Scanner SC = new Scanner(System.in);
    private static String inputStr;


    public static void main(String[] args) {
        Validator validator = Validator.getInstance();
        UserManagement userManagement = UserManagement.getInstance();

        while(!inputStr.equals("exit")) {
            inputStr = SC.nextLine().trim().toLowerCase();
            switch (inputStr){
                case "register": {
                    String[] userInfo = new String[4];

                    System.out.println("user name:");
                    userInfo[0] = SC.nextLine();

                    System.out.println("password:");
                    userInfo[1] = SC.nextLine();

                    System.out.println("email:");
                    userInfo[2] = SC.nextLine() ;

                    System.out.println("Balance:");
                    userInfo[3] = SC.nextLine();

                    if(validator.validate(userInfo)){
                        System.out.println("Registering");
                        userManagement.registerUser(userInfo);
                    }
                    break;
                }

                case "login": {
                    boolean logState = false;
                    System.out.println("Login:");
                    System.out.println("user name: ");
                    String userName = SC.nextLine();
                    System.out.println("password: ");
                    String password = SC.nextLine();
                    if (userManagement.getUsersMap().containsKey(userName)) {
                        logState = userManagement.getUsersMap().get(userName).getPassword().equals(password);
                    }
                    if (logState) {
                        userManagement.getUsersMap().get(userName).showUserInfo();
                    } else {
                        System.out.println("Access denied");
                    }
                }
            }
        }
    }
}
