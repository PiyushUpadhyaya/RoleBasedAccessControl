/* Created by: piyush
    Date: 15 June 2019
*/
package com.rbac.role;

import com.rbac.model.User;

import java.util.HashSet;

public class AssignRole implements RoleService {
    @Override
    public void operation(User user, RoleType newRoleForUser) {
        if (userRoleMap.get(user) != null) {
            userRoleMap.get(user).add(newRoleForUser);
        } else {
            HashSet<RoleType> roleTypeSetForUser = new HashSet<>();
            roleTypeSetForUser.add(newRoleForUser);
            userRoleMap.put(user, roleTypeSetForUser);
        }
    }
}
