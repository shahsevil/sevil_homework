package WebApp.entity;

import java.util.HashMap;

public class User {

    HashMap<String, String> users = new HashMap<>();

    public User() {
    }

    public User(HashMap<String, String> users) {
        this.users = users;
    }

    public String doLogin(String userName, String password) {
        if (userName == null || password == null || userName.isEmpty() || password.isEmpty()){
            return "Be sure that you filled out both text boxes.";
        }
        else  if (users.containsKey(userName)){
            return "This username is already used by someone";
        }
        else if (users.containsValue(password)){
            return "This password is already used by someone";
        }
        else if(!users.containsKey(userName)|| !users.containsValue(password)){
            return "You should register first";
        }
        else {
            return "Successfully logged in";
        }
    }

    public String doRegister(String userName, String password, String password_r) {
//        if (userName == null || password == null || password_r == null ||
//            userName.isEmpty() || password.isEmpty() || password_r.isEmpty()|| !password.equals(password_r)) {
//            return "Registering failed.";
//        } else {
        users.put(userName, password);
//        System.out.println(users.toString());
        return "You registered successfully.";
//    }
    }
}