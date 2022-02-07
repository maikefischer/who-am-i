package com.who.am.i.game.controller;

import com.who.am.i.game.model.dao.Player;
import com.who.am.i.game.model.dto.PlayerDTO;
import com.who.am.i.game.service.PlayerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @Qualifier("dtoMapper")
    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/player")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public PlayerDTO getPlayer() {
        return convertToDto(playerService.getRandomPlayer());
    }

    private PlayerDTO convertToDto(Player player) {
        return modelMapper.map(player, PlayerDTO.class);
    }

}
