package com.example.LearningPortal.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LearningPortal.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	//	public User save(User user) {
	//		// TODO Auto-generated method stub
	//		return null;
	//	}
	//
	//	public Object findById(long userId) {
	//		// TODO Auto-generated method stub
	//		return null;
	//	}

}

/**
 * @Mapper
 * public interface MapStructMapper extends .... {
 *  	public User userFromUserDto(UserDto userDto);
 *  	public UserDto userDtoFromUser(User user);
 *  }
 *  
 *  
 *  UserDto userDto; // post req create new user
 *  
 *  User user = mapStructMapper.userFromUserDto(userDto);
 *  userRepository.save(user);
 *  
 *  // localhost:8080/user/id	//method is get
 *  
 *  // get req getUser(id)
 *  
 *  id
 *  
 *  userReposity.findById(id);
 *  
*/
