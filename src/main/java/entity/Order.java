package entity;

import jakarta.persistence.*;

import java.time.LocalDate;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "orders")
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // 주문번호

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // 유저번호

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Product product; // 상품번호

    @CreationTimestamp
    @Column(name = "ordered_date")
    private LocalDate orderedDate; // 구매일자

    @Column(name = "quantity")
    private Integer quantity = 0; // 주문 수량
}
