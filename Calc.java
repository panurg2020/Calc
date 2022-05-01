package calc;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Calc {
    static Scanner s = new Scanner(System.in);
    static int number1, number2;
    static char operation;
    static int result;

    public static void main (String[] args) {
        System.out.println("Введите арифметический пример - арабские, либо римские цифры, формат - одна строка с двумя числами и одним знаком операции, числа от 0-9 арабские и от 1-10 в римские,использовать только целые числа");
        String vvod = s.nextLine();
        char[] arr= vvod.toCharArray();
        if (arr.length <= 5 && arr.length >= 3) {
            for (int i = 0; i < arr.length; i++) {
                
                if (arr[i] == '+') {
                    operation = '+';
                }
                if (arr[i] == '-') {
                    operation = '-';
                }
                if (arr[i] == '*') {
                    operation = '*';
                }
                if (arr[i] == '/') {
                    operation = '/';
                }
            }
           // String vvodString = String.valueOf(arr);
            String[] razbiv = vvod.split("[+-/*]");
            if (razbiv.length<=2){
            String pervoe = razbiv[0];
            if (pervoe.length() <= 2){
            String vtoroe = razbiv[1];
            //String vtoroe = stable01.trim();
            if (vtoroe.length()<=2) {    		
            number1 = convert(pervoe);
            number2 = convert(vtoroe);
           
            if (number1 < 1 && number2 < 1) {
                result = 0;
            } else {  
           
            result = calculation(number1, number2, operation);
            String resultRoman = convertRoman(result);
            System.out.println(pervoe + " " + operation + " " + vtoroe + " = " + resultRoman);
            
            }
            number1 = Integer.parseInt(pervoe);
            number2 = Integer.parseInt(vtoroe);
            result = calculation(number1, number2, operation);
            System.out.println(number1 + " " + operation + " " + number2 + " = " + result);
            }         
            else {
            	System.out.println ("Только двузначное число");
            }
            }
        else { 
              System.out.println ("Только двузначное число");
        }
        }
        else {
            System.out.println("Несоответствие заданному вводу, попробуйте ещё раз");
        }
        }
        else {System.out.println ("Только один оператор");}
    
    }
    private static String convertRoman (int num) {
        String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "IXX", "XX"};
        final String r = roman[num];
        return r;
    }
    private static int convert (String roman) {
        try {
            switch (roman) {
                case "I" -> {
                    return 1;
                }
                case "II" -> {
                    return 2;
                }
                case "III" -> {
                    return 3;
                }
                case "IV" -> {
                    return 4;
                }
                case "V" -> {
                    return 5;
                }
                case "VI" -> {
                    return 6;
                }
                case "VII" -> {
                    return 7;
                }
                case "VIII" -> {
                    return 8;
                }
                case "IX" -> {
                    return 9;
                }
                case "X" -> {
                    return 10;
                }
                default ->{
                        }
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Неверный формат данных");
        }
        return -1;
    }
    public static int calculation (int num1, int num2, char op) {
        int res = 0;
        switch (op) {
            case '+' -> res = num1 + num2;
            case '-' -> res = num1 - num2;
            case '*' -> res = num1 * num2;
            case '/' -> {
                try {
                    res = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);
                    System.out.println("Нельзя делить на 0");

                    break;
                }
            }
            default -> throw new IllegalArgumentException("Не верный знак операции");
        }
        return res;
    }
}