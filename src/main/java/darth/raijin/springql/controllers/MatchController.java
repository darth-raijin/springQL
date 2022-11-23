package darth.raijin.springql.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import darth.raijin.springql.models.records.MatchRecord;
import darth.raijin.springql.models.records.PlayerRecord;
import darth.raijin.springql.services.MatchService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/match")
public class MatchController {
    @Autowired private MatchService matchService;

    /**
     * 
     * @param player takes a PlayerRecord which is used to add to player list for a
     *               given match
     * @return Returns a ResponseEntity which describes the result of the operation
     */
    @PostMapping("/player")
    public ResponseEntity<MatchRecord> addPlayer(@Validated @RequestBody PlayerRecord player, MatchRecord match) {
        return ResponseEntity
                .created(null)
                .body(matchService.addPlayerToMatch(player.createEntity(), match.createEntity()));
    }

    /**
     * 
     * @param matchRecord creates a Match based on given values
     * @return Returns a ResponseEntity which describes the result of the operation
     */
    @PostMapping("/")
    public ResponseEntity<MatchRecord> createMatch() {
        return ResponseEntity
                .created(null)
                .body(matchService.createMatch());
    }

}
