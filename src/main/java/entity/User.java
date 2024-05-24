package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;			// 번호
	
	@Column(length = 50, nullable = false)
	private String userid;	// 유저 아이디

	@Column(length = 50, nullable = false)
	private String password;	// 유저 비밀번호

	@Column(length = 100, nullable = false)
	private String address;		// 유저 주소

	@Column(length = 50, nullable = false)
	private String nickname;	// 유저 닉네임
}
