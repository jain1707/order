package com.firm.order.repository;

import com.firm.order.entity.MyOrder;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class OrderRepositoryTest {
    @Autowired
    OrderRepository repo;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findByUserName() {
        MyOrder o = new MyOrder();
        o.setUserName("jaiashis");
        o.setPaymentId("p1234");
        o.setCreationDate(new Date());
        repo.save(o);
        List<MyOrder> o1 = repo.findByUserName("jaiashis");
        assertNotNull(o1);
        assertEquals(1,o1.size());
        assertEquals("jaiashis",o1.get(0).getUserName());
    }
}