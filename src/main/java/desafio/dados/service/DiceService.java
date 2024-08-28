package desafio.dados.service;

import desafio.dados.dto.ResultDto;

public interface DiceService {

	ResultDto rollDice(Integer dices, Integer bid);

	int testRoll();

}
