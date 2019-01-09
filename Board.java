public class Board {
  private int spotCount;
  private int blockCount;
  private int score;
  private Square[][] board;

  public Board(){
    Square[][] board = new Square[10][10];
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[0].length; j++){
        board[i][j] = new Square("black", i, j);
      }
    }
  }

  public Square getSquare(int x, int y){
    return board[x][y];
  }

  public boolean placeBlock(Block b, int x, int y){
    if (placeable(b, x, y)){
      for (int i = 0; i < 5; i++){
        for (int j = 0; j < 5; j++){
          board[x][y] = b.getBlock()[i][j];
          y++;
        }
        x++;
      }
      return true;
    }
    return false;
  }

  public boolean placeable(Block bl, int x, int y){
    int a = 0;
    int b = 0;
    for (int i = x; i < x+5; i++){
      for (int j = y; y < y+5; j++){
        System.out.println("a: " + a + "\nb: " + b + "\ni: " + i + "\nj: " + j);
        System.out.println(bl.getBlock()[a][b] != null);
        if (bl.getBlock()[a][b] != null && board[i][j] != null){
          return false;
        }
        b++;
      }
      a++;
    }
    return true;
  }

  public String toString(){
    String s="";//this is the string containing the entire board
    int c=10;
    while (c!=0){
          s=s+"+---+---+---+---+---+---+---+---+---+---+\n";
          if (c==7){
            s=s+"|   |   |   |   |   |   |   |   |   |   |           SCORE:0\n";
          }
          else if(c==5){
            s=s+"|   |   |   |   |   |   |   |   |   |   |           (Press Tab for Menu)\n";
          }
          else{
          s=s+"|   |   |   |   |   |   |   |   |   |   |\n";
        }
        c--;
    }
    s=s+"+---+---+---+---+---+---+---+---+---+---+\n"+"\n"+"\n";
    //s=s+"PRESS ENTER TO START GAME";
    return s;

    /*t.applyForegroundColor(Terminal.Color.BLACK);//the color of the board will be black
    t.moveCursor(0,0);
		for(int i = 0; i < s.length();i++){
			t.putCharacter(s.charAt(i));
		}*/


  }

}
