package week03.test01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Calculator {

    private int firstNumber ;
    private int secondNumber ;
    private String operator  ;
    private double result ;



    public double calculate(int firstNumber, int secondNumber,String operator){

        switch (operator) {
            case "+":
                result = firstNumber + secondNumber;
                break;

            case "-":
                result = firstNumber - secondNumber;
                break;

            case "*":
                result = firstNumber * secondNumber;
                break;

            case "/":
                if(secondNumber != 0){
                    result = (double) firstNumber / secondNumber;
                }else{
                    System.out.println("몫에 0이 들어갈 수 없습니다.");
                }

                break;
        }
        return result;
    }
    public int getFirstNumber() {
        return firstNumber;
    }
    public int getSecondNumber(){
        return secondNumber;
    }
    public void setFirstNumber(){
        this.firstNumber = firstNumber;
    }
    public void setScondNumber(){
        this.secondNumber = secondNumber;
    }
    public double getResult(){
        return result;
    }
    public void setResult(){
        this.result = calculate(firstNumber,secondNumber,operator);
    }


    public static class App {
        public static void main(String[] args) {
            Calculator c = new Calculator();

            Queue<Double> resultQ = new LinkedList<>() {};

            while(true) {
                Scanner sc = new Scanner(System.in);


                System.out.print("첫번째 숫자를 입력하세요: ");
                int firstNumber = sc.nextInt();

                System.out.print("기호를 입력하세요(+, -, *, /, % ): ");
                String operator = sc.next();

                System.out.print("두번째 숫자를 입력하세요: ");
                int secondNumber = sc.nextInt();


                System.out.println("결과 : " + c.calculate(firstNumber, secondNumber, operator)) ;
                resultQ.add(c.calculate(firstNumber, secondNumber, operator));
                System.out.print("더 계산하시겠시려면 아무키나 입력해주세요 (exit 입력 시 종료)");
                String answer = sc.next();
                if(answer.equals("exit")){
                    break;
                }
                System.out.println("가장 먼저 저장된 데이터를 삭제하시겠습니까? (remove 입력 시 삭제)");
                String answer2 = sc.next();
                if(answer2.equals("remove")){
                    resultQ.remove(c.calculate(firstNumber, secondNumber, operator));
                    break;
                }

            }
        }
    }
}


