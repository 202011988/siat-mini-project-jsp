package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Seller {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	// 번호 
	
	@Column(length = 50, nullable = false)
	private String sellerName;	// 사업자 이름
	@Column(length = 50, nullable = false)
	private String storeName;	// 상호명
	@Column(length = 50, nullable = false)
	private String password;	// 비밀번호
	@Column()
	private Integer registrationNumber;	// 사업자 등록번호
	@Column()
	private Integer total; // 매출액
}
