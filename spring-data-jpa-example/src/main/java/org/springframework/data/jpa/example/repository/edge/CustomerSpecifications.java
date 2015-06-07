package org.springframework.data.jpa.example.repository.edge;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.Date;

public class CustomerSpecifications {

    public static Specification<Customer> hasOrderAfterOrOn(final Date date) {
        return new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path path = root.join(Customer_.orders).get(Order_.date);
                return criteriaBuilder.greaterThanOrEqualTo(path, date);
            }
        };
    }

    public static Specification<Customer> withAmountsGreaterThan(final int amount) {
        return new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path path = root.join(Customer_.orders).join(Order_.lineItems).get(OrderLineItem_.amount);
                return criteriaBuilder.greaterThanOrEqualTo(path, amount);
            }
        };
    }

    public static Specification<Customer> hasOrderAfterOrOnAliased(final Date date) {
        return new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Join<Customer, Order> customerOrderJoin =  root.join(Customer_.orders);
                customerOrderJoin.alias("customer_order");
                Path path = customerOrderJoin.get(Order_.date);
                return criteriaBuilder.greaterThanOrEqualTo(path, date);
            }
        };
    }

    public static Specification<Customer> withAmountsGreaterThanAliased(final int amount) {
        return new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Join<Customer, Order> customerOrderJoin =  root.join(Customer_.orders);
                customerOrderJoin.alias("customer_order");
                Path path = customerOrderJoin.join(Order_.lineItems).get(OrderLineItem_.amount);
                return criteriaBuilder.greaterThanOrEqualTo(path, amount);
            }
        };
    }
}
