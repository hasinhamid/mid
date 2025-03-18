package mid;

public class d {
    public static void main(String[] args) {
          // Hardcoded 4x4 matrix
          int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);
        
        // Rotate outer cells
        int [][] l=rotate(matrix);
        
        System.out.println("\nMatrix After Rotating Outer Cells Anticlockwise:");
        printMatrix(l);
    } 
    // Function to print the matrix
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] rotate(int[][] arr){
        int col=arr[0].length-1;
        int row=arr.length-1;
        for(int i=0;i<row;i++){
            int temp=arr[i][0];
            arr[i][0]=arr[0][col-i];
            arr[0][col-i]=arr[row-i][col];
            arr[row-i][col]=arr[row][i];
            arr[row-i][i]=temp;
        }
        return arr;
    }
}
