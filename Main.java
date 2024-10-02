import java.util.Scanner;

/*
StringBuilder sb=new StringBuilder();
        sb.append("abc");
        for (int i = 0; i < 50; i++) {
            System.out.println(i+">");
            sb.append("x");
            System.out.println(sb);
            System.out.println(sb.capacity());
        }
        System.out.println(sb.capacity());
 */

public class Main {
    private static String []words={"TEMPERATURE", "RACHIT", "DATA", "SYSTEM", "SAKSHAM", "COMPUTER", "INDIA", "CALCULUS", "WESTHILL"};

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int random=(int) (Math.random() * words.length) ;
        int attemptsLeft=6;
        String wordToGuess = words[random];
        char[] letters=wordToGuess.toCharArray();
        boolean[]  lettersGuessed=new boolean[letters.length];
        boolean isWordGuessed=false;

        System.out.println("Welcome to hangman. \nYou have 6 attempts to guess the word.");
        while(attemptsLeft>0 && !isWordGuessed){
            System.out.println("\nWord to guess:");
            for(int i=0; i<letters.length; i++){
                if(lettersGuessed[i]){
                    System.out.print(letters[i]+ " ");
                } else{
                    System.out.print("_ ");
                }
            }
            System.out.println("\n\nAttempts left: " + attemptsLeft);
            System.out.print("Guess a letter: ");
            String input = s.next().toUpperCase();
            if(input.length()!=1){
                System.out.println("Please enter your guess: ");
                continue;
            }
            char guessedLetter=input.charAt(0);
            boolean guess=false;

            for(int i=0; i<letters.length; i++){
                if(letters[i]==guessedLetter){
                    lettersGuessed[i]=true;
                    guess=true;
                }
            }
            if(!guess){
                attemptsLeft--;
                System.out.println("Wrong, guess again");
            } else{
                System.out.println("Correct");
            }

            isWordGuessed=true;
            for (boolean b : lettersGuessed) {
                if (!b) {
                    isWordGuessed=false;
                    break;
                }
            }
        }
        if (isWordGuessed) {
            System.out.println("\nCongrats! You guessed the word: " + wordToGuess);
        } else{
            System.out.println("\nHaha you lost! The word was: " + wordToGuess);
        }


    }
}