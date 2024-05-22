package base.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@ToString
public abstract class BaseEntity {
	
	@Column(name = "created_date")
	private LocalDateTime createdDate;
	
	@Column(name = "last_modified_date")
	private LocalDateTime lastModifiedDate;

}
