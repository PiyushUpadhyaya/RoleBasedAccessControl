/* Created by: piyush
    Date: 15 June 2019
*/
package com.rbac.role;

import com.rbac.action.ActionType;
import com.rbac.exceptions.ResourceNotFoundException;
import com.rbac.exceptions.UserNotFoundException;
import com.rbac.model.User;

import java.util.List;
import java.util.Set;

import static com.rbac.resources.ResourceService.getResourceList;
import static com.rbac.role.RolePermissionMapper.rolePermissionListMap;
import static com.rbac.role.RoleService.userRoleMap;

public class PermissionCheckerService {
    public static boolean isActionAllowed(User user, ActionType actionType, String resourceFileName) throws Exception {
        if (!userRoleMap.containsKey(user)) {
            throw new UserNotFoundException();
        }
        List<String> resourceList = getResourceList();
        if (resourceList.size() == 0) {
            throw new ResourceNotFoundException(resourceList.size());
        }
        if (resourceFileName == null) {
            throw new ResourceNotFoundException();
        }
        /* Assuming resource exists
        if (!resourceList.contains(resourceFileName)) {
            throw new ResourceNotFoundException();
        }
        */
        Set<RoleType> userRoles = userRoleMap.get(user);
        if (actionTypeAllowedForRole(actionType, userRoles)) {
            return true;
        }
        return false;
    }

    private static boolean actionTypeAllowedForRole(ActionType actionType, Set<RoleType> userRoles) {
        /*multiple roles for a user, the action may be available for one role but not for other so iterating over the complete list*/
        for (RoleType roleType : userRoles) {
            if (rolePermissionListMap.get(roleType).contains(actionType)) {
                return true;
            }
        }
        return false;
    }
}
