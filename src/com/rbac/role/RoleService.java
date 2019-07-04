/* Created by: piyush
    Date: 15 June 2019
*/
package com.rbac.role;

import com.rbac.exceptions.UserNotFoundException;
import com.rbac.model.User;

import java.util.*;

@FunctionalInterface
public interface RoleService {
    public abstract void operation(User user, RoleType roleType) throws UserNotFoundException;
    public static Map<User, HashSet<RoleType>> userRoleMap = new HashMap<>();
    public static HashSet<RoleType> getRolesForUser(User user) {
        return userRoleMap.get(user);
    }

}
