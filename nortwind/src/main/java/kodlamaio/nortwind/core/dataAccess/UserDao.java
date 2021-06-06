package kodlamaio.nortwind.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.nortwind.core.entites.User;

public interface UserDao extends JpaRepository<User, Integer>{
	User findByEmail(String email);
}
