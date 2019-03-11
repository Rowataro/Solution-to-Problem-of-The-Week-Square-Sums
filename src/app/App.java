package app;

import java.util.ArrayList;

/*
    This program is a brute force approach to solving this math problem:
P
        Pat squared two different positive integeres and added the results. 
        Although Jordan did the same thing and got the same sum, S, Jordan's integers were different from Pat's.
        What is the least possible value of S?
*/

public class App {

    public static void main(String[] args) throws Exception {
        findAnswer();
        printSolution();
    }

    private static void findAnswer() {
        initializeSquares();
        for (int index = 1; index <= integersToTest; ++index) {
            for (int subIndex = index + 1; subIndex <= integersToTest; ++subIndex) {
                int originalSquare1 = squares.get(index);
                int originalSquare2 = squares.get(subIndex);
                int sum = originalSquare1 + originalSquare2;

                for (int subIndex2 = index + 1; subIndex2 <= integersToTest; ++subIndex2) {
                    int newSquare1 = squares.get(subIndex2);

                    if (newSquare1 != originalSquare2) // This condition ensures that newSquares will not form a
                                                       // duplicate pair of originalSquares.
                    {
                        int newSquare2 = sum - newSquare1;
                        if (isSquareRootAPositiveInteger(newSquare2) && newSquare1 != newSquare2) {
                            pairsOfSolutions.add(originalSquare1);
                            pairsOfSolutions.add(originalSquare2);
                            pairsOfSolutions.add(newSquare1);
                            pairsOfSolutions.add(newSquare2);
                            answer = originalSquare1 + originalSquare2;
                            return;
                        }
                    }
                }
            }
        }
    }

    private static void initializeSquares() {
        for (int index = 0; index <= integersToTest; ++index) {
            squares.add(index * index);
        }
    }

    private static boolean isSquareRootAPositiveInteger(int number) {
        return Math.sqrt(number) % 1 == 0;
    }

    private static void printSolution() {

        System.out.println("The sum S is " + answer + ", which can be summed with the following perfect squares: ");
        for (int index = 0; index <= pairsOfSolutions.size() - 2; index += 2) {
            System.out.println("  " + pairsOfSolutions.get(index) + " and " + pairsOfSolutions.get(index + 1));
        }

    }

    private static int integersToTest = 12;
    private static ArrayList<Integer> squares = new ArrayList<>();

    private static ArrayList<Integer> pairsOfSolutions = new ArrayList<>();
    private static int answer;
}