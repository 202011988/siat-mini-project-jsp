package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	// 번호 
	
	@ManyToOne
	@JoinColumn()
	private Seller seller;	// 판매자 번호
	
	@ManyToOne
	private Category category;	// 카테고리 번호
	
	@Column()
	private Integer price;		// 가격
	
	@Column()
	private String description;	// 설명 
	
	@Column()
	private Integer stock; // 재고
	
	@Column()
	private String name; // 이름
}
