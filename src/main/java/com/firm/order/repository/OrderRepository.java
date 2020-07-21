package com.firm.order.repository;

import com.firm.order.entity.MyOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<MyOrder,Integer> {

    public List<MyOrder> findByUserName(String user);
}
