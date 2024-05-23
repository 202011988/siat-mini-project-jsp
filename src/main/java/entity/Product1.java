package entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@Entity
@NoArgsConstructor
@Getter
@ToString
@Inheritance(strategy = InheritanceType.JOINED) // JOINED, SINGLE_TABLE
@DiscriminatorColumn(name = "ptype")
public abstract class Product1 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prod_id")
	private Long id;
	
	private String name;
	private Integer price;
	
	public Product1(String name, Integer price) {
		this.name = name;
		this.price = price;
	}
	
}
