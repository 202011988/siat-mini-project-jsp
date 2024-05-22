package mn.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Student {
	
	@Id
	private String sid;
	
	private String sname;
	
}
