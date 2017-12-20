
/**
 * Write a description of class chessMk3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class chessMk3
{
    public static void chessboard()
    {
        int completedMoves = 1;
        int tries = 1;
        boolean isValidMove = false;
        int[][] board = new int[8][8];
        int stop = 0;
        int moves[][] = {{2,1},
                {2,-1},
                {-2,1},
                {-2,-1},
                {1,2},
                {1,-2},
                {-1,2},
                {-1,-2}};
        int chance = 0;
        int row = (int)Math.random() * 8;
        int col = (int)Math.random() * 8;
        board[row][col] = completedMoves;
        boolean doneMove = false;
        while(completedMoves < 64 && stop != 1)
        {  
            doneMove = false;
            isValidMove = false;
            for(int cRow = 0; cRow < 8; cRow++)
            {
                if(moves[cRow][0] + row >= 0 && moves[cRow][0] + row < 8 && moves[cRow][1] + col >= 0 && moves[cRow][1] + col < 8)
                {
                    if(board[moves[cRow][0] + row][moves[cRow][1] + col] == 0)
                    {
                        isValidMove = true;
                    }
                }
            }
            if(isValidMove == false)
            {
                
                for(int ab = 0; ab < board.length; ab++)
                {
                    for(int ba = 0; ba < board[0].length; ba++)
                    {
                        board[ab][ba] = 0;
                    }
                }
                row = (int)(Math.random() * 8);
                col = (int)(Math.random() * 8);
                if(tries % 1000 == 0)
                {
                    System.out.println("Failed to move again after: " + completedMoves + "moves! Thus round " + tries + " is over. Resetting Board!");
                }
                tries++;
                completedMoves = 1;
                board[row][col] = completedMoves;
            }
            else
            {
                while(doneMove == false)
                {
                    chance = (int)(Math.random() * 8);
                    if(moves[chance][0] + row >= 0 && moves[chance][0] + row < 8 && moves[chance][1] + col >= 0 && moves[chance][1] + col < 8)
                    {
                        if(board[row + moves[chance][0]][col + moves[chance][1]] == 0)
                        {
                            completedMoves++;
                            row += moves[chance][0];
                            col += moves[chance][1];
                            board[row][col] = completedMoves;
                            doneMove = true;
                        }
                    }
                }
                
            }
            
        }
        System.out.println("Success! Round " + tries + " filled the entire board by doing " + completedMoves + " moves! System will now print completed board!");
        //once loop is complete, it prints the array
        for(int ab = 0; ab < board.length; ab++)
        {
            for(int ba = 0; ba < board[0].length; ba++)
            {
                System.out.print(board[ab][ba]);
                System.out.print(" ");
            }
            System.out.println (" ");
        }
    }
}

