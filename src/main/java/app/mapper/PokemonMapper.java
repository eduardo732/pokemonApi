package app.mapper;

import app.entity.Pokemon;
import app.vo.GetPokemonsVO;

import java.util.ArrayList;
import java.util.List;

public class PokemonMapper {

    public static List<GetPokemonsVO> mapperPokemon(
            List<Pokemon> pokemons
    ) {
        List<GetPokemonsVO> getPokemonsVO = new ArrayList<>();

        pokemons.forEach(value -> {
                getPokemonsVO.add(GetPokemonsVO.builder()
                        .name(value.getName())
                        .damage(value.getDamage().toString())
                        .build());
        });
        return getPokemonsVO;
    }


}
