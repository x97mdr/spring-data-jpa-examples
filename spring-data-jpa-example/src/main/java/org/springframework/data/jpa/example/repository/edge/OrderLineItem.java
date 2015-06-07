package org.springframework.data.jpa.example.repository.edge;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_LINE_ITEMS")
public class OrderLineItem extends AbstractPersistable<Long> {

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "AMOUNT")
    private int amount;

    @ManyToOne
    public Order customerOrder;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Order getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(Order customerOrder) {
        this.customerOrder = customerOrder;
    }
}
