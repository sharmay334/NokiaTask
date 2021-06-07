package com.nokia.nokiamain.service;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nokia.nokiamain.exception.NokiaException;
import com.nokia.nokiamain.model.User;
import com.nokia.nokiamain.pojo.UserCreatePojo;
import com.nokia.nokiamain.pojo.UserUpdatePojo;
import com.nokia.nokiamain.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public User createUser(@Valid UserCreatePojo userPojo) {
		User user = new User(userPojo.getId(), userPojo.getName(), Long.valueOf(userPojo.getPhone()),
				userPojo.getEmail(), userPojo.getAddress(), userPojo.getCountry(), userPojo.getDepartment());
		return userRepository.save(user);
	}

	@Transactional
	public Object updateUser(@Valid UserUpdatePojo userPojo) {

		if (userRepository.findUserById(userPojo.getId()) != null) {

			User user = new User(userPojo.getId(), userPojo.getName(), Long.valueOf(userPojo.getPhone()),
					userPojo.getEmail(), userPojo.getAddress(), userPojo.getCountry(), userPojo.getDepartment());

			return userRepository.save(user);

		}

		throw new NokiaException("User not found");
	}

	@Transactional
	public Object deleteUser(Long id) {
		userRepository.deleteById(id);
		return null;
	}

}
