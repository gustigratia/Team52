import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Masukkan ukuran matriks (n m):");
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] mat = new int[m][n];
        for(int i = 0;i< mat.length;i++){
            for(int j = 0;j<mat[i].length;j++){
                mat[i][j] = (byte) (10 * Math.random() + 1);
            }
        }

        for(int i = 0;i< mat.length;i++){
            for(int j = 0;j<mat[i].length;j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Masukkan target penjumlahan:");
        int x = sc.nextInt();

        // Algoritma coming soon...


        // Generate Output:
    }
}

