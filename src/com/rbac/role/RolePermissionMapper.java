/* Created by: piyush
    Date: 15 June 2019
*/
package com.rbac.role;

import com.rbac.action.ActionType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RolePermissionMapper {
    public static HashMap<RoleType, List<ActionType>> rolePermissionListMap;
    static {
        rolePermissionListMap = new HashMap<>();
        rolePermissionListMap.put(RoleType.ADMIN, Arrays.asList(ActionType.READ, ActionType.WRITE, ActionType.DELETE));
        rolePermissionListMap.put(RoleType.DEVELOPER, Arrays.asList(ActionType.READ, ActionType.WRITE));
        rolePermissionListMap.put(RoleType.USER, Arrays.asList(ActionType.READ));
    }

}
