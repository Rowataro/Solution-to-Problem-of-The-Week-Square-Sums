package app;

import java.util.ArrayList;

public class App {   
    
    public static void main(String[] args) throws Exception 
    {
        findAnswer();
        printSolution();
    }
    private static void findAnswer()
    {
        initializeSquares();
        for(int index = 1; index <= n; ++index)
        {
            for(int subIndex = index + 1; subIndex <= n; ++subIndex)
            {
                int sum = squares.get(index) + squares.get(subIndex);
                for(int subIndex2 = 1; subIndex2 <= n; ++subIndex2)
                {
                    if(subIndex2 != index && subIndex2 != subIndex && Math.sqrt(sum - squares.get(subIndex2)) != subIndex2)
                    {
                        if( Math.sqrt(sum - squares.get(subIndex2)) % 1 == 0)
                        {
                            pairs.add(squares.get(index));
                            pairs.add(squares.get(subIndex));
                            pairs.add(squares.get(subIndex2));
                            pairs.add(sum-squares.get(subIndex2));
                            answer = squares.get(index) + squares.get(subIndex);
                            return;
                        }
                    }
                }
            }
        }

    }
    private static void initializeSquares()
    {
        for(int index = 0; index <= n; ++index)
        {
            squares.add(index*index);
        }
    }
    private static void printSolution()
    {

            System.out.println("The sum is " + answer + ", which can be found with the following perfect squares: ");
            for(int index = 0; index <= pairs.size() - 2; index +=2)
            {
                System.out.println("  " + pairs.get(index) + " and " + pairs.get(index + 1));
            }
    
    }

    private static int n = 100;
    private static ArrayList<Integer> pairs= new ArrayList<>();
    private static ArrayList<Integer> squares= new ArrayList<>();
    private static int answer;
}