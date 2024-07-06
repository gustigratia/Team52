import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.List;
public class Puzzle {
    int[][] mat;
    boolean found = false;
    int x;

    public Puzzle(){
        boolean notValid = false;
        Scanner sc;
        do{
            try {
                notValid = false;
                sc = new Scanner(System.in);
                System.out.println("Masukkan ukuran matriks (n m):");
                int m = sc.nextInt();
                int n = sc.nextInt();
                this.mat = new int[m][n];
            }
            catch (InputMismatchException e){
                notValid = true;
            }
        }
        while(notValid);

        generateMat();
        printMat();
        do{
            try{
                notValid = false;
                sc = new Scanner(System.in);
                System.out.println("Masukkan target penjumlahan:");
                this.x = sc.nextInt();
            }
            catch (InputMismatchException e){
                notValid = true;
            }
        }
        while(notValid);
    }

    public void generateMat(){
        for(int i = 0;i< mat.length;i++){
            for(int j = 0;j<mat[i].length;j++){
                mat[i][j] = (byte) (10 * Math.random() + 1);
            }
        }
    }

    public void printMat(){
        for(int i = 0;i< mat.length;i++){
            for(int j = 0;j<mat[i].length;j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void solve() {
        boolean found = findpath(0, 0, x, 0);
        if (found) {
            System.out.println("Jalur ditemukan: ");
        } else {
            System.out.println("Jalur tidak ditemukan.");
        }
    }

    public boolean findpath(int row, int col, int target, int sum){
        if(row == mat.length -1 && col == mat[0].length-1){
            return sum + mat[row][col] == target;
        }
        if(row < 0 || row >= mat.length || col < 0 || col >= mat[0].length){
            return  false;
        }

        sum += mat[row][col];

        if(findpath(row+1,col, target, sum) || findpath(row, col+1, target, sum)){
            System.out.println(mat[row][col] + " ");
            return true;
        }

        return false;
    }

}
