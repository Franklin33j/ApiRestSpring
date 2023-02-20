package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.UserDTO;
import com.example.demo.exceptions.ResourceDuplicatedException;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	@Autowired
	ModelMapper mapper;
	@Override
	public List<UserDTO> GetAllUsers() {
		List<User> users= userRepository.findAll();
		return users.stream().map((user)-> mapper.map(user, UserDTO.class)).collect(Collectors.toList());
	}

	@Override
	public UserDTO FindUserById(Long id) {
		User user= userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("id", Long.toString(id)));
		return mapper.map(user, UserDTO.class);
	}

	@Override
	public UserDTO AddUser(UserDTO user) {
		User userResponse = UserAdded(user);
		return mapper.map(userResponse,UserDTO.class) ;//User user = user
	}

	@Override
	public UserDTO UpdateUser(Long id, UserDTO user) {
		User userExist= userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("id", Long.toString(id)));
		User userResponse= UserUpdated(userExist, user);
		return  mapper.map(userResponse, UserDTO.class);
	}

	@Override
	public UserDTO DeleteUser(Long id) {
		User userExist= userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("id", Long.toString(id)));
		userRepository.delete(userExist);
		return mapper.map(userExist, UserDTO.class);
	}

	private User UserUpdated(User user, UserDTO userDTO)
	{
		User userStatusU= userRepository.findByUsername(userDTO.getUsername());
		User userStatusE= userRepository.findByEmail(userDTO.getEmail());
		
		if(userStatusU!=null)
		{
			if(!user.getId().equals(userStatusU.getId()))
			 {
				 throw new ResourceDuplicatedException("username",userDTO.getUsername());
			 }			 
		}
		if (userStatusE!= null)
		{
			 //actualizar
			 if(!user.getId().equals(userStatusE.getId()))
			 {
				 throw new ResourceDuplicatedException("email",userDTO.getEmail());
			 }
			
		}
		 //si los datos son diferentes a los que esta en base de datos se actualizara
		 if(!userDTO.getEmail().equals(user.getEmail()))
		 {
			 user.setEmail(userDTO.getEmail());
		 }
		 if(user.getUsername()==null|| !userDTO.getUsername().equals(user.getUsername()) )
		 {
			 user.setUsername(userDTO.getUsername());
		 }
			
		 user=ManuallyMapperUser(userDTO,user);
		 
		 return userRepository.save(user);
	}
	
	private User UserAdded(UserDTO userDTO)
	{
		User userStatusU= userRepository.findByUsername(userDTO.getUsername());
		User userStatusE= userRepository.findByEmail(userDTO.getEmail());
		//agregar
			 if(userStatusE !=null ) throw new ResourceDuplicatedException("email",userDTO.getEmail());
			 if(userStatusU !=null ) throw new ResourceDuplicatedException("username",userDTO.getUsername());
			 
			 User userCre= new User();
			 userCre= mapper.map(userDTO, User.class);
			 return userRepository.save(userCre);
	}
	
	private User ManuallyMapperUser(UserDTO userDTO, User user)
	{
	 user.setFirstNames(userDTO.getFirstNames());
	 user.setLastNames(userDTO.getLastNames());
	 user.setAge(userDTO.getAge());
	 user.setPassword(userDTO.getPassword());
	 user.setAddress(userDTO.getAddress());
	 return user;
	}
}
