/* Created by: piyush
    Date: 15 June 2019
*/
package com.rbac.exceptions;

public class ResourceNotFoundException extends Exception{
    public ResourceNotFoundException() {
        super("No matching resource found exception in memory");
    }
    public ResourceNotFoundException(int size) {
        super("No resource available in memory resource size is "+size);
    }
}
