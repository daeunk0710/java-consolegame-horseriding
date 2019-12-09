import java.util.Scanner;
import java.util.*;

public class random_sudoku_set {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = 0; // 스도쿠 크기

        // n 입력 받기
        System.out.println("랜덤 스도쿠를 생성합니다.");
        System.out.println("원하는 숫자를 자연수로 입력해주세요. (ex. 100)");
        n = input.nextInt();

        long start = System.currentTimeMillis(); // 연산 시작

        int[][] arrSudoku = new int[n][n]; // n*n 배열 선언
        HashSet all = new HashSet(); // 전체 HashSet 선언. 비교군 역할
        HashSet col = new HashSet(); // 행 HashSet 선언
        HashSet row = new HashSet(); // 열 HashSet 선언

        // all HashSet 1~n 자연수 추가
        for(int i=1; i<=n; i++){
            all.add(i);
        }
        System.out.println(all);

        // 1행 (i=0) 랜덤 배치
        for (int j = 0; j < n; j++) {
                arrSudoku[0][j] =j+1;
        }
        for (int j= 0; j<n; j++) {
            int seed = (int)(Math.random()*n);
            int temp = arrSudoku[0][j];
            arrSudoku[0][j]=arrSudoku[0][seed];
            arrSudoku[0][seed]=temp;
        }

        // 2행~n행 배치
        for (int i = 1; i<n; i++){ //세로 위에서 아래 순서대로 내려감
            for (int j = 0; j<n; j++){ //가로 왼쪽에서 오른쪽 순서대로

                // j 열 i-1 행까지의 set 생성
                for (int k = 0; k<i; k++){
                    row.add(arrSudoku[k][j]);
                }
                System.out.println(row);

                // all 과 row 의 차집합 생성
                Iterator iterator = all.iterator();
                HashSet setDiff = new HashSet();
                iterator = all.iterator();
                while (iterator.hasNext()){
                    Object temp = iterator.next();
                    if (!row.contains(temp))
                        setDiff.add(temp);
                }
                System.out.println(setDiff);

                // 차집합에서 랜덤 추출 후 arrSudoku[i][j]에 입력
                // Object random = IterableUtils
                // arrSudoku[i][j] = x;
                // row.clear(); // row set 초기화
            }
        }


        long end = System.currentTimeMillis(); // 연산 종료

        // 배열 출력
        for (int i = 0; i< arrSudoku.length; i++){
            for (int j = 0; j< arrSudoku.length; j++){
                System.out.print(arrSudoku[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("\n연산 시간 "+(end - start)/1000.0 + "초 소요되었습니다.");
    }
}