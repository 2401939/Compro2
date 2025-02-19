package com.Salazar;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //ask the user to input the size
        System.out.print("Enter the size of the square matrix (n): ");
        int n = in.nextInt();

        //2D array
        int[][] matrix = new int[n][n];

        //input the elements of the matrix
        System.out.println("Enter the elements of the Matrix: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        //calculate the sum of primary and secondary diagonal
        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;

        for (int i = 0; i < n; i++){
            primaryDiagonalSum += matrix [i][i]; // The sum of Primary
            secondaryDiagonalSum += matrix[i][n - i - 1]; //The sum of secondary
        }

        //output
        System.out.print("Sum of the primary diagonal: " + primaryDiagonalSum);
        System.out.print("\nSum of the secondary diagonal: "+ secondaryDiagonalSum);
    }
}
