package com.jsL.memo.user.service;

import org.springframework.stereotype.Service;

import com.jsL.memo.user.common.MD5HashingEncoder;
import com.jsL.memo.user.repository.UserRepository;

@Service
public class UserService {
	
	//수정되지 못함
	private final UserRepository userRepository;
	
	//다른 생성자가 없이 autowired를 위한 생성자가 있는 경우는 @Autowired 생략 가능
//	@Autowired//사용성을 넓히기 위해서 
	public UserService(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	
	
	
	public boolean addUser(
			String loginId
			,String password
			,String name
			,String email
			){
		//static에 의해 객체생성 없이 가능
		String encyptPassword = MD5HashingEncoder.encode(password);
		
		int count = userRepository.insertUser(loginId, encyptPassword, name, email);
		
		if(count > 0) {
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
