/* Created by: piyush
    Date: 15 June 2019
*/
package com.rbac;

import java.util.Scanner;

import static com.rbac.InputAction.choiceBasedAction;
import static com.rbac.utils.UserHelper.createDummyUser;
import static com.rbac.utils.UserHelper.displayCurrentUserNames;

public class Application {

    public static void main(String[] args) {
        onScreenDisplay();
    }

    protected static void onScreenDisplay() {
        System.out.println("Creating dummy users");
        createDummyUser();
        displayCurrentUserNames();
        int choice = 0;
        while (choice != -1) {
            System.out.println("Chooose option for: \n" +
                    "1. Add User\t2. Assign Role\t3. Remove Role\t4. Get Permission for action\t5. Display Users\n" +
                    "-1 to exit");
            Scanner in = new Scanner(System.in);
            choice = in.nextInt();
            choiceBasedAction(choice, in);
        }
    }


}
