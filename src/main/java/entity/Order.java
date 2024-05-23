package entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	// 주문번호 
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;	// 유저번호
	
	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;	// 상품번호

	@CreationTimestamp
	@Column(name = "ordered_date")
	private LocalDate orderedDate;		// 구매일자
	
	@Column(name = "quantity")
	private Integer quantity = 0;	// 주문 수량
	
}
