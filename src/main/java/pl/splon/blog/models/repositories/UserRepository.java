package pl.splon.blog.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.splon.blog.models.UserModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Integer> {
    List<UserModel> findByAgeGreaterThanAndLoginLike(int a, String login);
    Optional<UserModel> findByLoginAndPassword(String login, String password);
    boolean existsByLoginAndPassword(String login, String password);
    boolean existsByLogin(String login);

}
