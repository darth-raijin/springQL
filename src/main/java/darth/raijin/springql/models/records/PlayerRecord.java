package darth.raijin.springql.models.records;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import darth.raijin.springql.models.entities.PlayerEntity;
import darth.raijin.springql.models.enums.SkillEnum;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude()
public class PlayerRecord {

    public PlayerRecord(@JsonProperty("id") Long id, @JsonProperty("level") SkillEnum level, @JsonProperty("name")  String name, @JsonProperty("geography") String geography) {
        this.id = id;
        this.level = level;
        this.name = name;
        this.geography = geography;
    }

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    private SkillEnum level;

    public SkillEnum getLevel() {
        return level;
    }

    public void setLevel(SkillEnum level) {
        this.level = level;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    private String geography;

    public String getGeography() {
        return geography;
    }

    public void setGeography(String geography) {
        this.geography = geography;
    }

    public PlayerEntity createEntity() {
        return new PlayerEntity(this.id, this.level, this.name, this.geography);
    }
    
}
