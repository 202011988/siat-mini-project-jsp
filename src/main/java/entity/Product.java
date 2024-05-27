package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	// 번호 
	
	@ManyToOne
	@JoinColumn(name = "registration_number")
	private Seller seller;	// 판매자 번호
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category category;	// 카테고리 번호
	
	@Column(name = "price")
	private Integer price = 0;		// 가격
	
	@Column(name = "description", columnDefinition = "TEXT")
	private String description;	// 상품 설명 
	
	@Column(name = "stock")
	private Integer stock; // 재고
	
	@Column(name = "name", length = 50, nullable = false)
	private String name; // 상품 이름
}
