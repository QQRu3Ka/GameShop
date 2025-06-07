CREATE TABLE Users (
    user_id SERIAL PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    login VARCHAR(50) NOT NULL UNIQUE,
    nickname VARCHAR(50) NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    role varchar(50) not null default 'user',
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    balance integer NOT NULL DEFAULT 0,
    info TEXT
);

CREATE TABLE Games (
    game_id SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    rating DECIMAL(3, 1) CHECK (rating >= 0 AND rating <= 10),
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    developer_id integer NOT NULL,
    price integer CHECK (price >= 0),
    description TEXT,
    release_date DATE,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT unique_game_title_developer UNIQUE (title, developer_id)
);

CREATE TABLE Genres (
    genre_id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE,
    popularity INTEGER DEFAULT 0 CHECK (popularity >= 0)
);

CREATE TABLE GameGenres (
    game_id INTEGER,
    genre_id INTEGER,
    PRIMARY KEY (game_id, genre_id)
);

CREATE TABLE Platforms (
    platform_id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE GamePlatforms (
    game_id INTEGER,
    platform_id INTEGER,
    release_date DATE,
    PRIMARY KEY (game_id, platform_id)
);

CREATE TABLE Developers (
    developer_id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    email VARCHAR(255) UNIQUE,
    description TEXT,
    founded_date DATE,
    revenue integer CHECK (revenue >= 0),
    website VARCHAR(255),
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE Games
ADD COLUMN purchase_count INTEGER NOT NULL DEFAULT 0;

ALTER TABLE Games
ADD COLUMN version VARCHAR(20) DEFAULT '1.0.0';

CREATE TABLE Comments (
    comment_id SERIAL PRIMARY KEY,
    game_id INTEGER NOT NULL,
    user_id INTEGER NOT NULL,
    rating SMALLINT CHECK (rating BETWEEN 0 AND 10),
    comment_text TEXT NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
);

ALTER TABLE Developers
ADD COLUMN user_id INTEGER NOT NULL;

CREATE TABLE UserLibrary (
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    game_id INTEGER NOT NULL,
    purchase_date TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_played TIMESTAMP WITH TIME ZONE,
    playtime_seconds BIGINT DEFAULT 0 CHECK (playtime_seconds >= 0),
    is_installed BOOLEAN DEFAULT FALSE,
    CONSTRAINT unique_user_game UNIQUE (user_id, game_id)
);

CREATE TABLE UserWishlist (
    wishlist_id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    game_id INTEGER NOT NULL,
    added_date TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT unique_user_wishlist_item UNIQUE (user_id, game_id)
);

CREATE TABLE UserCart (
    cart_id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    game_id INTEGER NOT NULL,
    added_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    expires_at TIMESTAMP WITH TIME ZONE DEFAULT (CURRENT_TIMESTAMP + INTERVAL '10 minutes'),
    CONSTRAINT unique_user_cart_item UNIQUE (user_id, game_id)
);

ALTER TABLE Games
ALTER COLUMN description SET DEFAULT '';

ALTER TABLE Developers DROP COLUMN created_at;

ALTER TABLE Comments
ADD CONSTRAINT fk_comments_game
FOREIGN KEY (game_id)
REFERENCES Games(game_id)
ON DELETE CASCADE;

ALTER TABLE Comments
ADD CONSTRAINT fk_comments_user
FOREIGN KEY (user_id)
REFERENCES Users(user_id)
ON DELETE CASCADE;

ALTER TABLE Games
ALTER COLUMN is_active SET DEFAULT FALSE;

ALTER TABLE Games
ADD COLUMN storage_name VARCHAR(255);