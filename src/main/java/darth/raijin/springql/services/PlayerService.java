package darth.raijin.springql.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import darth.raijin.springql.models.entities.PlayerEntity;
import darth.raijin.springql.models.enums.SkillEnum;
import darth.raijin.springql.models.records.PlayerRecord;
import darth.raijin.springql.repositories.PlayerRepository;

@Service
public class PlayerService {
    @Autowired private PlayerRepository playerRepository;

    public PlayerRecord createPlayer(PlayerEntity player) {
        return playerRepository.save(player).createDTO();
    }

    public ArrayList<PlayerEntity> getPlayersBySkill(SkillEnum skill) {
        return playerRepository.findAllByLevel(skill);
    }
}
