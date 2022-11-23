package darth.raijin.springql.models.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import darth.raijin.springql.models.records.MatchRecord;

@Entity
@Table(name = "matches")
public class MatchEntity {

    public MatchEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "match_id")
    Long id;

    public Long getId() {
        return id;
    }

    @ManyToMany
    @JoinTable(name = "matches_players", indexes = {
            @Index(name = "player_index", columnList = "player_id"),
            @Index(name = "match_index", columnList = "match_id")
    },
    joinColumns = {@JoinColumn(name = "match_id")},
    inverseJoinColumns = {@JoinColumn(name = "player_id")}
    )
    List<PlayerEntity> players;

    public MatchEntity(Long id, List<PlayerEntity> players) {
        this.id = id;
        this.players = players;
    }

    public List<PlayerEntity> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerEntity> players) {
        this.players = players;
    }

    public List<PlayerEntity> addPlayer(PlayerEntity player) {
        this.players.add(player);
        return players;
    }

    public void setId(Long id2) {
        this.id = id2;
    }

    public MatchRecord createDto() {
        return new MatchRecord(this.id, PlayerEntity.createDTOs(this.players));
    }

}
