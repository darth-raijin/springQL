package darth.raijin.springql.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import darth.raijin.springql.models.entities.PlayerEntity;
import darth.raijin.springql.models.enums.SkillEnum;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {

    ArrayList<PlayerEntity> findAllByLevel(SkillEnum level);

    ArrayList<PlayerEntity> findAllByGeography(String geography);
}
