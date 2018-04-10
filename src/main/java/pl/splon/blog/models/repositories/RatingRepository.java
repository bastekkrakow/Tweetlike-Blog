package pl.splon.blog.models.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.splon.blog.models.RatingModel;

@Repository
public interface RatingRepository extends CrudRepository<RatingModel, Integer> {
    boolean existsByUserIdAndPostId(int userId, int postId);
}
