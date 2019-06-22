package com.pig.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService service;

	@GetMapping("users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}

	@GetMapping("users/{id}")
	public User retrieveUser(@PathVariable int id) {
		User user = service.findOne(id);
		if(user==null){
			throw new UserNotFoundException("id-"+id);
		}
		return user;
	}
	
	@DeleteMapping("users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = service.deleteById(id);
		if(user==null){
			throw new UserNotFoundException("id-"+id);
		}
	}

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		User saveUser = service.save(user);

		//1.利用ServletUriComponentsBuilder.fromCurrentRequest()拿到目前的uri
		//2.串上/{id}
		//3.id內容為saveUser.getId()
		//4.轉換為URI
		//5.由以上取得對應GET Method的/users/{id}的uri網址並放在location參數內
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(saveUser.getId()).toUri();
		
		//1.用spring的ResponseEntity拿到Response本體，並把我們想吐回去的url(i.e. location)放進去
		//2.改寫本方法回傳void改為ResponseEntity<Object>
		return ResponseEntity.created(location).build();
		

	}
}