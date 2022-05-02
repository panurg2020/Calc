package calc;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Calc {
    static Scanner s = new Scanner(System.in);
    static int number1, number2;
    static char operation;
    static int result;

    public static void main (String[] args) {
        System.out.println("������� �������������� ������ - ��������, ���� ������� �����, ������ - ���� ������ � ����� ������� � ����� ������ ��������, ����� �� 0-9 �������� � �� 1-10 � �������,������������ ������ ����� �����");
        String vvod = s.nextLine(); //������ ����
        char[] arr= vvod.toCharArray(); //���� �������� � ������ � ���������
        if (arr.length <= 5 && arr.length >= 3) {  //�������� �� ����� ������, ����� ������ �������� ����
            for (int i = 0; i < arr.length; i++) {  //��������� �� ����� ��������, ���� ���� �� ����� ������
                
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
            String[] razbiv = vvod.split("[+-/*]"); //�������� �� ����� ����� �������
            if (razbiv.length<=2) {    // �������� �� ������ ���� ��������
            String pervoe = razbiv[0];  
            if (pervoe.length() <= 2){ // �������� �� ���������� �����
            String vtoroe = razbiv[1];
            number1 = convert(pervoe); //����������� �� �������
            number2 = convert(vtoroe);
            if (number1 > 0 && number2 > 0) { //���� ������� �������
                result = calculation(number1, number2, operation);
                if (result > 0) {  // �������� �� ������������ ��������� � �������
                String resultRoman = convertRoman(result); // ����������� � ��������
                System.out.println( resultRoman);
                }
                else {System.out.println ("������ - � ������� ������� ��� �������������");}
            }
            else if (number1 < 0 && number2 < 0){// ���� ������ ��������
            number1 = Integer.parseInt(pervoe);
            number2 = Integer.parseInt(vtoroe);
            result = calculation(number1, number2, operation);
            System.out.println(result);
        }
            else if ((number1 < 0 && number2 > 0) || (number1 > 0 && number2 < 0)){
            System.out.println("������� � ������ ������� - ��������, ���� ������� ");
        }
        
        else { 
              System.out.println ("������ ���������� �����");
        }
        
            }
            else {System.out.println ("������ ����");
            }
            }
            else {System.out.println ("������ ���� ��������");}
        }
        else {
            System.out.println("�������������� ��������� �����, ���������� ��� ���");
        }
    
    }
    private static String convertRoman (int num) {// ����� ���������� ������� �� �������
        String[] roman = {"0","I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "IXX", "XX"};
        final String r = roman[num];
        return r;
    }
    private static int convert (String roman) {//����� ���������� � ��������
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
            throw new InputMismatchException("�������� ������ ������");
        }
        return -1;
    }
    public static int calculation (int num1, int num2, char op) {//���������� �������� ���������� ���������
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
                    System.out.println("������ ������ �� 0");

                    break;
                }
            }
            default -> throw new IllegalArgumentException("�� ������ ���� ��������");
        }
        return res;
    }
}