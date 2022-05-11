package calc;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Calc {
    static Scanner s = new Scanner(System.in);
    static int number1, number2;
    static char operation;
    static int result;

    public static void main (String[] args) throws Exception   {
        System.out.println("Введите арифметический пример - арабские, либо римские цифры, формат - одна строка с двумя числами и одним знаком операции, числа от 0-9 арабские и от 1-10 в римские,использовать только целые числа");
        String vvod = s.nextLine(); //считал ввод
        char[] arr= vvod.toCharArray(); //ввод перевожу в массив с символами
        if (arr.length <= 5 && arr.length >= 3) {  //проверка на длину строки, чтобы отсечь неверный ввод   
        for (int i = 1; i < arr.length-1; i++) {  //переборка на знаки операции, даже если их более одного
                
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
          //String[] celoe = vvod.split("[.]");
           // if (celoe.length==0) {
          if (razbiv.length<=2) {    // проверка на второй знак операции            	
            String pervoe = razbiv[0];
            String vtoroe = razbiv[1];
          if ((pervoe.length() <= 2)&&(pervoe.length()!=0)) { // проверка на двузначное число
            
            try {
            number1 = convert(pervoe); //конвертация из римских
            number2 = convert(vtoroe);
            }
            catch (NumberFormatException e){
             	throw new Exception("//т.к. используются одновременно разные системы счисления");
             }
            if (number1 > 0 && number2 > 0) { //если имеются римские
                result = calculation(number1, number2, operation);
                if (result==0){
                	throw new Exception("//т.к. в римской системе нет 0");
                }
                else {
                try {
                String resultRoman = convertRoman(result); // конвертация в арабские
             
                System.out.println( resultRoman);
                }
                catch (ArrayIndexOutOfBoundsException e) {
                	throw new Exception("//т.к. в римской системе нет отрицательных чисел");
                }
                }
          }
            else {
            	try {
            number1 = Integer.parseInt(pervoe);
            number2 = Integer.parseInt(vtoroe);
            	}
            	catch (NumberFormatException e){
            		throw new Exception ("//т.к. используются одновременно разные системы счисления");
            	}
            
           if(((number1>0) && (number1 <=10)) && ((number2>0) && (number2 <=10))) {
            result = calculation(number1, number2, operation);
            System.out.println(result);
           }
           else {
        	   throw new Exception("//т.к. по условию ввода числа используются от 1 до 10");
           }
            }
           
         }
         else {throw new Exception("Ошибка ввода- по условию только двузначные положительные числа");
          }
          //}
         // else {
           //throw new Exception("//т.к. формат математической операции не удовлетворяет заданию - два операнда и оин оператор (+,-,/,*)") ;
          //}
           // }
          //  else {
           // 	throw new Exception("//т.к. используются только целые числа");
          
        }
       else {
    	   throw new Exception("//т.к. ввод не удовлетворяет условию - два числа от 1-10 и один знак операции");
        }
        }

        else {
        	 throw new Exception("//т.к. ввод не удовлетворяет условию - два числа от 1-10 и один знак операции");
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
        } catch (NumberFormatException e) {
System.out.println("ерный формат данных");
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
                    System.out.println("Нельзя делить на 0");
                    break;
                }
            }
            default -> throw new IllegalArgumentException("Не верный знак операции");
        }
        return res;
    }
}