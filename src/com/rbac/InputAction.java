/* Created by: piyush
    Date: 16 June 2019
*/
package com.rbac;

import com.rbac.action.ActionType;
import com.rbac.exceptions.RoleNotFoundException;
import com.rbac.exceptions.UserNotFoundException;
import com.rbac.model.User;
import com.rbac.role.AssignRole;
import com.rbac.role.PermissionCheckerService;
import com.rbac.role.RemoveRole;
import com.rbac.role.RoleType;
import javafx.util.Pair;

import java.util.Scanner;

import static com.rbac.utils.UserHelper.*;

public class InputAction {

    protected static void choiceBasedAction(int choice, Scanner in) {
        switch (choice) {
            case 1: {
                createUserChoice(in);
                break;
            }
            case 2: {
                assignRoleChoice(in);
                break;
            }
            case 3: {
                removeRoleChoice(in);
                break;
            }
            case 4: {
                accessCheckChoice(in);
                break;
            }
            case 5: {
                displayCurrentUserNames();
                break;
            }
            case -1: {
                System.out.println("exiting on request");
            }
            default:
                System.out.println("Wrong choice of input");
        }
    }

    private static void accessCheckChoice(Scanner in) {
        displayCurrentUserNames();
        //Skipping the previos \n of integer input
        in.nextLine();
        System.out.println("Enter username actiontype (R/W/D) resourceName (space separated)");
        String[] args = in.nextLine().split(" ");
        try {
            User user = getUserFromUserName(args[0]);
            ActionType actionType = getActionTypeFromInput(args[1]);
            String resourceName = args[2];
            if (PermissionCheckerService.isActionAllowed(user, actionType, resourceName)) {
                System.out.println(actionType.name() + " action allowed for the user");
            } else {
                System.out.println(actionType.name() + " action not allowed for the user");
            }
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }

    private static void removeRoleChoice(Scanner in) {
        System.out.println("Enter username to remove a role");
        String username = in.next();
        System.out.println("Choose role from following(press respective integer): \n" +
                "1. ADMIN\t 2.DEVELOPER\t 3.USER");
        try {
            Pair<User, RoleType> userRoleTypePair = fetchUserAndRole(username, in.nextInt());
            new RemoveRole().operation(userRoleTypePair.getKey(), userRoleTypePair.getValue());
        } catch (UserNotFoundException | RoleNotFoundException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }

    private static Pair<User, RoleType> fetchUserAndRole(String username, int roleChoice) throws UserNotFoundException, RoleNotFoundException {
        User user = getUserFromUserName(username);
        RoleType roleType = getRoleFromInput(roleChoice);
        return new Pair<>(user, roleType);
    }

    private static void createUserChoice(Scanner in) {
        System.out.println("Enter username to create a user");
        try {
            createOnDemandUser(in.next());
        } catch (UserNotFoundException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }

    private static void assignRoleChoice(Scanner in) {
        System.out.println("Enter username to assign a role");
        String username = in.next();
        System.out.println("Choose role from following(press respective integer): \n" +
                "1. ADMIN\t 2.DEVELOPER\t 3.USER");
        try {
            Pair<User, RoleType> userRoleTypePair = fetchUserAndRole(username, in.nextInt());
            new AssignRole().operation(userRoleTypePair.getKey(), userRoleTypePair.getValue());
        } catch (UserNotFoundException | RoleNotFoundException ex) {
            System.out.println(ex.getLocalizedMessage());
        }

    }


    private static RoleType getRoleFromInput(int nextInt) throws RoleNotFoundException {
        if (nextInt == 1) {
            return RoleType.ADMIN;
        }
        if (nextInt == 2) {
            return RoleType.DEVELOPER;
        }
        if (nextInt == 3) {
            return RoleType.USER;
        }
        throw new RoleNotFoundException();
    }

    private static ActionType getActionTypeFromInput(String arg) {
        if (arg.equalsIgnoreCase("W")) {
            return ActionType.WRITE;
        }
        if (arg.equalsIgnoreCase("D")) {
            return ActionType.DELETE;
        }
        //deafult action type is kept as read
        return ActionType.READ;
    }


}
