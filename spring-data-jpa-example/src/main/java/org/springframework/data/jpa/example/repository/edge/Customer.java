package org.springframework.data.jpa.example.repository.edge;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by jeffrey on 07/06/15.
 */
@Entity
public class Customer extends AbstractPersistable<Long> {

    @Column(name = "GIVEN_NAME")
    private String givenName;

    @Column(name = "SURNAME")
    private String surname;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
