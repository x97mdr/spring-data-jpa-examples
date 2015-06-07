package org.springframework.data.jpa.example.repository.edge;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.data.jpa.domain.Specifications.where;
import static org.springframework.data.jpa.example.repository.edge.CustomerSpecifications.*;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = EdgeConfiguration.class)
public class EdgeCaseTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void joinInSeparateSpecWithoutAliasCausesMultipleJoins() {
        Specification<Customer> criteria = where(hasOrderAfterOrOn(new Date())).and(withAmountsGreaterThan(100));
        List<Customer> customers = customerRepository.findAll(criteria);

        assertThat(customers, hasSize(0));
    }

    @Test
    public void joinInSeparateSpecWithAliasPreventsMultipleJoins() {
        Specification<Customer> criteria = where(hasOrderAfterOrOnAliased(new Date())).and(withAmountsGreaterThanAliased(100));
        List<Customer> customers = customerRepository.findAll(criteria);

        assertThat(customers, hasSize(0));
    }
}
