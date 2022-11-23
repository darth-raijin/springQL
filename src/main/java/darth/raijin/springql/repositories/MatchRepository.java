package darth.raijin.springql.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import darth.raijin.springql.models.entities.MatchEntity;

@Repository
public interface MatchRepository extends JpaRepository<MatchEntity, Long> {

    Optional<MatchEntity> findById(Long id);

}
