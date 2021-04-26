package kz.iitu.endtermspring.service.implement;

import kz.iitu.endtermspring.entity.MyOrder;
import kz.iitu.endtermspring.event.ChangeOrderStatus;
import kz.iitu.endtermspring.model.OrderStatusEnum;
import kz.iitu.endtermspring.repository.OrderRepository;
import kz.iitu.endtermspring.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService implements IOrderService, ApplicationEventPublisherAware {
    @Autowired
    private OrderRepository orderRepository;
    private ApplicationEventPublisher eventPublisher;

    @Override
    public List<MyOrder> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<MyOrder> getOrdersById(Long userId) {
        return orderRepository.getMyOrdersByUserId(userId);
    }

    @Override
    public MyOrder createNew(MyOrder order) {
        order.setDay(new Date());
        MyOrder saveOrder = orderRepository.saveAndFlush(order);

        for (int i = 0; i < saveOrder.getOrderItems().size(); i++) {
                saveOrder.getOrderItems().get(i).setOrderId(saveOrder.getId());
        }

        return orderRepository.saveAndFlush(saveOrder);
    }

    @Override
    public MyOrder changeOrderStatus(Long orderId, OrderStatusEnum status) {
        MyOrder order = orderRepository.getOne(orderId);
        OrderStatusEnum oldStatus = order.getStatus();
        order.setStatus(status);
        eventPublisher.publishEvent(new ChangeOrderStatus(this, oldStatus, order));
        return orderRepository.saveAndFlush(order);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}
