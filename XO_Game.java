/*
Created by : This game was created by `tamil-selvan-v`.
Repository name : `casual-codes`  repo.
About : XO game created in Java language.
*/
import java.util.Scanner;

public class XO_Game{
    //const
    static char[][] boardVal = {{'1','2','3'},{'4','5','6'},{'7','8','9'}}; //board initial val
    static int boardFillingCount = 0;


    //to print the main board
    public static void printBoard(){
        String players = "\n\n\nXO GAME : Player A: X  Player B: O\n\n";
        String board = boardVal[0][0]+" | "+boardVal[0][1]+" | "+boardVal[0][2]
                        +"\n---------\n"
                        +boardVal[1][0]+" | "+boardVal[1][1]+" | "+boardVal[1][2]
                        +"\n---------\n"
                        +boardVal[2][0]+" | "+boardVal[2][1]+" | "+boardVal[2][2]+"\n";
        System.out.println(players+board);
    }


    //to insert values X and O
    public static boolean insert_X(char x_pos){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(x_pos == (boardVal[i][j])){
                    boardVal[i][j] = 'X';
                    boardFillingCount++;
                }
            }
        }
        return (boardFillingCount==9)?true:false;  
        //check for is the board is filled when X entered last for TIE check

    }
    public static boolean insert_O(char y_pos){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(y_pos == (boardVal[i][j])){
                    boardVal[i][j] = 'O';
                    boardFillingCount++;
                }
            }
        }
        return (boardFillingCount==9)?true:false;  
        //check for is the board is filled when O entered last for TIE check
    }


    //checking for game result A_win: return 1 B_win: return 2 
    public static int checkForGameResult(){

        //check for rows 
        for(char[] row: boardVal){
            int x_count  = 0;
            int o_count = 0;
            for (char c : row) { 
                //for all X
                if(c=='X'){
                    x_count++;
                }
                if(x_count==3){
                    return 1;
                }
                //for all O 
                if(c=='O'){
                    o_count++;
                }
                if(o_count==3){
                    return 2;
                } 
            }
        }

        //check for columns
        for(int i=0; i<3; i++){
            int x_count=0;
            int o_count=0;
            for(char[] row: boardVal){
                if(row[i]=='X'){
                    x_count++;
                }
                if(row[i]=='O'){
                    o_count++;
                }
                if(x_count==3){
                    return 1;
                }
                if(o_count==3){
                    return 2;
                }
            }
        }

        
        //check for diagonals

        //for diagonal X check
        int x = 0; //forward right down \ check
        int x_count=0;
        for(char[] row: boardVal){
            if(row[x]=='X'){
                x_count++;
            }
            if(x_count==3){
                return 1;
            }
            x++;
        }
        x = 2; //backward left down / check
        x_count=0;
        for(char[] row: boardVal){
            if(row[x]=='X'){
                x_count++;
            }
            if(x_count==3){
                return 1;
            }
            x--;
        }

         //for diagonal O check
        int o = 0; //forward right down \ check
        int o_count=0;
        for(char[] row: boardVal){
            if(row[o]=='O'){
                o_count++;
            }
            if(o_count==3){
                return 2;
            }
            o++;
        }
        
        o = 2; //for left down / check
        o_count=0;
        for(char[] row: boardVal){
            if(row[o]=='O'){
                o_count++;
            }
            if(o_count==3){
                return 2;
            }
            o--;
        }
        
        return 0; //it will not work..
    }


    public static void main(String[] args) {
        //init obj
        Scanner in = new Scanner(System.in); 

        printBoard();

        //game loop
        int input_i = 0;
        boolean BoardFilled;
        int GameRes;
        while(input_i<=4){

            //input val for player A :X
            System.out.print("Player A: (X) Enter number :");
            char x_pos = in.next().charAt(0); //input a char
            //input_set.add(x_pos); not now
            BoardFilled = insert_X(x_pos);
            //printing board
            printBoard();

            //check for win or tie
            GameRes = checkForGameResult();
            if(GameRes==1){
                System.out.println("Player A WON THE GAME..!\n\n");
                break;
            }
            else if(GameRes==2){
                System.out.println("Player B WON THE GAME..!\n\n");
                break;
            }

            else if(BoardFilled){
                System.out.println("GAME TIE.. :<\n\n");
                break;
            }

            
            
            //input val for player B :O
            System.out.print("Player B: (O) Enter number :");
            char y_pos = in.next().charAt(0);
            BoardFilled = insert_O(y_pos);
            //printing board
            printBoard();

            //check for win or tie
            GameRes = checkForGameResult();
            if(GameRes==1){
                System.out.println("Player A WON THE GAME..!");
                break;
            }
            else if(GameRes==2){
                System.out.println("Player B WON THE GAME..!");
                break;
            }
            else if(BoardFilled){
                System.out.println("GAME TIE.. :<");
                break;
            }

            //input_check < 4
            input_i++;
    }
}
}
