import java.util.*;
import java.util.stream.Stream;

/**
    Matrix-adding algorithm implemented in parallel and sequential fashion.

    Comparing performance.
 **/

public class Main {

    private static List<List<Integer>> matrixA = generateMatrixOne();
    private static List<List<Integer>> matrixB = generateMatrixTwo();
    private static List<List<Integer>> result = new ArrayList<>();
    private static long startTime = 0;
    private static long endTime = 0;

    private static void printMatrix(List<List<Integer>> matrix) {
        StringBuilder strRepresentation = new StringBuilder();

        for (List<Integer> row : matrix ) {
            for (Integer element : row) {
                strRepresentation.append(String.format("%5s", element));
            }

            strRepresentation.append("\n");
        }

        System.out.println(strRepresentation);
    }

    private static void printTimeTaken(long startTime, long endTime) {
        long timeTaken = endTime - startTime;

        System.out.println("The calculation took " + timeTaken + "ms.");
    }

    private static List<List<Integer>> generateMatrixOne() {
        List<List<Integer>> matrix = new ArrayList<>();
        List<Integer> row1 = Arrays.asList(1, 2, 3);
        List<Integer> row2 = Arrays.asList(4, 5, 6);
        List<Integer> row3 = Arrays.asList(7, 8, 9);

        matrix.add(row1);
        matrix.add(row2);
        matrix.add(row3);

        return matrix;
    }

    private static List<List<Integer>> generateMatrixTwo() {
        List<List<Integer>> matrix = new ArrayList<>();
        List<Integer> row1 = Arrays.asList(9, 8, 7);
        List<Integer> row2 = Arrays.asList(6, 5, 4);
        List<Integer> row3 = Arrays.asList(3, 2, 1);

        matrix.add(row1);
        matrix.add(row2);
        matrix.add(row3);

        return matrix;
    }

    private static void timeSequentialAddition(int iterationLimit) {
        startTime = System.currentTimeMillis();

        for (int iteration = 0; iteration < iterationLimit; iteration++) {
            result = MatrixManipulator.addMatrices(matrixA, matrixB);
        }

        endTime = System.currentTimeMillis();
        System.out.print("Sequentially " + iterationLimit + " times: ");
        printTimeTaken(startTime, endTime);
    }

    private static void timeConcurrentAddition(int iterationLimit) {
        startTime = System.currentTimeMillis();

        for (int iteration = 0; iteration < iterationLimit; iteration++) {
            result = ParallelMatrixManipulator.addMatrices(matrixA, matrixB);
        }

        endTime = System.currentTimeMillis();
        System.out.print("Concurrently " + iterationLimit + " times: ");
        printTimeTaken(startTime, endTime);
    }

    public static void main(String[] args) {
        int iterationLimit = 1_000_000;

        // ---- Printing the Matrices
        printMatrix(matrixA);
        System.out.println("+");
        printMatrix(matrixB);
        System.out.println("=");
        printMatrix(MatrixManipulator.addMatrices(matrixA, matrixB));

        // ---- Sequentially adding the Matrices
        timeSequentialAddition(iterationLimit);

        // ---- Parallel adding of the Matrices
        timeConcurrentAddition(iterationLimit);
    }
}
