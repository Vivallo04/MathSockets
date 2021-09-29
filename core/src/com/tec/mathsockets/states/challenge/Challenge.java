package com.tec.mathsockets.states.challenge;

import java.util.Random;
import java.util.Scanner;

public class Challenge {


    private final String TAG = Challenge.class.getSimpleName();

    /**
     * Name for every math operation
     */
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
    private static int result;
    private static String problem;


    /**
     * Set a random number between 1-50 and calls askForChallenge
     */
    public Challenge() {
        this.num1 = (int) (Math.random() * 50 + 1);
        this.num2 = (int) (Math.random() * 50 + 1);
        askForChallenge();
    }


    /**
     * Exchange num1 and num2 values
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
     * @return num1 str
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
     * Set the operation in a String variable and do the math problem
     */
    public void askForChallenge() {
        if (getRandomOperation().equals(Operation.ADDITION)) {
            problem = num1 + " + " + num2;
            result = num1 + num2;
            System.out.println(TAG + " Suma resultado: " + result);
            userInput = playerResult.nextInt();

            if (userInput == result) {
                return;
            }

        } else if (getRandomOperation().equals(Operation.SUBTRACTION)) {
            problem = num1 + " - " + num2;
            result = num1 - num2;
            System.out.println(TAG + " resta resultado: " + result);
            userInput = playerResult.nextInt();
            if (userInput == result) {
                return;
            }

        } else if (getRandomOperation().equals(Operation.MULTIPLICATION)) {
            problem = num1 + " * " + num2;
            result = num1 * num2;
            System.out.println(TAG + " multiplicación resultado: " + result);
            userInput = playerResult.nextInt();
            if (userInput == result) {
                return;
            }

        } else {
            problem = num1 + " / " + num2;
            System.out.println("La operación es división de: " + problem);
            setNum1(num1);
            result = num1 / num2;
            System.out.println(TAG + " división resultado: " + result);
            userInput = playerResult.nextInt();
            if (userInput == result) {
                return;
            }
        }
    }

    /**
     * Get the string variable with the problem to resolve
     * @return String math problem
     */
    public static String getProblem() {
        return problem;
    }

    /**
     * Get the result to compare it in ChallengeState
     * @return int result
     */
    public static int getResult() {
        return result;
    }


}
