package entity;

import jakarta.persistence.DiscriminatorValue;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@Entity
@NoArgsConstructor
@Getter
@ToString
@DiscriminatorValue(value = "film")
public class Film extends Product1 {
	private String director;
	private String actor;
	
}
