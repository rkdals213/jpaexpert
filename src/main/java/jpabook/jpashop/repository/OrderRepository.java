package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "select o from Order o join fetch o.member m join fetch o.delivery d")
    List<Order> findAllWithMemberDelivery();

    @Query(value = "select distinct o from Order o join fetch o.member m join fetch o.delivery d join fetch o.orderItems oi join fetch oi.item i")
    List<Order> findAllWithItem();
}
