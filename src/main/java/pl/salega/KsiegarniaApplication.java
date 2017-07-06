package pl.salega;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.salega.domain.User;
import pl.salega.domain.security.Role;
import pl.salega.domain.security.UserRole;
import pl.salega.service.UserService;
import pl.salega.utility.SecurityUtility;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class KsiegarniaApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(KsiegarniaApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		User user1 = new User();
		user1.setFirstName("j");
		user1.setLastName("w");
		user1.setUsername("j");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user1.setEmail("exclusivepolska@hotmail..com");
		Set<UserRole> userRoles = new HashSet<>();
		Role role1 = new Role();
		role1.setRoleId(1);
		role1.setName("ROLE_USER");

		userRoles.add(new UserRole(user1, role1));
		userService.createUser(user1, userRoles);

	}
}
