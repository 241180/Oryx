package crud.backend;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Empty JpaRepository is enough for a simple ui.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

    /* A version to fetch List instead of Page to avoid extra count query. */
    List<Person> findAllBy(Pageable pageable);

    List<Person> findByNameLikeIgnoreCase(String nameFilter);

    // For lazy loading and filtering
    List<Person> findByNameLikeIgnoreCase(String nameFilter, Pageable pageable);

    long countByNameLike(String nameFilter);

}
