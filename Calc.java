package calc;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Calc {
    static Scanner s = new Scanner(System.in);
    static int number1, number2;
    static char operation;
    static int result;

    public static void main (String[] args) throws Exception   {
        System.out.println("¬ведите арифметический пример - арабские, либо римские цифры, формат - одна строка с двум€ числами и одним знаком операции, числа от 0-9 арабские и от 1-10 в римские,использовать только целые числа");
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
            try {
            number1 = convert(pervoe); //конвертаци€ из римских
            number2 = convert(vtoroe);
            if (number1 > 0 && number2 > 0) { //если имеютс€ римские
                result = calculation(number1, number2, operation);
                try {
                String resultRoman = convertRoman(result); // конвертаци€ в арабские
                System.out.println( resultRoman);
                }
                catch (ArrayIndexOutOfBoundsException e) {
                	throw new Exception("//т.к. в римской системе нет отрицательных чисел");
                }
                }
            else {
            number1 = Integer.parseInt(pervoe);
            number2 = Integer.parseInt(vtoroe);
            result = calculation(number1, number2, operation);
            System.out.println(result);
            }
           }
           catch (NumberFormatException e){
            	throw new Exception("//т.к. используютс€ одновременно разные системы счислени€");
            }
            }
            else {throw new Exception("ќшибка ввода- по условию только двузначные числа");
            }
            }
            else {
            	throw new Exception("//т.к. формат математической операции не удовлетвор€ет заданию - два операнда и оин оператор (+,-,/,*)") ;
            	}
       }
       else {
    	   throw new Exception("//т.к. строка не €вл€етс€ математической операцией");
        }
    }
    private static String convertRoman (int num) {// метод возвращает римское из массива
        String[] roman = {"0","I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "IXX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
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
                default ->{
                        }
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Ќеверный формат данных");
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
                    System.out.println("Ќельз€ делить на 0");
                    break;
                }
            }
            default -> throw new IllegalArgumentException("Ќе верный знак операции");
        }
        return res;
    }
}