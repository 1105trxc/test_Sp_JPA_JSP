package kt.service;

import kt.entity.User;

public interface AuthService {
	  User login(String username, String password);
	  User register(String username, String email, String fullname, String password);
	}