import java.util.*;

public class MatrixManipulator {
    private MatrixManipulator() {}

    public static List<List<Integer>> addMatrices(List<List<Integer>> matrixA, List<List<Integer>> matrixB) {
        List<List<Integer>> result = new ArrayList<>();

        int matrixWidth = matrixA.size();
        int matrixHeight = matrixA.get(0).size();

        for (int row = 0; row < matrixHeight; row++) {
            List<Integer> resultingRow = new ArrayList<>();

            for (int elementIndex = 0; elementIndex < matrixWidth; elementIndex++) {
                Integer resultingElement = matrixA.get(row).get(elementIndex) + matrixB.get(row).get(elementIndex);
                resultingRow.add(resultingElement);
            }

            result.add(resultingRow);
        }

        return result;
    }
}
