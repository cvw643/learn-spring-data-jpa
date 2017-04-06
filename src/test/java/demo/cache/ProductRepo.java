package demo.cache;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;

/**
 * @author YQ.Huang
 */
@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    @Query("select p from Product p where id=?1")
    @QueryHints({@QueryHint(name = "javax.persistence.cache.retrieveMode", value = "USE")})
    Product findOneCached(Integer id);
}
