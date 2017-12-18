package pl.kmo2008.demo.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kmo2008.demo.Model.Food;

/**
 * Repository for Food Model.
 */
@Repository
public interface FoodRepository extends JpaRepository<Food,Integer> {
}
