package Lv2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<Integer> results = new ArrayList<>();

    // 사칙연산 수행 후 결과 반환 및 결과 저장
    public int calculate(int value1, int value2, char operation) {
        int result = 0;

        // 연산자에 따른 사칙연산 수행
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
                if (value2 != 0) {
                    result = value1 / value2;
                } else {
                    System.out.println("0으로 나눌 수 없습니다.");
                    return -1;
                }
                break;
            default:
                System.out.println("잘못된 연산자입니다.");
                return -1; // 오류 코드 반환
        }

        // 연산 결과를 컬렉션에 저장
        results.add(result);
        return result;
    }

    // Getter: 연산 결과 목록 반환
    public List<Integer> getResults() {
        return results;
    }

    // Setter: 연산 결과 목록 수정
    public void setResults(List<Integer> results) {
        this.results = results;
    }

    // 가장 오래 된 저장된 연산 결과 삭제
    public void removeFirstResult() {
        if (!results.isEmpty()) {
            results.remove(0);
        }
    }
}
