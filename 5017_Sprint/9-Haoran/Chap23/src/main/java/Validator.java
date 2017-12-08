import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {


    private Validator(){}

    private static Validator instance;

    public static synchronized Validator getInstance(){
        if(instance == null){
            instance = new Validator();
        }
        return instance;
    }


    public static boolean validate(String[] userInfo){
        if(userInfo.length != 4)
            return false;

        return instance.userNameValidator(userInfo[0])
                && instance.emailValidator(userInfo[2])
                && instance.balanceValidator(userInfo[3]);
    }

    private boolean emailValidator(String email){
        Pattern emailPattern =  Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher matcher = emailPattern.matcher(email);
        if (matcher.matches())
            System.out.println("Email valid.");
        return matcher.matches();
    }

    private boolean userNameValidator(String userName){
        return !UserManagement.getInstance().getUsersMap().containsKey(userName);

    }

    private boolean balanceValidator(String money){
        try {
            Double balance = Double.parseDouble(money);
            if (balance<0)
                return false;
        } catch (Exception e){
            System.out.println("Balance illegal.");
        }
        return true;
    }

}
