/* Created by: piyush
    Date: 15 June 2019
*/
package com.rbac.role;

import com.rbac.exceptions.UserNotFoundException;
import com.rbac.model.User;

public class RemoveRole implements RoleService {
    @Override
    public void operation(User user, RoleType roleToBeRemoved) throws UserNotFoundException {
        if (userRoleMap.get(user) == null) {
            throw new UserNotFoundException();
        }
        userRoleMap.get(user).remove(roleToBeRemoved);
    }
}
