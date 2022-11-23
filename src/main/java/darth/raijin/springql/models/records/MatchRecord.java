package darth.raijin.springql.models.records;

import java.util.List;

import darth.raijin.springql.models.entities.MatchEntity;

public class MatchRecord {

    public MatchRecord(Long id, List<PlayerRecord> players) {
        this.id = id;
        this.players = players;
    }

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private List<PlayerRecord> players;
    

    public List<PlayerRecord> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerRecord> players) {
        this.players = players;
    }

    /**
     * Creates an entity from a DTO
     * Only ID is handled
     * @param matchRecord
     * @return
     */
    public MatchEntity createEntity() {   
        return new MatchEntity(this.id, null);   
    }
}
