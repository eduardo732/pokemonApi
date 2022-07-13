package app.pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PokemonMapper {

    public static List<GetPokemonsVO> mapperPokemon(
            List<Pokemon> pokemons
    ) {

        return pokemons.stream().map(pokemon -> {
            return new GetPokemonsVO(pokemon.getName(), pokemon.getDamage().toString());
        }).collect(Collectors.toList());

    }


}
