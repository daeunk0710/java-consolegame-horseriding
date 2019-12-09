import java.util.Arrays;
import java.util.Scanner;

public class random_sudoku {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = 0; // 스도쿠 크기

        // n 입력 받기
        System.out.println("랜덤 스도쿠를 생성합니다.");
        System.out.println("원하는 숫자를 자연수로 입력해주세요. (ex. 100)");
        n = input.nextInt();

        // n*n 배열 선언
        int[][] arrSudoku = new int[n][n];

        // 연산 시작
        long start = System.currentTimeMillis();

        // 각 행에 1~n 까지 수 배정
        for (int i = 0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                arrSudoku[i][j] =j+1;
            }
        }

        // 0행 랜덤하게 섞기
        for (int j= 0; j<n; j++){
            int seed = (int)(Math.random()*n);
            int temp = arrSudoku[0][j];
            arrSudoku[0][j]=arrSudoku[0][seed];
            arrSudoku[0][seed]=temp;
        }

        // 1~(n-1)행 랜덤하게 섞기
        for (int i= 1; i<(n-1); i++){
            for (int j = 0; j<n; j++) {

                // j열, i-1 번째 행까지의 값을 담은 배열 생성 -> [i][j] 값과 비교
                int[] compare = new int[i];
                for (int k = 0; k<i; k++){
                    compare[k] = arrSudoku[k][j];
                }

                // compare 배열 출력
                for(i=0; i<compare.length; i++){
                    System.out.print(compare[i]);
                }
                System.out.print(" ");

                // 랜덤 index 생성
                do {
                    int random = (int) (Math.random() * (n-j));
                    int seed = random + j;
                    int temp = arrSudoku[i][j];
                    arrSudoku[i][j] = arrSudoku[i][seed];
                    arrSudoku[i][seed] = temp;
                    // System.out.println("\narrSudoku[i][j]=" + arrSudoku[i][j] + " index=" + Arrays.binarySearch(compare, arrSudoku[i][j]));
                } while (Arrays.binarySearch(compare, arrSudoku[i][j]) >= 0);
            }
            System.out.println("\n");
        }

        //n행 배치
        for (int j= 0; j<n; j++){
            int[] compare = new int[n-1];
            for (int i = 0; i<n-1; i++){
                compare[i] = arrSudoku[i][j];
            }
            for (int k=1; k<=n; k++){
                arrSudoku[n-1][j] = k;
                if (Arrays.binarySearch(compare,arrSudoku[n-1][j]) >=0)
                    break;
            }
        }

        long end = System.currentTimeMillis();

        for (int i = 0; i< arrSudoku.length; i++){
            for (int j = 0; j< arrSudoku.length; j++){
                System.out.print(arrSudoku[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("\n연산 시간 "+(end - start)/1000.0 + "초 소요되었습니다.");
    }
}
