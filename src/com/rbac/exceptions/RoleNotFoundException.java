/* Created by: piyush
    Date: 16 June 2019
*/
package com.rbac.exceptions;

public class RoleNotFoundException extends Exception {
    public RoleNotFoundException() {
        super("Invalid role assign request");
    }
}
