package pl.kmo2008.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kmo2008.demo.Model.Categories;

/**
 * Repository of Categories Model.
 */
@Repository
public interface CategoriesRepository extends JpaRepository<Categories,Integer> {
}
