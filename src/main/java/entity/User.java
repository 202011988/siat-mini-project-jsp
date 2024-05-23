package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	// 번호 
	
	@Column()
	private String username;	// 유저 아이디
	@Column()
	private String password;	// 유저 비밀번호
	@Column()
	private String address;		// 유저 주소
	@Column()
	private String nickname;	// 유저 닉네임
}
