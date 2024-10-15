package com.stolle.portal.domain;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**/
@RepositoryRestResource(exported = false)//does not allow for end point to be reached
public interface UserRepository extends CrudRepository<User,Long>{
	/*findByUsername used to find user from the database in the authentication process, method returns optional to avoid a exception*/
	Optional<User> findByUsername(String username);
}
