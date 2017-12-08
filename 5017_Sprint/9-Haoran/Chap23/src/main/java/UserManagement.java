import java.util.HashMap;

public class UserManagement {
    //use builder pattern to manage users
    private HashMap<String, User> usersMap = new HashMap<>();


    public static UserManagement instance;

    private UserManagement(){};

    public static UserManagement getInstance(){
        if(instance == null){
            instance = new UserManagement();
        }
        return instance;
    }

    public HashMap<String, User> getUsersMap(){
        return instance.usersMap;
    }

    public boolean registerUser(String[] userInfo){
        if (Validator.validate(userInfo)) {
            User user = new UserBuilder()
                    .setUserName(userInfo[0]).setPassword(userInfo[1])
                    .setEmailAddress(userInfo[2]).setMoney(userInfo[3]).build();
            this.usersMap.put(user.getUserName(), user);
            return true;
        } else {
            return false;
        }
    }





    class User{
        private String userName;
        private String password;
        private String emailAddress;
        private Double balance;

        User(String userName, String password, String emailAddress, Double balance){
            this.userName = userName;
            this.password = password;
            this.emailAddress = emailAddress;
            this.balance = balance;
            System.out.println("Welcome!");
        }

        public String getUserName(){
            return this.userName;
        }

        public String getEmailAddress(){
            return this.emailAddress;
        }

        public Double getBalance(){
            return this.balance;
        }

        public String getPassword(){
            return this.password;
        }

        public void showUserInfo(){
            System.out.println("User name: " + getUserName());
            System.out.println("Email: " + getEmailAddress());
            System.out.println("Balance: " + getBalance());
        }

    }

    class UserBuilder{
        private String userName;
        private String password;
        private String emailAddress;
        private Double balance;

        public UserBuilder setUserName(String userName){
            this.userName = userName;
            return this;
        }

        public UserBuilder setPassword (String password){
            this.password = password;
            return this;
        }

        public UserBuilder setEmailAddress(String email){
            this.emailAddress = email;
            return this;
        }

        public UserBuilder setMoney(String money){
            this.balance = Double.parseDouble(money);
            return this;
        }

        public User build(){
            return new User(userName, password, emailAddress, balance);
        }
    }


}
