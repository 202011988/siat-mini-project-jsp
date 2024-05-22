package entity;

import jakarta.persistence.DiscriminatorValue;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@Entity
@NoArgsConstructor
@Getter
@ToString
@DiscriminatorValue(value = "album")
public class Album extends Product {
	private String artist;

}
