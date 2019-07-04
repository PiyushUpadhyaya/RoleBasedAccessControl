/* Created by: piyush
    Date: 15 June 2019
*/
package com.rbac.resources;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ResourceService {

    public static List<String> availableResourceList = new ArrayList<>();

    public static List<String> getResourceList() {
        /*if no resources are yet added in the resource list then add all the resource file in the list and return it*/
        if (availableResourceList.size() == 0) {
            File dir = new File("./resources");
            File[] filesList = dir.listFiles();
            for (File file : filesList) {
                if (file.isFile()) {
                    availableResourceList.add(file.getName());
                }
            }
        }
        return availableResourceList;
    }
}
