package com.who.am.i.game.exception;

public class PlayerNotFoundException extends Exception {

    private String errorMessage;

    public PlayerNotFoundException(){
        this.errorMessage = "There was no player data found in the database";
    }

}
