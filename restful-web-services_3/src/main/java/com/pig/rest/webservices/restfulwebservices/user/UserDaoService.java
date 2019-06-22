package com.pig.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();

	private int usersCount = 3;

	static {
		users.add(new User(1, "Pig", new Date()));
		users.add(new User(2, "Hog", new Date()));
		users.add(new User(3, "Royal Hog", new Date()));
	}

	// public List<User> findAll()
	public List<User> findAll() {
		return users;
	}

	// public User save(User user)
	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}

	// public User findOne(int id)
	public User findOne(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				System.out.println("user="+user);
				return user;
			}
		}
		return null;
	}
	
	public User deleteById(int id) {
		Iterator<User> iterator = users.iterator();//迭代器
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
}