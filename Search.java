import java.io.*;
import java.util.*;
import javax.sql.RowSetInternal;

public class Search {

    public static void main(String[] args) {
        char board[][] = new char[10][10];
        //String searchedWord = "";

        Scanner fin = null;
        try {
            fin = new Scanner(new File("wordSearch1.txt"));
        }
        catch (FileNotFoundException x) {
            System.out.println("File open failed.");
            x.printStackTrace();
            System.exit(0);   // TERMINATE THE PROGRAM
        }
        String line;
        int r = 0;
        board = new char[10][10];
        
        while (fin.hasNextLine()) {
            line = fin.nextLine();
            if (line.equals("")){
                break;
            }
            System.out.println(line);
            board[r] = line.toCharArray();
            r++;

        }

        System.out.println("\n");
        while (fin.hasNextLine()){
            line = fin.nextLine();
            System.out.print(line);

            Search search = new Search();
            boolean found = false;

            found = found || search.checkRight(board, line);
            found = found || search.checkLeft(board, line);
            found = found || search.checkDown(board, line);
            found = found || search.checkUp(board, line);
            found = found || search.checkDiagonalUpRight(board, line);
            found = found || search.checkDiagonalUpLeft(board,line);
            found = found || search.checkDiagonalDownRight(board, line);
            found = found || search.checkDiagonalDownLeft(board, line);
            if (!found) {
              System.out.println(" not found");
            }
            
        }
    }

    public boolean checkRight(char [][]board, String searchedWord){
      for (int row = 0; row < board.length; row++) {
        for (int col = 0; col < board[row].length; col++) {
        // search to the right
          if (col + (searchedWord.length()-1) < board[row].length) {
            //boolean wordFound = true;
            for (int letters = 0; letters < searchedWord.length(); letters++) {
              if (searchedWord.charAt(letters) != board[row][col+letters]) {
                break;
              }
              if(letters == searchedWord.length() - 1 ){
                System.out.println( " found at: " + row + ", " + col + " end at: " + (row+letters) + ", " + (col+letters) );
                return true;
              }
              
            }
          }
        }
      }
      return false;
    }


    public boolean checkLeft(char [][]board, String searchedWord){
      for (int row = 0; row < board.length; row++) {
        for (int col = 0; col < board[row].length; col++) {
          if (col - (searchedWord.length()-1) >= 0) {
          for (int letters = 0; letters < searchedWord.length(); letters++) {
            if (searchedWord.charAt(letters) != board[row][col-letters]) {
              break;
            }
            if(letters == searchedWord.length() - 1){
                System.out.println(" found at: " + row + ", " + col + " end at: " + row + ", " + (col-letters) );
                return true;
              }
            } 
          }
        }
      }
      return false;
    }

    public boolean checkDown(char [][]board, String searchedWord){
      for (int row = 0; row < board.length; row++) {
        for (int col = 0; col < board[row].length; col++) {
          if (row + (searchedWord.length()-1) < board.length) {
          for (int letters = 0; letters < searchedWord.length(); letters++) {
            if (searchedWord.charAt(letters) != board[row+letters][col]) {
              break;
            }
            if(letters == searchedWord.length() - 1){
                System.out.println(" found at: " + row + ", " + col + " end at: " + (row+letters) + ", " + (col) );
                return true;
            }
          }
        }
      }
    }
    return false;
  }


  public boolean checkUp(char [][]board, String searchedWord){
      for (int row = 0; row < board.length; row++) {
        for (int col = 0; col < board[row].length; col++) {
          if (row - (searchedWord.length()-1) >= 0) {
            for (int letters = 0; letters < searchedWord.length(); letters++) {
              if (searchedWord.charAt(letters) != board[row-letters][col]) {
                break;
              }
              if(letters == searchedWord.length() - 1){
                System.out.println(" found at: " + row + ", " + col + " end at: " + (row-letters) + ", " + (col) );
                return true;
              }
            }
          }
        }
      }
      return false;
    }
  

  public boolean checkDiagonalUpRight(char [][]board, String searchedWord){
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        if((row - (searchedWord.length()-1) >= 0) && (col + (searchedWord.length()-1) < board[row].length)) {
            for (int letters = 0; letters < searchedWord.length(); letters++) {
              if (searchedWord.charAt(letters) != board[row-letters][col+letters]) {
                break;
              }
              if(letters == searchedWord.length() - 1){
                System.out.println(" found at: " + row + ", " + col + " end at: " + (row+letters) + ", " + (col+letters) );
                return true;
              }
            }
          }
        }
      }
      return false;
    }
  
  public boolean checkDiagonalUpLeft(char [][]board, String searchedWord){
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        if((row - (searchedWord.length()-1) >= 0) && (col - (searchedWord.length()-1) >= 0)){
          for (int letters = 0; letters < searchedWord.length(); letters++){
            if (searchedWord.charAt(letters) != board[row-letters][col-letters]){
              break;
            }
            if(letters == searchedWord.length() - 1){
              System.out.println(" found at: " + row + ", " + col + " end at: " + (row-letters) + ", " + (col-letters) );
              return true;
            }

          }
        }
      }
    }
    return false;
  }

  public boolean checkDiagonalDownRight(char [][]board, String searchedWord){
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        if((row + (searchedWord.length()-1) < board.length) && (col + (searchedWord.length()-1) <= board[row].length)){
            for (int letters = 0; letters < searchedWord.length(); letters++) {
              if (searchedWord.charAt(letters) != board[row+letters][col+letters]) {
                 break;
              }
              if(letters == searchedWord.length() - 1){
                System.out.println(" found at: " + row + ", " + col + " end at: " + (row+letters) + ", " + (col+letters) );
                return true;
              }
            }
          }
        }
      }
      return false;
    }

  public boolean checkDiagonalDownLeft(char [][]board, String searchedWord){
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        if((row + (searchedWord.length()-1) < board.length) && (col - (searchedWord.length()-1) >=0)) {
            for (int letters = 0; letters < searchedWord.length(); letters++) {
              if (searchedWord.charAt(letters) != board[row+letters][col-letters]) {
                break;
              }
              if(letters == searchedWord.length() - 1){
                System.out.println(" found at: " + row + ", " + col + " end at: " + (row-letters) + ", " + (col-letters));
                return true;
              }
            }
          }
        }
      }
      return false;
    }
  
}
