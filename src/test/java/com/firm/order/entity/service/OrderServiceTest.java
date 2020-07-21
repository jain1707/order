package com.firm.order.entity.service;

import com.firm.order.entity.MyOrder;
import com.firm.order.repository.OrderRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {
    @Mock
    OrderRepository repo;
    OrderService os;
    MyOrder o;

    @BeforeEach
    void setUp() {
        os=new OrderService();
        repo=mock(OrderRepository.class);
        os.setRepo(repo);
        o = new MyOrder();
        o.setUserName("jaiashis");
        o.setPaymentId("p1234");
        o.setCreationDate(new Date());
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAll() {
        List<MyOrder> orders = new ArrayList<>();
        orders.add(o);
        when(repo.findAll()).thenReturn(orders);
        Response res = os.getAll();
        assertNotNull(res);
        assertEquals(res.getStatus(),200);
        List<MyOrder> norders = (List<MyOrder>) res.getEntity();
        assertEquals(1,norders.size());
        assertEquals("jaiashis",orders.get(0).getUserName());
    }

    @Test
    void getById() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}