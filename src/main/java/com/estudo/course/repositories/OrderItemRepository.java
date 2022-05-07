package com.estudo.course.repositories;

import com.estudo.course.entities.OrderItem;
import com.estudo.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {


}
