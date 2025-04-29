package controller;
import java.io.Serializable;
import java.lang.*;

import model.User;

public class UserController implements Serializable {
    private User loggedUser;
    private User[] userList = new User[]{
        new User("quillan.ung@gmail.com", "test", "Quillan", 1),
        new User("john.doe@gmail.com", "1234", "John", 1),
        new User("jane.doe@gmail.com", "5678", "Janeathen", 1),
        new User("john.smith@gmail.com", "a", "Johnny", 0) //staff
    };

    public UserController() {
        
       
    }

    public void setLoggedUser(User user) {
        this.loggedUser = user;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public void addUser(User newUser) {
        User[] newUserList = new User[userList.length + 1];

        for (int i = 0; i < userList.length; i++) {
            newUserList[i] = userList[i];
        }

        newUserList[userList.length] = newUser; 
        userList = newUserList; 
    }

    public User[] getUserList() {
        return userList;
    }

    public User findUser(String email, String password) {
        for (User user : userList) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public String getString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i<userList.length ; i++) {
            sb.append(userList[i].getName());
            sb.append(" ");
        }
        return sb.toString();
    }
}

