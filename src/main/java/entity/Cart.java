package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "carts")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // 번호

    @ManyToOne
    @JoinColumn(nullable = false)
    private Product product; // 상품 번호

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private User user; // 유저 번호

    @Column()
    private Integer quantity = 0; // 상품 수량
//    @Column()
//    private Integer price = 0; // 상품 가격
}
