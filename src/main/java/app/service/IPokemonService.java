package app.service;

import app.vo.GetPokemonsVO;

import java.util.List;

public interface IPokemonService {
    List<GetPokemonsVO> getPokemons();
}
