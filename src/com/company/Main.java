package com.company;

import java.util.Objects;
import java.util.Scanner;
import java.util.Locale;

public class Main {

    Locale locale = new Locale("en_US");

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner input = new Scanner(System.in);
        int randomNumber = 1 + (int) (Math.random() * 5);

        if (randomNumber == 1) {
            wordleGame("N", "I", "G", "H", "T");
        }else if(randomNumber == 2){
            wordleGame("C", "L", "O", "T", "H");
        }else if(randomNumber == 3){
            wordleGame("P", "L", "U", "C", "K");
        }else if(randomNumber == 4){
            wordleGame("F", "R", "E", "S", "H");
        }else if(randomNumber == 5){
            wordleGame("D", "R", "A", "I", "N");
        }

        System.out.println("-------- GAME OVER --------");

    }

    public static void wordleGame(String a, String b, String c, String d, String e){
        Scanner input = new Scanner(System.in);
        String[] answer = {a, b, c, d, e};
        String[] wordle = new String[5];

        System.out.println("-----WORDLE!-----");
        System.out.println("TUTORIAL:");
        System.out.println("If it says 'GREEN!' the letter is in the word and in the correct spot.");
        System.out.println("If it says 'YELLOW!' the letter is in the word but in the wrong spot.");
        System.out.println("If it says 'GRAY...' the letter is not in the word in any spot.");

        for (int j = 1; j <= 6; j++) {
            for (int i = 0; i < 5; i++) {
                System.out.printf("Type the %dº letter.\n", i + 1);
                wordle[i] = input.nextLine();
            }
            if (Objects.equals(wordle[0].toUpperCase(), a)) {
                System.out.println("GREEN!");
            }else if(Objects.equals(wordle[0].toUpperCase(), b)){
                System.out.println("YELLOW!");
            }else if(Objects.equals(wordle[0].toUpperCase(), c)){
                System.out.println("YELLOW!");
            }else if(Objects.equals(wordle[0].toUpperCase(), d)){
                System.out.println("YELLOW!");
            }else if(Objects.equals(wordle[0].toUpperCase(), e)){
                System.out.println("YELLOW!");
            }else{
                System.out.println("GRAY...");
            }
            if (Objects.equals(wordle[1].toUpperCase(), a)) {
                System.out.println("YELLOW!");
            }else if(Objects.equals(wordle[1].toUpperCase(), b)){
                System.out.println("GREEN!");
            }else if(Objects.equals(wordle[1].toUpperCase(), c)){
                System.out.println("YELLOW!");
            }else if(Objects.equals(wordle[1].toUpperCase(), d)){
                System.out.println("YELLOW!");
            }else if(Objects.equals(wordle[1].toUpperCase(), e)){
                System.out.println("YELLOW!");
            }else{
                System.out.println("GRAY...");
            }
            if (Objects.equals(wordle[2].toUpperCase(), a)) {
                System.out.println("YELLOW!");
            }else if(Objects.equals(wordle[2].toUpperCase(), b)){
                System.out.println("YELLOW!");
            }else if(Objects.equals(wordle[2].toUpperCase(), c)){
                System.out.println("GREEN!");
            }else if(Objects.equals(wordle[2].toUpperCase(), d)){
                System.out.println("YELLOW!");
            }else if(Objects.equals(wordle[2].toUpperCase(), e)){
                System.out.println("YELLOW!");
            }else{
                System.out.println("GRAY...");
            }
            if (Objects.equals(wordle[3].toUpperCase(), a)) {
                System.out.println("YELLOW!");
            }else if(Objects.equals(wordle[3].toUpperCase(), b)){
                System.out.println("YELLOW!");
            }else if(Objects.equals(wordle[3].toUpperCase(), c)){
                System.out.println("YELLOW!");
            }else if(Objects.equals(wordle[3].toUpperCase(), d)){
                System.out.println("GREEN!");
            }else if(Objects.equals(wordle[3].toUpperCase(), e)){
                System.out.println("YELLOW!");
            }else{
                System.out.println("GRAY...");
            }
            if (Objects.equals(wordle[4].toUpperCase(), a)) {
                System.out.println("YELLOW!");
            }else if(Objects.equals(wordle[4].toUpperCase(), b)){
                System.out.println("YELLOW!");
            }else if(Objects.equals(wordle[4].toUpperCase(), c)){
                System.out.println("YELLOW!");
            }else if(Objects.equals(wordle[4].toUpperCase(), d)){
                System.out.println("YELLOW!");
            }else if(Objects.equals(wordle[4].toUpperCase(), e)){
                System.out.println("GREEN!");
            }else{
                System.out.println("GRAY...");
            }

            if (wordle[0].toUpperCase().equals(answer[0]) && wordle[1].toUpperCase().equals(answer[1]) && wordle[2].toUpperCase().equals(answer[2]) && wordle[3].toUpperCase().equals(answer[3]) && wordle[4].toUpperCase().equals(answer[4])) {
                System.out.println("Congratulations!");
                break;
            }

        }
    }

}
