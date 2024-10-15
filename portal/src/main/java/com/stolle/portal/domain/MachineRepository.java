package com.stolle.portal.domain;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

/*Spring Data REST finds all public repositories from the application and creates RESTful web services for your entities automatically.
 * We have MachineRepository and CustomerRepository, therefore spring data rest creates restful web services automatically for those 
 * repositories.
 */
@RepositoryRestResource
public interface MachineRepository extends CrudRepository <Machine, Long>{
    List<Machine> findByBrand(@Param("brand") String brand);
}
