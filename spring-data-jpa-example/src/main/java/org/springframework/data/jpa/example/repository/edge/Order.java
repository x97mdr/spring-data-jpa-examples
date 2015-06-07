package org.springframework.data.jpa.example.repository.edge;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by jeffrey on 07/06/15.
 */
@Entity
@Table(name = "ORDERS")
public class Order extends AbstractPersistable<Long> {

    @Column(name = "DATE")
    public Date date;

    @ManyToOne
    public Customer customer;

    @OneToMany(mappedBy = "customerOrder")
    public List<OrderLineItem> lineItems;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderLineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<OrderLineItem> lineItems) {
        this.lineItems = lineItems;
    }
}
