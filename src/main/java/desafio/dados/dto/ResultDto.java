package desafio.dados.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ResultDto {
	
	List<Integer> diceNumbers;
	Integer diceSum;
	BigDecimal precision;

}
