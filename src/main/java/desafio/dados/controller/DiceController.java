package desafio.dados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafio.dados.dto.DiceDto;
import desafio.dados.dto.ResultDto;
import desafio.dados.service.DiceService;

@RestController
@RequestMapping
public class DiceController {
	
	@Autowired
	private DiceService diceService;
	
	@PostMapping("/play")
	public ResultDto e(@RequestBody DiceDto dice) {
		return diceService.rollDice(dice.getDices(), dice.getBid());
	}
	
	@GetMapping("/test")
	public int roll() {
		return diceService.testRoll();
	}
	

}
