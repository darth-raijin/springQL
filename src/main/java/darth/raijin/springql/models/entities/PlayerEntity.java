package darth.raijin.springql.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import darth.raijin.springql.models.enums.SkillEnum;
import darth.raijin.springql.models.records.PlayerRecord;

@Entity
@Table(name = "players", indexes = {
        @Index(name = "skill_index", columnList = "skill"),
        @Index(name = "geography_index", columnList = "geography")
})
public class PlayerEntity {

    public PlayerEntity() {}

    public PlayerEntity(Long id, @NotNull SkillEnum level, String name, @NotNull String geography) {
        this.id = id;
        this.level = level;
        this.name = name;
        this.geography = geography;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "player_id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @Column(name = "skill")
    private SkillEnum level;

    public SkillEnum getLevel() {
        return level;
    }

    public void setLevel(SkillEnum level) {
        this.level = level;
    }

    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @Column(name = "geography")
    private String geography;

    public String getGeography() {
        return geography;
    }

    public void setGeography(String geography) {
        this.geography = geography;
    }

    @ManyToMany(mappedBy = "players")
    private List<MatchEntity> matches;

    public PlayerRecord createDTO() {
        return new PlayerRecord(this.id, this.level, this.name, this.geography);
    }

    public static ArrayList<PlayerRecord> createDTOs(List<PlayerEntity> players) {
        ArrayList<PlayerRecord> records = new ArrayList<PlayerRecord>();

        for (PlayerEntity player : players) {
            records.add(player.createDTO());
        }
        return records;
    }

}
