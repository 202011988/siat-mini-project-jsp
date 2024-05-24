package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sellers")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Seller {

	@Id
	@Column(name = "registration_number")
	private Integer registrationNumber;	// 사업자 등록번호

	@Column(name = "seller_name", length = 50)
	private String sellerName;	// 사업자 이름

	@Column(name = "store_name", length = 50, nullable = false)
	private String storeName;	// 상호명

	@Column(length = 50, nullable = false)
	private String password;	// 비밀번호

	@Column
	private Integer total; 		// 매출액
}
