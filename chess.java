
/**
 * Write a description of class chess here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class chess
{
    public static void chessboard()
    {
        int start = 1;
        int[][] board = new int [8][8];
        int counter = 0;
        int counter2 = 1;
        int row = 0;
        int col = 0;
        int stop = 0;
        int allChances = 0;
        boolean[] chances = new boolean[8];
        row = (int)(Math.random() * board.length-1);
        col = (int)(Math.random() * board[0].length-1);

        while(start < 63 && stop != 1)
        {   
        board[row][col] = start;
        int chance = (int)(Math.random() * 8 +1);
        int chanceRow = 0;
        int chanceCol = 0;


            //Defines chance Variable
            if(chance ==1)
            {
                chanceRow = 2;
                chanceCol =1;
                chances[chance-1] = true;
            }
            else if(chance ==2)
            {
                chanceRow = 2;
                chanceCol = -1;
                chances[chance-1] = true;
            }
            else if(chance ==3)
            {   chanceRow = -2;
                chanceCol = 1;
                chances[chance-1] = true;
            }
            else if(chance ==4)
            {
                chanceRow =-2;
                chanceCol = -1;
                chances[chance-1] = true;
            }
            else if(chance ==5)
            {
                chanceRow = 1;
                chanceCol = 2;
                chances[chance-1] = true;
            }
            else if(chance ==6)
            {
                chanceRow = 1;
                chanceCol = -2;
                chances[chance-1] = true;
            }
            else if(chance ==7)
            {
                chanceRow = -1;
                chanceCol = 2;
                chances[chance-1] = true;
            }
            else if(chance == 8)
            {
                chanceRow= -1;
                chanceCol= -2;
                chances[chance-1] = true;
            }
            else
            {
                System.out.println("error");
            }

            //Check if the position of the knight plus the random 
            //new row and col value are in bounds

            if( 0 <= row + chanceRow && row + chanceRow < board.length)
            {
                row = row + chanceRow; //updates row of knight
                if( 0 <= col + chanceCol && col + chanceCol < board[0].length-1)
                {
                    col = col + chanceCol;

                    if(board[row][col] == 0)
                    {
                        board [row] [col] = start;
                        start++;
                        chanceRow = 0;
                        chanceCol = 0;
                        //updates start
                        //updates position of knight
                        //updates col of kight
                    }
                    else
                    {
                        for(int j = 0; j < 8; j++)
                        {
                            boolean b = chances[j];
                            if(b == false)
                            {
                                allChances = 0;
                            }
                            else
                            {
                                allChances++;
                            }
                        }
                        if(allChances != 8)
                            allChances = 0;
                    }
                }
            }

            else 
            {
                counter++;
                chanceRow = 0;
                chanceCol = 0;
                //goes to reset method if first if statement not true
            }

            if(allChances == 8)
            {
                allChances = 0;
                counter++;
                if(counter2 % 5000 == 0)
                    System.out.println("Run number: " + counter2 + " has completed" + start);
                board = new int [8] [8];

                start = 1;
                row = (int)(Math.random() * board.length-1);
                col = (int)(Math.random() * board[0].length-1);
                board [row] [col]  = start;
                for(int i = 0; i < 8; i++)
                {
                    chances[i] = false;
                }
                counter2++;
                if(counter2 ==50000000)
                {
                    System.out.print("it's....too.....much");
                    stop = 1;
                }
            }
        }  
        System.out.println("Finished");
        //once loop is complete, it prints the array
        for(int ab = 0; ab < board.length ; ab++)
        {
            for(int ba = 0; ba < board[0].length; ba++)
            {
                System.out.print(board[ab][ba]);
            }
            System.out.println("");
        }
    }

    
    public static void reset()
    {
        //reset method contain all original values from chessboard method
        int board [] [] = new int [8] [8];

        int start = 1;
        int row = (int)(Math.random() * board.length-1);
        int col = (int)(Math.random() * board[0].length-1);
        board [row] [col]  = start;

        
    }
}

