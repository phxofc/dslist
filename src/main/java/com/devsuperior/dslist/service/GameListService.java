package com.devsuperior.dslist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List <GameList> result = gameListRepository.findAll();
		//stream permite fazer operaççoes com sequencia de dados
		return  result.stream().map(x -> new GameListDTO(x)).toList();

	}
	

}
