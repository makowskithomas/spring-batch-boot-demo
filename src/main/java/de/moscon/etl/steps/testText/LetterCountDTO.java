package de.moscon.etl.steps.testText;

import java.util.Locale;

public class LetterCountDTO {

    String message;
    Integer letterCount;

    public int testMethod(String data){
        String test = data;
        int count = 0;

        for (int i = 0; i < test.length(); i++) {
            if(test.charAt(i) != ' ')
                count++;
        }

//        LetterCountDTO letterCountDTO = new LetterCountDTO();
//        letterCountDTO.setMessage(data);
//        letterCountDTO.setLetterCount(count);
//        String test2 = "\n" + " + Anzahl der Buchstaben: " + count;
//        String test3 = test.toUpperCase();

        return count;
    }

    public LetterCountDTO() {
    }

    public LetterCountDTO(String message, Integer letterCount) {
        this.message = message;
        this.letterCount = letterCount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getLetterCount() {
        return letterCount;
    }

    public void setLetterCount(Integer letterCount) {
        this.letterCount = letterCount;
    }
}
