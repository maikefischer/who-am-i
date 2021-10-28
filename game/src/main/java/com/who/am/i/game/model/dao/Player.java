package com.who.am.i.game.model.dao;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "players")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    @Id
    @Column(name = "player_id")
    private int playerId;

    @NotNull
    @Column(name = "current_club_id")
    private int currentClubId;

    @NotNull
    @Column(name = "pretty_name")
    private String prettyName;

    @Column(name = "country_of_citizenship")
    private String countryOfCitizenship;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    private String position;

    @OneToOne
    @JoinColumn(name = "current_club_id", insertable = false, updatable = false)
    private Club club;

    @OneToMany
    @JoinColumn(name = "player_id")
    private List<Appearance> appearanceList;
}
