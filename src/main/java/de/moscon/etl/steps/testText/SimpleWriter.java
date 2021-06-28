package de.moscon.etl.steps.testText;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class SimpleWriter implements ItemWriter<LetterCountDTO> {

	@Override
	public void write(List<? extends LetterCountDTO> messages) {
		System.out.println("---> Writing:");
		for (LetterCountDTO msg : messages) {
			System.out.println(" --> "+msg.getMessage() + "\n" + "Anzahl der Buchstaben: " + msg.getLetterCount());
		}
	}

}
