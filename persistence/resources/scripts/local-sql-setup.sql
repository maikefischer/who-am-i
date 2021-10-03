CREATE TABLE players (
    player_id int NOT NULL PRIMARY KEY,
    current_club_id int NOT NULL, 
    pretty_name VARCHAR(255) NOT NULL, 
    country_of_citizenship VARCHAR(255),
    date_of_birth VARCHAR(255),
    position VARCHAR(255),
);


BULK INSERT players
    FROM '/tmp/data/players.csv'
    WITH
    (
    FIRSTROW = 2,
    FIELDTERMINATOR = ';',
    ROWTERMINATOR = '\n',
    TABLOCK
);

CREATE TABLE clubs (
    club_id int NOT NULL PRIMARY KEY,
    pretty_name VARCHAR(255)
);


BULK INSERT clubs
    FROM '/tmp/data/clubs.csv'
    WITH
    (
    FIRSTROW = 2,
    FIELDTERMINATOR = ';',
    ROWTERMINATOR = '\n',
    TABLOCK
);

CREATE TABLE appearances (
    player_id int NOT NULL,
    game_id int NOT NULL,
    appearance_id VARCHAR(255) NOT NULL PRIMARY KEY,
    player_club_id int,
    goals int,
    assists int, 
    yellow_cards int,
    red_cards int
);


BULK INSERT appearances
    FROM '/tmp/data/appearances.csv'
    WITH
    (
    FIRSTROW = 2,
    FIELDTERMINATOR = ';',
    ROWTERMINATOR = '\n',
    TABLOCK
);


CREATE TABLE games (
    game_id int NOT NULL PRIMARY KEY,
    season int
);


BULK INSERT games
    FROM '/tmp/data/games.csv'
    WITH
    (
    FIRSTROW = 2,
    FIELDTERMINATOR = ';',
    ROWTERMINATOR = '\n',
    TABLOCK
);
