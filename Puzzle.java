import java.util.Scanner;
import java.util.InputMismatchException;
public class Puzzle {
    int[][] mat;
    boolean found = false;
    int x;
    String path = "";

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
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        boolean found = findpath(0, 0, 0, visited, path);
        if(found){
            System.out.println("Jalur yang ditemukan: ");
            path = path.substring(4,path.length());
            System.out.println(path);
        } else {
            System.out.println("Jalur tidak ditemukan.");
        }
    }

    public boolean findpath(int row, int col, int sum, boolean[][] visited, String path){
        int m = mat.length;
        int n = mat[0].length;
        if(sum >= x){
            this.path = path;
            return true;
        }

        if(row < 0 || row >= m || col < 0 || col >= n || visited[row][col]){
            return false;
        }

        visited[row][col] = true;

        if(col + 1 < n && findpath(row, col + 1, sum + mat[row][col], visited, path + " -> (" + row + "," + col + ")")){
            return true;
        }
        if(row + 1 < m && findpath(row+1, col, sum + mat[row][col], visited, path + " -> (" + row + "," + col + ")")){
            return true;
        }
        if(row + 1 < m && col + 1 < n && findpath(row + 1, col + 1, sum + mat[row][col], visited, path + " -> (" + row + "," + col + ")")){
            return true;
        }
        return false;
    }

}