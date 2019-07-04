/* Created by: piyush
    Date: 15 June 2019
*/
package com.rbac.exceptions;

public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super("User not found exception");
    }
    public UserNotFoundException(String username) {
        super("Invalid username exception "+username);
    }
}
