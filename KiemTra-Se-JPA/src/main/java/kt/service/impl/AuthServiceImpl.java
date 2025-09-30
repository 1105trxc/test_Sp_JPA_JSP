package kt.service.impl;


import kt.entity.User;
import kt.repsitory.UserRepository;
import kt.service.AuthService;

public class AuthServiceImpl implements AuthService {
	  private final UserRepository userRepo = new UserRepository();

	  @Override
	  public User login(String username, String password) {
	    User u = userRepo.findByUsername(username);
	    if (u != null && u.getPassword().equals(password)) {
	      return u;
	    }
	    return null;
	  }

	  @Override
	  public User register(String username, String email, String fullname, String password) {
	    if (userRepo.findByUsername(username) != null) return null;
	    User u = new User();
	    u.setUsername(username);
	    u.setEmail(email);
	    u.setFullname(fullname);
	    u.setPassword(password); // Demo: chưa mã hoá
	    return userRepo.save(u);
	  }
	}