package au.com.pun.spring.Service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.com.pun.spring.entity.Blog;
import au.com.pun.spring.entity.Role;
import au.com.pun.spring.entity.User;
import au.com.pun.spring.repository.BlogRepository;
import au.com.pun.spring.repository.ItemRepository;
import au.com.pun.spring.repository.RoleRepository;
import au.com.pun.spring.repository.UserRepository;

@Service
@Transactional 
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BlogRepository blogRepo;
	
	@Autowired
	private ItemRepository itemRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@PostConstruct
	public List<User> findAll(){
		return userRepo.findAll();
	}

	public User findOne(int id) {
		
		
		return userRepo.findOne(id);
	}
	
	@Transactional
	public User findOneWithBlog(int id) {
		User user = findOne(id);
		List<Blog> blogs = blogRepo.findByUser(user);
		for (Blog blog : blogs) {
			blog.setItems(itemRepo.findByBlog(blog, new PageRequest(0, 10, Direction.DESC, "publishedDate")));
		}
		user.setBlogs(blogs);
		return user;
	}

	public void save(User user) {
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		user.setEnabled(true);
		user.setPassword(encoder.encode(user.getPassword()));
		
		List<Role> roles=new ArrayList<Role>();
		roles.add(roleRepo.findByName("ROLE_USER"));
		user.setRoles(roles);
		userRepo.save(user);
	}
}
