/* Created by: piyush
    Date: 15 June 2019
*/
package com.rbac.exceptions;

public class AccessDeniedException extends Exception {
    public AccessDeniedException() {
        super("User does not have access for the action");
    }
}
