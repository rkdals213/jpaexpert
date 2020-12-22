package jpabook.jpashop.domain;

import lombok.Data;

@Data
public class OrderSearch {
    private OrderStatus orderStatus;
    private String memberName;
}
