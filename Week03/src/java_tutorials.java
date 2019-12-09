import java.util.*;

public class java_tutorials {
    public static void main(String[] args) {
        /*int i=0;
        int j=0;
        while(i<100)
        {
            j=j+i;
            i++;
            System.out.println(i); System.out.println(j);
        }*/

        /*int h = 5; //공간 높이
        int w = 100; //공간 너비

        for(int i=0; i<h; i++){
            for(int j=0; j<w-1; j++){
                System.out.print("□");
            }
            System.out.println("□");
        }

        double pi = Math.PI;
        System.out.print(Math.sin(0.4*pi));

         for(int i=0; i<100;i++){
            System.out.println(i);
        }
        */

        // 배열 array
        int[] numbers1 = new int[4];
        numbers1[0]=10;
        numbers1[1]=20;
        numbers1[2]=30;

        int[] numbers2 = {10, 20, 30, 40};
        int[] numbers3 = new int[]{10, 20, 30, 40};

        /*for(int i=1; i<5; i++){
            String name = "numbers"+i;
            System.out.println(Arrays.toString(name));
        }
        System.out.println(Arrays.toString(numbers1));

         */
/*
        int i=0;
        while(numbers1.length > i){
            System.out.println(numbers1[i]);
            i++;
        }

        for(i=0; i<numbers1.length; i++){
            System.out.println(numbers2[i]);
        }

 */
        //Get the jvm heap size
        long heapSize = Runtime.getRuntime().totalMemory()/(1024*1024);
        //Print the jvm heap size
        System.out.println("Heap Size = "+heapSize+"MB");

/*
        int num = (int)(Math.random()*n) +1; // 랜덤 스도쿠 첫 번째 수(arrSudoku[0][0]). 랜덤 함수로 1~n 사이 임의의 수 생성

        for (int i = 0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                arrSudoku[i][j] =num;
                num = (int)(Math.random()*n) +1;
            }
        }

        int[] compare = {0, 0, 0, 0, 0};
        int[][] arr = new int[5][5];

        for (int i = 0; i<5; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] =j+1;
            }
        }

        System.out.println(Arrays.binarySearch(compare, arr[2][3]));

        List a = new ArrayList();
        for(int i=1; i<=10; i++){
            a.add(i);
        }
        System.out.println(a);

        a.remove();
        System.out.println(a);
*/
    }
}
