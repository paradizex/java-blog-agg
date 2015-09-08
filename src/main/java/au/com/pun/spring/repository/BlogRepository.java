package au.com.pun.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.pun.spring.entity.Blog;
import au.com.pun.spring.entity.User;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

	List<Blog> findByUser(User user);
}
