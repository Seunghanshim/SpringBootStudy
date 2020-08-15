package Study.Spring.boot.study.domain;

import Study.Spring.boot.study.domain.Item.Item;
import lombok.Getter;
import lombok.Setter;
import org.thymeleaf.templateparser.markup.decoupled.IDecoupledTemplateLogicResolver;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
@Getter @Setter
public class OrderItem {
    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderPrice;
    private int count;
}
