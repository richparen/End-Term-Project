package kz.iitu.endtermspring.service;

import kz.iitu.endtermspring.entity.MyOrder;
import kz.iitu.endtermspring.model.OrderStatusEnum;

import java.util.List;

public interface IOrderService {
    List<MyOrder> getAll();
    List<MyOrder> getOrdersById(Long userId);
    MyOrder createNew(MyOrder order);
    MyOrder changeOrderStatus(Long orderId, OrderStatusEnum status);
}
