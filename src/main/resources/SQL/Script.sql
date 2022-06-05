CREATE DATABASE DBBPokemonApi;

CREATE TABLE DBBPokemonApi.Pokemon (
	Id INT auto_increment NOT NULL PRIMARY KEY,
	Nombre varchar(100) NOT NULL,
	Elemento varchar(100) NOT NULL,
	Daño INT NOT NULL,
	Fecha DATETIME DEFAULT CURRENT_TIMESTAMP NULL
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

Insert into DBBPokemonApi.Pokemon(Nombre, Elemento, Daño) values ("Charmander", "Fuego", 68);
Insert into DBBPokemonApi.Pokemon(Nombre, Elemento, Daño) values ("Aquaman", "Agua", 47);
Insert into DBBPokemonApi.Pokemon(Nombre, Elemento, Daño) values ("Heos", "Viento", 48);
Insert into DBBPokemonApi.Pokemon(Nombre, Elemento, Daño) values ("Terra", "Tierra", 55);
Insert into DBBPokemonApi.Pokemon(Nombre, Elemento, Daño) values ("Faia", "Fuego", 48);
Insert into DBBPokemonApi.Pokemon(Nombre, Elemento, Daño) values ("Nombre3", "Viento", 68);
Insert into DBBPokemonApi.Pokemon(Nombre, Elemento, Daño) values ("Agua5", "Agua", 48);
Insert into DBBPokemonApi.Pokemon(Nombre, Elemento, Daño) values ("Tierra", "Tierra", 58);
Insert into DBBPokemonApi.Pokemon(Nombre, Elemento, Daño) values ("Winter", "Hielo", 88);
Insert into DBBPokemonApi.Pokemon(Nombre, Elemento, Daño) values ("Spring", "Fuego", 98);