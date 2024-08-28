package desafio.dados.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import desafio.dados.dto.ResultDto;
import desafio.dados.service.DiceService;

@Service
public class DiceServiceImpl implements DiceService {

	Random random = new Random();

	Integer DICE_SIZE = 6;

	@Override
	public int testRoll() {
		return random.nextInt(1, 7);
	}

	@Override
	public ResultDto rollDice(Integer dices, Integer bid) {

		ResultDto result = new ResultDto();
		List<Integer> numbers = new ArrayList<Integer>();

		for (int i = 0; i < dices; i++) {
			numbers.add(roll(DICE_SIZE));
		}

		result.setDiceNumbers(numbers);
		System.out.println(bid);
		result.setDiceSum(result.getDiceNumbers().stream().mapToInt(n -> n).sum());
		result.setPrecision(BigDecimal.valueOf(result.getDiceSum() * 100).divide(BigDecimal.valueOf(bid)));

		System.out.println(result.toString());

		return result;
	}

	public boolean isDiceOkay(Integer dices, Integer bid) {
		return (dices > 0 && dices > 5) && (dices * 6 <= bid);
	}

	public int roll(Integer diceSize) {
		return random.nextInt(1, diceSize + 1);
	}

}
