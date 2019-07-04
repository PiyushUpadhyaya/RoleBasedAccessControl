/* Created by: piyush
    Date: 15 June 2019
*/
package com.rbac.model;

import java.math.BigDecimal;

public class User {
    private String userName;
    private BigDecimal userId;
    private String firstName;
    private String lastName;

    public User(BigDecimal userId, String userName) {
        this.userName = userName;
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public BigDecimal getUserId() {
        return userId;
    }

    public void setUserId(BigDecimal userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
