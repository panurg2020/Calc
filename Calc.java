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
        String vvod = s.nextLine(); //считал ввод
        char[] arr= vvod.toCharArray(); //ввод перевожу в массив с символами
        if (arr.length <= 5 && arr.length >= 3) {  //проверка на длину строки, чтобы отсечь неверный ввод
            for (int i = 0; i < arr.length; i++) {  //переборка на знаки операции, даже если их более одного
                
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
            String[] razbiv = vvod.split("[+-/*]"); //разбиваю на числа между знаками
            if (razbiv.length<=2) {    // проверка на второй знак операции
            String pervoe = razbiv[0];  
            if (pervoe.length() <= 2){ // проверка на двузначное число
            String vtoroe = razbiv[1];
            number1 = convert(pervoe); //конвертация из римских
            number2 = convert(vtoroe);
            if (number1 > 0 && number2 > 0) { //если имеются римские
                result = calculation(number1, number2, operation);
                if (result > 0) {  // проверка на отрицательнй результат в римских
                String resultRoman = convertRoman(result); // конвертация в арабские
                System.out.println( resultRoman);
                }
                else {System.out.println ("Ошибка - в римской системе нет отрицательных");}
            }
            else if (number1 < 0 && number2 < 0){// если только арабские
            number1 = Integer.parseInt(pervoe);
            number2 = Integer.parseInt(vtoroe);
            result = calculation(number1, number2, operation);
            System.out.println(result);
        }
            else if ((number1 < 0 && number2 > 0) || (number1 > 0 && number2 < 0)){
            System.out.println("Вводите в единой системе - арабской, либо римской ");
        }
        
        else { 
              System.out.println ("Только двузначные числа");
        }
        
            }
            else {System.out.println ("Ошибка вода");
            }
            }
            else {System.out.println ("Только один оператор");}
        }
        else {
            System.out.println("Несоответствие заданному вводу, попробуйте ещё раз");
        }
    
    }
    private static String convertRoman (int num) {// метод возвращает римское из массива
        String[] roman = {"0","I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "IXX", "XX"};
        final String r = roman[num];
        return r;
    }
    private static int convert (String roman) {//метод конвертции в арабские
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
                case "XI" -> {
                    return 11;
                }
                case "XII" -> {
                    return 12;
                }
                case "XIII" -> {
                    return 13;
                }
                case "XIV" -> {
                    return 14;
                }
                case "XV" -> {
                    return 15;
                }
                case "XVI" -> {
                    return 16;
                }
                case "XVII" -> {
                    return 17;
                }
                case "XVIII" -> {
                    return 18;
                }
                case "IXX" -> {
                    return 19;
                }
                case "XX" -> {
                    return 20;
                }
                default ->{
                        }
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Неверный формат данных");
        }
        return -1;
    }
    public static int calculation (int num1, int num2, char op) {//выполнение операции возвращает результат
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