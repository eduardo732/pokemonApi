package app.service.impl;

import app.mapper.PokemonMapper;
import app.repository.PokemonRepository;
import app.service.IPokemonService;
import app.vo.GetPokemonsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonServiceImpl implements IPokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Override
    public List<GetPokemonsVO> getPokemons() {
        return
                PokemonMapper.mapperPokemon(pokemonRepository.findAll());
    }
}
