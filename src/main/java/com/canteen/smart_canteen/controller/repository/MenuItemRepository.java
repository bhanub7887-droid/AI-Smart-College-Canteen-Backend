package com.canteen.smart_canteen.repository;

import com.canteen.smart_canteen.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}
