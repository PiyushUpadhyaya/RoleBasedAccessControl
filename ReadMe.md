## Welcome to RBAC ReadMe file##
1. Run the Application class from your IDE.

2. It is an input based application where you are asked for different choice and accordingly the output/action is performed.

3. The resources folder in parallel to /src can be ignored. Earlier I was planning to create files as resources and when application is given an input for the resource name, it checks if the resource access requires permission or not. However, I later changed it considering all the resources needs the same permission.

4. Classes and their role: 
a. **AssignRole class**: adds a role to the user. UserRoleMap variable is the in-memory storage
b. **RemoveRole class**: removes a role from the user
c. **UserHelper class**: To create dummy user and user on application request.
d. **PermissionCheckerService class**: Given a user, actiontype and resource system (any file name, it considers that the resoucre exist) it checks whether the action is allowed or not.
e. **Exception module**: Defines different type of exceptions possible
f. **ActionType class**:  enum defines different action
g. **User class**: A user that can be created with the properties
h. **ResourceService class**: It can be ignored (as mentioned in the point 3)
