package com.who.am.i.game.service;

import com.who.am.i.game.exception.PlayerNotFoundException;
import com.who.am.i.game.model.dao.Player;
import com.who.am.i.game.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public Player getRandomPlayer() throws PlayerNotFoundException {
        long totalPlayers = playerRepository.count();
        int index = (int)(Math.random() * totalPlayers);
        Page<Player> playerPage = playerRepository.findAll(PageRequest.of(index, 1));
        if (playerPage.hasContent()) {
            return playerPage.getContent().get(0);
        } else {
            throw new PlayerNotFoundException();
        }
    }


}
