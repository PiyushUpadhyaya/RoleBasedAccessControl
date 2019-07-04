/* Created by: piyush
    Date:  16 June 2019
*/
package com.rbac.utils;

import com.rbac.exceptions.UserNotFoundException;
import com.rbac.model.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UserHelper {
    public static List<User> listOfUsers = new ArrayList<>();
    public static void createDummyUser() {
        for (int i = 1; i < 5; i++) {
            listOfUsers.add(new User(BigDecimal.valueOf(i), "userName" + i));
        }
    }
    public static void createOnDemandUser(String userName) throws UserNotFoundException {
        if (userName == null) {
            //Logging purpose
            System.out.println("username is null");
            throw new UserNotFoundException(userName);
        }
        if (listOfUsers.stream().filter(user -> user.getUserName().equals(userName)).findFirst().orElse(null) != null) {
            System.out.println("User already exists");
            return;
        }
        listOfUsers.add(new User(BigDecimal.valueOf(listOfUsers.size()+1), userName));
    }

    public static User getUserFromUserName(String username) throws UserNotFoundException {
        User foundUser = listOfUsers.stream().filter(user->user.getUserName().equals(username)).findFirst().get();
        if (foundUser == null) {
            throw new UserNotFoundException();
        }
        return foundUser;
    }

    public static void displayCurrentUserNames() {
        System.out.println("In memory usernames are following: ");
        listOfUsers.stream().map(User::getUserName).forEach(System.out::println);
    }

}
