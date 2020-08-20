package Study.Spring.boot.study.service;

import Study.Spring.boot.study.domain.Delivery;
import Study.Spring.boot.study.domain.Item.Item;
import Study.Spring.boot.study.domain.Member;
import Study.Spring.boot.study.domain.Order;
import Study.Spring.boot.study.domain.OrderItem;
import Study.Spring.boot.study.repository.ItemRepository;
import Study.Spring.boot.study.repository.MemberRepository;
import Study.Spring.boot.study.repository.OrderRepository;
import Study.Spring.boot.study.repository.OrderSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {
    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    @Transactional
    public Long order(Long memberId, Long itemId, int count){
        Member member = memberRepository.findOne(memberId);
        Item item = itemRepository.findOne(itemId);

        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());

        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

        Order order = Order.CreateOrder(member, delivery, orderItem);

        orderRepository.save(order);

        return order.getId();
    }

    @Transactional
    public void cancel(Long orderId){
        Order order = orderRepository.findOne(orderId);

        order.cancel();
    }

    public List<Order> findOrders(OrderSearch orderSearch){
        return orderRepository.findAllByString(orderSearch);
    }
}
