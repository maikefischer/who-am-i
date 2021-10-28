package com.who.am.i.game.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTO {

    private String playerName;

    private String countryOfCitizenship;

    private String dateOfBirth;

    private String position;

    private String club;
}
