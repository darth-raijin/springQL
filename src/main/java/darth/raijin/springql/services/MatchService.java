package darth.raijin.springql.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import darth.raijin.springql.controllers.exceptions.MatchNotFoundException;
import darth.raijin.springql.models.entities.MatchEntity;
import darth.raijin.springql.models.entities.PlayerEntity;
import darth.raijin.springql.models.records.MatchRecord;
import darth.raijin.springql.repositories.MatchRepository;

@Service
public class MatchService {
    @Autowired private MatchRepository matchRepository;

    public MatchRecord addPlayerToMatch(PlayerEntity player, MatchEntity matchEntity) {

        if (!matchRepository.findById(matchEntity.getId()).isPresent()) {
            // Validating the match exists
            throw new MatchNotFoundException(matchEntity.getId());
        }

        matchEntity.addPlayer(player);

        matchRepository.save(matchEntity);

        return matchEntity.createDto();
      
    }

    public MatchRecord createMatch() {
        return matchRepository.save(new MatchEntity()).createDto();
    }
}
