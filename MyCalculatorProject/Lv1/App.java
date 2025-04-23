package Lv1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int value1 = -1;
            int value2 = -1;

            // 첫 번째 숫자 입력
            while (true) {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                try {
                    value1 = Integer.parseInt(sc.nextLine());
                    if (value1 < 0) {
                        System.out.println("양의 정수(0 포함)를 입력하세요.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("정수를 입력하세요.");
                }
            }

            // 두 번째 숫자 입력
            while (true) {
                System.out.print("두 번째 숫자를 입력하세요: ");
                try {
                    value2 = Integer.parseInt(sc.nextLine());
                    if (value2 < 0) {
                        System.out.println("양의 정수를 입력하세요.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("정수를 입력하세요.");
                }
            }

            // 연산자 입력
            System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /): ");
            char operation = sc.nextLine().charAt(0);

            // 연산자 검증
            if (operation != '+' && operation != '-' && operation != '*' && operation != '/') {
                System.out.println("연산자를 잘못 입력하였습니다.");
                continue;
            }

            // 나눗셈 0 검사
            if (operation == '/' && value2 == 0) {
                System.out.println("0으로 나눌 수 없습니다.");
                continue;
            }

            // 결과 계산
            int result = 0;
            switch (operation) {
                case '+':
                    result = value1 + value2;
                    break;
                case '-':
                    result = value1 - value2;
                    break;
                case '*':
                    result = value1 * value2;
                    break;
                case '/':
                    result = value1 / value2;
                    break;
            }

            System.out.println("연산 결과 : " + result);

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            if (sc.nextLine().equals("exit")) break;
        }

        sc.close();
    }
}