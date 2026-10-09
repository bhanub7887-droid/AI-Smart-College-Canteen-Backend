package com.canteen.smart_canteen.repository;

import com.canteen.smart_canteen.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
