USE master;

CREATE TABLE players (
    player_id int NOT NULL PRIMARY KEY,
    current_club_id int NOT NULL, 
    pretty_name VARCHAR(255) NOT NULL, 
    country_of_citizenship VARCHAR(255),
    date_of_birth VARCHAR(255),
    position VARCHAR(255),
);

CREATE TABLE clubs (
    club_id int NOT NULL PRIMARY KEY,
    pretty_name VARCHAR(255)
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

CREATE TABLE games (
    game_id int NOT NULL PRIMARY KEY,
    season int
);

BULK INSERT players
    FROM '/usr/work/data/players.csv'
    WITH
    (
    FIRSTROW = 2,
    FIELDTERMINATOR = ';',
    ROWTERMINATOR = '\n',
    TABLOCK
);

BULK INSERT clubs
    FROM '/usr/work/data/clubs.csv'
    WITH
    (
    FIRSTROW = 2,
    FIELDTERMINATOR = ';',
    ROWTERMINATOR = '\n',
    TABLOCK
);

BULK INSERT appearances
    FROM '/usr/work/data/appearances.csv'
    WITH
    (
    FIRSTROW = 2,
    FIELDTERMINATOR = ';',
    ROWTERMINATOR = '\n',
    TABLOCK
);

BULK INSERT games
    FROM '/usr/work/data/games.csv'
    WITH
    (
    FIRSTROW = 2,
    FIELDTERMINATOR = ';',
    ROWTERMINATOR = '\n',
    TABLOCK
);

ALTER TABLE appearances
ADD FOREIGN KEY(player_id) REFERENCES players(player_id);

ALTER TABLE players
ADD FOREIGN KEY(current_club_id) REFERENCES clubs(club_id);

ALTER TABLE appearances
ADD FOREIGN KEY(game_id) REFERENCES games(game_id);