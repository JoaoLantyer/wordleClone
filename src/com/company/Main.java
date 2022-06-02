package com.company;

import java.io.IOException;
import java.util.Scanner;
import java.util.Locale;
import java.lang.Character;
import java.net.URL;

public class Main {

    public static void main(String[] agrs) throws IOException {

        Locale.setDefault(Locale.US);

        Scanner input = new Scanner(System.in);

        Main obj = new Main();

        String result;
        String answer;
        int choice;

        do {

            do {
                URL url = new URL("https://random-word-api.herokuapp.com/word?length=5&lang=en");
                Scanner sc = new Scanner(url.openStream());
                StringBuilder sb = new StringBuilder();

                while (sc.hasNext()) {
                    sb.append(sc.next());
                }

                result = sb.toString();
                answer = result.substring(2, result.length() - 2);

            } while (!obj.UniqueCharacters(answer));

            wordleGame(answer);

            System.out.println("\n------------------------------");
            System.out.println("|    THE ANSWER WAS " + answer.toUpperCase(Locale.ROOT) + "    |");
            System.out.println("------------------------------");
            System.out.println("|                            |");
            System.out.println("|        GAME OVER...        |");
            System.out.println("|                            |");
            System.out.println("|         PLAY AGAIN?        |");
            System.out.println("|                            |");
            System.out.println("|     [1] YES     [2] NO     |");
            System.out.println("|                            |");
            System.out.println("------------------------------");
            System.out.print("YOUR CHOICE: ");
            choice = input.nextInt();

        }while(choice != 2);
    }

    public static void wordleGame(String answer){

        Scanner input = new Scanner(System.in);

        Main obj = new Main();

        String wordle;
        String[] tries = {"first", "second", "third", "fourth", "fifth", "last"};

        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                   .---.                              ,--,                                   |");
        System.out.println("|                                  /. ./|                       ,---,,--.'|                                   |");
        System.out.println("|                              .--'.  ' ;   ,---.    __  ,-.  ,---.'||  | :                                   |");
        System.out.println("|                             /__./ \\ : |  '   ,'\\ ,' ,'/ /|  |   | ::  : '                                   |");
        System.out.println("|                         .--'.  '   \\' . /   /   |'  | |' |  |   | ||  ' |      ,---.                        |");
        System.out.println("|                        /___/ \\ |    ' '.   ; ,. :|  |   ,',--.__| |'  | |     /     \\                       |");
        System.out.println("|                        ;   \\  \\;      :'   | |: :'  :  / /   ,'   ||  | :    /    /  |                      |");
        System.out.println("|                         \\   ;  `      |'   | .; :|  | ' .   '  /  |'  : |__ .    ' / |                      |");
        System.out.println("|                          .   \\    .\\  ;|   :    |;  : | '   ; |:  ||  | '.'|'   ;   /|                      |");
        System.out.println("|                           \\   \\   ' \\ | \\   \\  / |  , ; |   | '/  ';  :    ;'   |  / |                      |");
        System.out.println("|                            :   '  |--\"   `----'   ---'  |   :    :||  ,   / |   :    |                      |");
        System.out.println("|                             \\   \\ ;                      \\   \\  /   ---`-'   \\   \\  /                       |");
        System.out.println("|                              '---\"                        `----'              `----'                        |");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                                  TUTORIAL:                                                  |");
        System.out.println("|                                                                                                             |");
        System.out.println("|    Each guess must be a valid five-letter word with no repeating letters. Hit the enter button to submit.   |");
        System.out.println("|    If it says 'GREEN!' the letter is in the word and in the correct spot.                                   |");
        System.out.println("|    If it says 'YELLOW!' the letter is in the word but in the wrong spot.                                    |");
        System.out.println("|    If it says 'GRAY...' the letter is not in the word in any spot.                                          |");
        System.out.println("|    You have 6 attempts in total, good luck!                                                                 |");
        System.out.println("|                                                                                                             |");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        
        for(int i = 0; i <= 5; i++) {

            System.out.print("Type your " + tries[i] + " attempt: ");

            wordle = input.nextLine();

            if(wordle.length() == 5) {
                if(obj.UniqueCharacters(wordle)) {

                    //GUESS CHARACTERS
                    char firstLetterGuess = Character.toLowerCase(wordle.charAt(0));
                    char secondLetterGuess = Character.toLowerCase(wordle.charAt(1));
                    char thirdLetterGuess = Character.toLowerCase(wordle.charAt(2));
                    char fourthLetterGuess = Character.toLowerCase(wordle.charAt(3));
                    char fifthLetterGuess = Character.toLowerCase(wordle.charAt(4));

                    //ANSWER CHARACTERS
                    char firstLetterAnswer = answer.charAt(0);
                    char secondLetterAnswer = answer.charAt(1);
                    char thirdLetterAnswer = answer.charAt(2);
                    char fourthLetterAnswer = answer.charAt(3);
                    char fifthLetterAnswer = answer.charAt(4);

                    checkLetters(firstLetterGuess, firstLetterAnswer, answer);

                    checkLetters(secondLetterGuess, secondLetterAnswer, answer);

                    checkLetters(thirdLetterGuess, thirdLetterAnswer, answer);

                    checkLetters(fourthLetterGuess, fourthLetterAnswer, answer);

                    checkLetters(fifthLetterGuess, fifthLetterAnswer, answer);

                    if (firstLetterGuess == firstLetterAnswer && secondLetterGuess == secondLetterAnswer && thirdLetterGuess == thirdLetterAnswer && fourthLetterGuess == fourthLetterAnswer && fifthLetterGuess == fifthLetterAnswer) {
                        System.out.println("Congratulations!");
                        break;
                    }
                }else{
                    System.out.println("You have to type a five letter word with NO repeating letters!");
                    i--;
                }
            }else{
                System.out.println("You have to type a five letter word!");
                i--;
            }
        }
    }

    public static void checkLetters(char LetterGuess, char LetterAnswer, String answer){
        if (LetterGuess == LetterAnswer) {
            System.out.println("GREEN!");
        } else if (answer.indexOf(LetterGuess) >= 0) {
            System.out.println("YELLOW!");
        } else {
            System.out.println("GRAY...");
        }
    }

    boolean UniqueCharacters(String str)
    {
        for (int i = 0; i < str.length(); i++)
            for (int j = i + 1; j < str.length(); j++)
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
        return true;
    }
}
