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
public class Course {
	
	@Id
	private String cid;
	
	private String cname;
	private String lecturer;
	
}
