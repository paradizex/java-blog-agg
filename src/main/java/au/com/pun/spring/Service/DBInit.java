package au.com.pun.spring.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import au.com.pun.spring.entity.Blog;
import au.com.pun.spring.entity.Item;
import au.com.pun.spring.entity.Role;
import au.com.pun.spring.entity.User;
import au.com.pun.spring.repository.BlogRepository;
import au.com.pun.spring.repository.ItemRepository;
import au.com.pun.spring.repository.RoleRepository;
import au.com.pun.spring.repository.UserRepository;

@Service
public class DBInit {
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BlogRepository blogRepo;
	
	@Autowired
	private ItemRepository itemRepo;
	
	@PostConstruct
	public void init(){
		
		Role userRole = new Role();
		userRole.setName("ROLE_USER");
		roleRepo.save(userRole);
		
		Role adminRole = new Role();
		adminRole.setName("ROLE_ADMIN");
		roleRepo.save(adminRole);
		
		User user = new User();
		user.setName("admin");
		List<Role> roles=new ArrayList<Role>();
		roles.add(adminRole);
		roles.add(userRole);		
		user.setRoles(roles);
		user.setEmail("admin@local.com");
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
		user.setPassword(encoder.encode("admin"));
		userRepo.save(user);
		
		User user1 = new User();
		user1.setName("user1");
		List<Role> roles1=new ArrayList<Role>();
		roles1.add(userRole);		
		user1.setRoles(roles1);
		user1.setEmail("user1@local.com");
		user1.setPassword(encoder.encode("user1"));
		userRepo.save(user1);
		
		Blog blog = new Blog();
		blog.setName("JBA Blog");
		blog.setUrl("http://myblog");
		blog.setUser(user);
		blogRepo.save(blog);
		
		Item item1=new Item();
		item1.setTitle("Java Vids");
		item1.setLink("myLink");
		item1.setPublishedDate(new Date());
		item1.setBlog(blog);
		itemRepo.save(item1);
		
		Item item2=new Item();
		item2.setTitle("Java tuts");
		item2.setLink("myLink new");
		item2.setPublishedDate(new Date());
		item2.setBlog(blog);
		itemRepo.save(item2);
	}

}
