package Lv2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();

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
            String input = sc.nextLine();
            if (input.length() != 1) {
                System.out.println("연산자는 한 글자만 입력해야 합니다.");
                continue;
            }

            char operation = input.charAt(0);

            if (operation != '+' && operation != '-' && operation != '*' && operation != '/') {
                System.out.println("잘못된 연산자입니다.");
                continue;
            }

            // 나눗셈 0 검사
            if (operation == '/' && value2 == 0) {
                System.out.println("0으로 나눌 수 없습니다.");
                continue;
            }


            // 연산 수행
            int result = calc.calculate(value1, value2, operation);
            System.out.println("연산 결과: " + result);


            // 더 계산할지 묻기
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            String continueCalc = sc.nextLine();
            if (continueCalc.equals("exit")) break;

            // 연산 결과 삭제
            System.out.println("가장 오래된 결과를 삭제합니다.");
            calc.removeFirstResult(); // 첫 번째 결과 삭제
        }

        sc.close();
    }
}
