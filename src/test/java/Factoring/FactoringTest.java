package Factoring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.assertj.core.api.Assertions.*;

class FactoringTest {

    @Test
    @DisplayName("first line other values than numbers")
    void firstLine_inputOtherValuesThanNumbers() {
        //given
        Factoring factoring = new Factoring();
        String input = this.randomInt()+" "+ this.generateString();
        //when
        var exception = factoring.firstLine(input);
        //than
        assertThat(exception).contains("format");
    }
    @Test
    @DisplayName("first line other values than number two")
    void firstLine_inputOtherValuesThanNumberTwo() {
        //given
        Factoring factoring = new Factoring();
        String input = this.randomInt()+" "+ this.randomInt()+this.generateString();
        //when
        var exception = factoring.firstLine(input);
        //than
        assertThat(exception).contains("format");
    }
    @Test
    @DisplayName("first line more than 2 numbers")
    void firstLine_inputMoreThan2Numbers() {
        //given
        Factoring factoring = new Factoring();
        String input = this.randomInt()+" "+this.randomInt()+" "+this.randomInt();
        //when
        var exception = factoring.firstLine(input);
        //than
        assertThat(exception).contains("format");
    }
    @Test
    @DisplayName("first line table size lower than number which one from the end is max")
    void firstLine_inputTableSizeLowerThanNumberWhichOneFromTheEndIsMax() {
        //given
        Factoring factoring = new Factoring();
        Integer numberOne = this.randomInt();
        Integer numberTwo = numberOne+1;
        String input = String.valueOf(numberOne)+" "+String.valueOf(numberTwo);
        //when
        var exception = factoring.firstLine(input);
        //than
        assertThat(exception).contains("lower");
    }
    @Test
    @DisplayName("first line negative numbers")
    void firstLine_inputNegativeNumbers() {
        //given
        Factoring factoring = new Factoring();
        Integer numberOne = this.randomInt();
        Integer numberTwo = numberOne+1;
        String input = "-"+String.valueOf(numberTwo)+" "+String.valueOf(numberOne);
        //when
        var exception = factoring.firstLine(input);
        //than
        assertThat(exception).contains("format");
    }
    @Test
    @DisplayName("first input with correct values")
    void firstLine_correctInput() {
        //given
        Factoring factoring = new Factoring();
        Integer numberOne = this.randomInt();
        Integer numberTwo = numberOne+1;
        String input = String.valueOf(numberTwo)+" "+String.valueOf(numberOne);
        //when
        var exception = factoring.firstLine(input);
        //than
        assertThat(exception).contains("Correct");
    }

    @Test
    @DisplayName("second line incorrect number of numbers - more than excepts")
    void secondLine_inputIncorrectNumberOfNumbers_MoreThanExcepts(){
        //given
        Factoring factoring = new Factoring();
        Integer numberOne = this.randomInt();
        Integer numberTwo = numberOne+1;
        String input = String.valueOf(numberTwo)+" "+String.valueOf(numberOne);
        factoring.firstLine(input);
        String input2="";
        for(int i=0; i<numberOne+2;i++) {
            input2=input2+this.randomInt()+" ";
        }
        input2=input2+this.randomInt();

        //when
        var exception = factoring.secondLine(input2);
        //than
        assertThat(exception).contains("size");
    }
    @Test
    @DisplayName("second line incorrect number of numbers - less than excepts")
    void secondLine_inputIncorrectNumberOfNumbers_LessThanExcepts(){
        //given
        Factoring factoring = new Factoring();
        Integer numberOne = this.randomInt();
        Integer numberTwo = numberOne+1;
        String input = String.valueOf(numberTwo)+" "+String.valueOf(numberOne);
        factoring.firstLine(input);
        String input2="";
        for(int i=0; i<numberOne-2;i++) {
            input2=input2+this.randomInt()+" ";
        }
        input2=input2+this.randomInt();

        //when
        var exception = factoring.secondLine(input2);
        //than
        assertThat(exception).contains("size");
    }
    @Test
    @DisplayName("second line incorrect format of input")
    void secondLine_inputIncorrectFormatOfInput(){
        //given
        Factoring factoring = new Factoring();
        Integer numberOne = this.randomInt();
        Integer numberTwo = numberOne+1;
        String input = String.valueOf(numberOne+1)+" "+String.valueOf(numberOne);
        factoring.firstLine(input);
        String input2="";
        for(int i=0; i<numberOne;i++) {
            input2=input2+this.randomInt()+" ";
        }
        input2=input2+this.generateString();
        //when
        var exception = factoring.secondLine(input2);
        //than
        assertThat(exception).contains("format");
    }
    @Test
    @DisplayName("second input with correct values")
    void secondLine_correctInput(){
        //given
        Factoring factoring = new Factoring();
        Integer numberOne = this.randomInt();
        Integer numberTwo = numberOne+1;
        String input = String.valueOf(numberOne+1)+" "+String.valueOf(numberOne);
        factoring.firstLine(input);
        String input2="";
        for(int i=0; i<numberOne;i++) {
            input2=input2+this.randomInt()+" ";
        }
        input2=input2+this.randomInt();
        //when
        var exception = factoring.secondLine(input2);
        //than
        assertThat(exception).contains("Correct");
    }


    public String generateString () {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 5;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }
    public Integer randomInt () {
        return (int)(Math.random() * 1000) + 1;
    }
}