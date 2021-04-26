package kz.iitu.endtermspring.repository;

import kz.iitu.endtermspring.entity.MyOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<MyOrder, Long> {
    List<MyOrder> getMyOrdersByUserId(Long userId);
}
