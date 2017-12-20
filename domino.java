
/**
 * Write a description of class domino here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class domino
{
    public static void reset()
    {
        int [] [] board = new int[8][8];

        int corners = -1;
        int dom = 1;
        int no = 1;
        int chance = (int)(Math.random() *7 +1);

        board [chance][chance] = dom;
        board [chance] [chance+1]= no;

        board[0] [0] = corners;
        board[7] [0] = corners;
        board[0] [7] = corners ;
        board[7] [7] = corners;
        int counter = 0;
        ;
        for(int x = 0; x<board.length; x++)
        {
            System.out.println(" ");
            for(int y = 0; y<board[0].length; y++)
            {
                System.out.print (board[x][y]);

            }

        }
    }

    public static void moveing()
    {
        int [] [] board = new int[8][8];

        int corners = -1;
        int counter = 0;
        int counter2 = 0;
        board[0] [0] = corners;
        board[7] [0] = corners;
        board[0] [7] = corners ;
        board[7] [7] = corners;
        int dom = 1;
        int no = 1;
        while(dom<32 && no<32)
        {

            int ranDom = (int)(Math.random() *7 );
            int ranDo = (int)(Math.random() *7 );

            if(ranDom < board.length-1 && ranDo < board[0].length-1 && ranDom > 0 && ranDo > 0)
            {

                //Is it in bounds? if yes below
                if(board[ranDom] [ranDo] == 0 )
                {
                    //is the space empty? if yes continue below

            
            
                    //STATESMENTS RESPONSIBLE FOR ALL POSSIBLE ORIENTATIONS OF DOMINO
                    //          (BEAR IN MIND THE DOMINO IS TWO ARRAY SPACES IN LENGTH TOTAL)

                    //        STATEMENTS ABOVE CHECK FOR AVALIABLE SPACE(ONE SPACE)   
                    //        

                    //        STATEMENTS BELOW CHECK TO SEE IF ANOTHER AJECENT SPACE IS OPEN
                    //        (TOTAL OF 2 SPACES)
                    if(board[ranDom +1] [ranDo] == 0)
                    {
                        board[ranDom][ranDo] = dom++;
                        board[ranDom +1] [ranDo] = no++;
                    }

                    else if(board[ranDom -1] [ranDo] == 0)
                    {
                        board[ranDom][ranDo] = dom++;
                        board[ranDom -1] [ranDo] = no++;

    
                    }
                    else if(board[ranDom] [ranDo+1] == 0)
                    {
                        board[ranDom][ranDo] = dom++;
                        board[ranDom] [ranDo +1] = no++;

    
                    }
                    else if(board[ranDom] [ranDo-1] == 0)
                    {
                        board[ranDom][ranDo] = dom++;
                        board[ranDom] [ranDo -1] = no++;

    
                    }



                    //RESETS METHOD IF SPACES DO NOT CONFORM  
                }
                else 
                {
                    counter++;
                    moveing();
                }
            }

            // IF STUCK INDEFINETLY, CALLS RESETS METHOD IN ORDER TO TRY AGAIN
            if(counter>1000)
            {
                reset();
                counter2++;
            }
            // IF "IMPOSSIBLE"  PRINTS THIS MESSAGE...
            if(counter2>3)
            {
                System.out.print("it's too much... way too much");
            }

    


            //prints array if while loop completed
            for(int row = 0; row < board.length; row++)
            {
                System.out.println(" ");
                for(int col = 0; col<board[0].length; col++)
                {
                    System.out.print(board[row][col]);

                }
            }
        }
    }


    public static void main (String [] args)
    {

    
    }
}

