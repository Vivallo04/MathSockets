package com.tec.mathsockets.states.challenge;

import java.util.Random;
import java.util.Scanner;

public class Challenge {

    private final String TAG = Challenge.class.getSimpleName();


    public enum Operation {
        ADDITION,
        SUBTRACTION,
        MULTIPLICATION,
        DIVISION
    }

    Scanner playerResult = new Scanner(System.in);


    int userInput;
    private int num1;
    private int num2;
    private int result;
    private String problema;

    public Challenge() {
        this.num1 = (int) (Math.random() * 50 + 1);
        this.num2 = (int) (Math.random() * 50 + 1);
        askForChallenge();
    }


    /**
     *
     * @param num1
     */
    public void setNum1(int num1) {
        if (num1 < num2) {
            this.num1 = num2;
            this.num2 = num1;
            return;
        }
        this.num1 = num1;
    }


    /**
     * Get num1 value to string
     * @return
     */
    public String getNum1(){
        return String.valueOf(num1);
    }


    /**
     * Get num2 value to string
     * @return num2 st
     */
    public String getNum2() {
        return String.valueOf(num2);
    }

    /**
     * Get a random operacion from Operation Enum
     * @return Random operation type
     */
    private Operation getRandomOperation() {
        return Operation.values()[new Random().nextInt(Operation.values().length)];
    }



    /**
     *
     * @return
     */
    public void askForChallenge() {
        if (getRandomOperation().equals(Operation.ADDITION)) {
            problema = num1 + " + " + num2;
            System.out.println("La operación es suma de: " + problema);
            result = num1 + num2;
            System.out.println(TAG + " Suma resultado: " + result);
            userInput = playerResult.nextInt();

            if (userInput == result) {
                System.out.println("Correcto!");
                return;
            }
            System.out.println("Oops");

        } else if (getRandomOperation().equals(Operation.SUBTRACTION)) {
            problema = num1 + " - " + num2;
            System.out.println("La operación es resta de: " + problema);
            result = num1 - num2;
            System.out.println(TAG + " resta resultado: " + result);
            userInput = playerResult.nextInt();
            if (userInput == result) {
                System.out.println("Correcto!");
                return;
            }
            System.out.println("Oops");

        } else if (getRandomOperation().equals(Operation.MULTIPLICATION)) {
            problema = num1 + " * " + num2;
            System.out.println("La operación es multiplicación de: " + problema);
            result = num1 * num2;
            System.out.println(TAG + " multiplicación resultado: " + result);
            userInput = playerResult.nextInt();
            if (userInput == result) {
                System.out.println("Correcto!");
                return;
            }
            System.out.println("Oops");

        } else {
            problema = num1 + " / " + num2;
            System.out.println("La operación es división de: " + problema);
            setNum1(num1);
            result = num1 / num2;
            System.out.println(TAG + " división resultado: " + result);
            userInput = playerResult.nextInt();
            if (userInput == result) {
                System.out.println("Correcto!");
                return;
            }
            System.out.println("Oops");

        }
    }

    public int getResult() {
        return result;
    }


}
