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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "appearances")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Appearance {

    @Id
    @Column(name = "appearance_id")
    private String appearanceId;

    @NotNull
    @Column(name = "player_id")
    private int playerId;

    @NotNull
    @Column(name = "game_id")
    private int gameId;

    @Column(name = "player_club_id")
    private int playerClubId;

    private int goals;

    private int assists;

    @Column(name = "yellow_cards")
    private int yellowCards;

    @Column(name = "red_cards")
    private int redCards;

    @OneToOne
    @JoinColumn(name = "game_id", insertable = false, updatable = false)
    private Game game;
}
