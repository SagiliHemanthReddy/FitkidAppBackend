package in.dackend.fitapp.repository;

import in.dackend.fitapp.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
//    User findByUsrName(String usrName);
	
}
