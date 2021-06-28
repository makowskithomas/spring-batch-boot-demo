package de.moscon.etl.steps.testText;

import org.springframework.batch.item.ItemProcessor;

public class SimpleProcessor implements ItemProcessor<String, LetterCountDTO> {


	@Override
	public LetterCountDTO process(String data)  {

		LetterCountDTO letterCountDTO = new LetterCountDTO();
		letterCountDTO.setMessage(data.toUpperCase());
		letterCountDTO.setLetterCount(letterCountDTO.testMethod(data));

	return letterCountDTO;

//		return data.toUpperCase();
	}


}
