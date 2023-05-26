package challenge21;

import challenge21.exception.InvalidFormatException;
import challenge21.exception.UnsupportedOperatorException;
import java.io.*;

/*
  Challenge: #21
  Task: CALCULATOR.TXT

  Statement: Read the file "Challenge21.txt" included in the project, calculate its result, and print it.
             - The .txt file corresponds to the inputs of a calculator.
             - Each line will have a number or an operation represented by a symbol (alternating between the two).
             - It supports addition '+', subtraction '-', multiplication '*', and division '/' operations.
             - The result is displayed upon finishing the reading of the last line (if the .txt file is correct).
             - If the format of the file .txt is incorrect, it will indicate that the operations could not be resolved.
*/

public class Main {

    private static final char[] SUPPORTED_OPERATORS = {'+', '-', '*', '/'};

    public static void main(String[] args) {

        File file = new File("C:\\Users\\peanl\\OneDrive\\Escritorio\\Weekly-Challenge\\src\\main\\java\\challenge21\\Challenge21.txt");

        if (isValidFile(file)) {
            double result = calculateResult(file);
            System.out.println("The result is " + result);
        } else {
            System.out.println("Invalid file");
        }

    }

    private static double calculateResult(File file){
        double result = 0;
        char lastOperator = ' ';

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while((line = br.readLine()) != null){

                if(Character.isDigit(line.charAt(0))){
                    result = performOperation(lastOperator, Double.parseDouble(line), result);
                }else{
                    throw new InvalidFormatException("The first element must be a number");
                }

                if((line = br.readLine()) != null && isValidOperator(line)){
                    lastOperator = line.charAt(0);
                }

            }

        } catch (IOException | UnsupportedOperatorException | InvalidFormatException ex) {
            System.out.println("An error ocurred while reading the file: " + ex.getMessage());
            result = 0;
        }

        return result;
    }
    private static boolean isValidFile(File file){
        return file.isFile() && file.getName().endsWith(".txt");
    }
    private static boolean isValidOperator(String line) throws UnsupportedOperatorException{
        for(char symbol : SUPPORTED_OPERATORS){
            if(line.indexOf(symbol) != -1){
                return true;
            }
        }
        throw new UnsupportedOperatorException("This file contains an unsupported operator");
    }
    private static double performOperation(char operator, double number, double result){
        switch (operator) {
            case '+' -> {
                return result + number;
            }
            case '-' -> {
                return result - number;
            }
            case '*' -> {
                return result * number;
            }
            case '/' -> {
                return result / number;
            }
            default -> {
                return number;
            }
        }

    }
}