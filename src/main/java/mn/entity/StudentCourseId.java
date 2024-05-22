package mn.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Embeddable
@AllArgsConstructor
public class StudentCourseId implements Serializable {
	@Column(name = "sid")
	private String student;
	
	@Column(name = "cid")
	private String course;
}
