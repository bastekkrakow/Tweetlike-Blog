package pl.splon.blog.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.splon.blog.models.PostModel;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<PostModel, Integer> {
    List<PostModel> findAllByUserIdOrderByIdDesc(int userId);
    List<PostModel> findAllByOrderByIdDesc();
}
