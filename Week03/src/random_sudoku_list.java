import java.util.*;
/*
랜덤 스도쿠 생성
임의의 자연수 n을 입력받고 n*n 배열을 채우는 스도쿠를 생성
 */

public class random_sudoku_list {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = 0; // 스도쿠 크기

        // n 입력 받기
        System.out.println("랜덤 스도쿠를 생성합니다.");
        System.out.println("원하는 숫자를 자연수로 입력해주세요. (ex. 10)");
        n = input.nextInt();

        int[][] arrSudoku = new int[n][n]; // n*n 배열 선언
        List all = new ArrayList<>(); // 전체 List 선언. 비교군 역할
        List possible = new ArrayList<>(); // 후보군 List 선언

        // all List 1~n 자연수 추가
        for(int i=1; i<=n; i++){
            all.add(i);
        }
        // System.out.println(all);

        long start = System.currentTimeMillis(); // 연산 시작
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

        // 이전코드 set 구분 없이 2행~n행 배치
        /*
        for (int i = 1; i<n; i++){ //세로 위에서 아래 순서대로 내려감
            for (int j = 0; j<n; j++){ //가로 왼쪽에서 오른쪽 순서대로

                // [i][j] 값으로 선택 가능한 값들의 리스트 생성
                possible.addAll(all); // potential 리스트 초기화

                // naked single(열): j열 내에서 중복 제거
                for (int k = 0; k < i; k++) { // 1행(k=0)부터 i행(k=i-1)까지
                    if (possible.contains(arrSudoku[k][j])) { //arrSudoku[k][j] 값을 가지고 있다면,
                        possible.remove((Integer)arrSudoku[k][j]); // 해당 값을 가지는 element 삭제
                    }
                }

                // naked single(행): i행 내에서 중복 제거
                for (int k = 0; k < j; k++) { // 1열(k=0)부터 j열(k=i-1)까지
                    if (possible.contains(arrSudoku[i][k])) { //arrSudoku[k][j] 값을 가지고 있다면,
                        possible.remove((Integer)arrSudoku[i][k]); // 해당 값을 가지는 element 삭제
                    }
                }

                // possible 리스트 랜덤 셔플
                Collections.shuffle(possible);
                // System.out.println(possible);

                // arrSudoku[i][j] 값 지정
                if (possible.size()>0){ //리스트 값이 1개 이상이면 실행
                    arrSudoku[i][j] = (int) possible.get(0);
                } else {
                    j=0;
                }
                possible = new ArrayList(); // row 리스트 초기화
            }
        }
         */

        // set 1: 왼쪽위 절반
        for (int i = 1; i<n; i++){ //세로 위에서 아래 순서대로 내려감
            for (int j = 0; j<(n-i); j++){ //가로 왼쪽에서 오른쪽 순서대로

                // [i][j] 값으로 선택 가능한 값들의 리스트 생성
                possible.addAll(all); // potential 리스트 초기화

                // naked single(열): j열 내에서 중복 제거
                for (int k = 0; k < i; k++) { // 1행(k=0)부터 i행(k=i-1)까지
                    if (possible.contains(arrSudoku[k][j])) { //arrSudoku[k][j] 값을 가지고 있다면,
                        possible.remove((Integer)arrSudoku[k][j]); // 해당 값을 가지는 element 삭제
                    }
                }

                // naked single(행): i행 내에서 중복 제거
                for (int k = 0; k < j; k++) { // 1열(k=0)부터 j열(k=i-1)까지
                    if (possible.contains(arrSudoku[i][k])) { //arrSudoku[k][j] 값을 가지고 있다면,
                        possible.remove((Integer)arrSudoku[i][k]); // 해당 값을 가지는 element 삭제
                    }
                }

                // possible 리스트 랜덤 셔플
                Collections.shuffle(possible);
                // System.out.println(possible);

                // arrSudoku[i][j] 값 지정
                if (possible.size()>0){ //리스트 값이 1개 이상이면 실행
                    arrSudoku[i][j] = (int) possible.get(0);
                }
                possible = new ArrayList(); // row 리스트 초기화
            }
        }

        // set 2: 오른쪽 아래 절반
        for (int i = 1; i<n; i++){ //세로 위에서 아래 순서대로 내려감
            for (int j = (n-i-1); j<n; j++){ //가로 왼쪽에서 오른쪽 순서대로

                // [i][j] 값으로 선택 가능한 값들의 리스트 생성
                possible.addAll(all); // all 리스트 potential 리스트로 깊은 복사

                // naked single(열): j열 내에서 중복 제거
                for (int k = 0; k < i; k++) { // 1행(k=0)부터 i행(k=i-1)까지
                    if (possible.contains(arrSudoku[k][j])) { //arrSudoku[k][j] 값을 가지고 있다면,
                        possible.remove((Integer)arrSudoku[k][j]); // 해당 값을 가지는 element 삭제
                    }
                }

                // naked single(행): i행 내에서 중복 제거
                for (int k = 0; k < j; k++) { // 1열(k=0)부터 j열(k=i-1)까지
                    if (possible.contains(arrSudoku[i][k])) { //arrSudoku[k][j] 값을 가지고 있다면,
                        possible.remove((Integer)arrSudoku[i][k]); // 해당 값을 가지는 element 삭제
                    }
                }

                // possible 리스트 랜덤 셔플
                Collections.shuffle(possible);
                // System.out.println(possible);

                // arrSudoku[i][j] 값 지정
                if (possible.size()>0){ //리스트 값이 1개 이상이면 실행
                    arrSudoku[i][j] = (int) possible.get(0);
                } else {
                    // i = (i-1);
                    j= (n-i-1);
                }
                possible = new ArrayList(); // possible 리스트 초기화
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
