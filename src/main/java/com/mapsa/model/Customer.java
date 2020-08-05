package com.mapsa.model;

import com.mapsa.persistence.Column;
import com.mapsa.persistence.Entity;
import com.mapsa.persistence.Id;
import com.mapsa.persistence.Table;

/**
 * @author Esmaeil Sadeghi, 8/5/20 4:12 PM
 */
@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @Column(name = "ID",dataType = "NUMBER", length = 8)
    private int id;
    @Column(name = "FIRST_NAME",dataType = "VARCHAR", length = 50)
    private String firstName;
    @Column(name = "LASTNAME", dataType = "VARCHAR", length = 50)
    private String lastName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
