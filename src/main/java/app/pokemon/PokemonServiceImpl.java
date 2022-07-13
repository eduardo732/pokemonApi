package app.pokemon;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonServiceImpl implements IPokemonService {


    private final PokemonRepository pokemonRepository;

    public PokemonServiceImpl(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public List<GetPokemonsVO> getPokemons() {
        return
                PokemonMapper.mapperPokemon(pokemonRepository.findAll());
    }
}
