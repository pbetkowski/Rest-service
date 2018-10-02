package mainPackage.service;


import mainPackage.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    void deleteById(Integer id);
}
