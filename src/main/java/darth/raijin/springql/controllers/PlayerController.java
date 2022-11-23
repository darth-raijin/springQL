package darth.raijin.springql.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import darth.raijin.springql.models.records.PlayerRecord;
import darth.raijin.springql.services.PlayerService;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired PlayerService playerService;

    @PostMapping("/")
    public ResponseEntity<PlayerRecord> addPlayer(@RequestBody PlayerRecord player) {
        return ResponseEntity
                .created(null)
                .body(playerService.createPlayer(player.createEntity()));
    }
}
