package au.com.pun.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.pun.spring.entity.Role;
import au.com.pun.spring.entity.User;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
