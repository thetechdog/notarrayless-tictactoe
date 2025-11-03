import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] v = {{'?','?','?'},{'?','?','?'},{'?','?','?'}};
        boolean player=true;//true=player 1, false=player 2
        byte resflag = 0, turncount = 0;
        String poz;
        char symbol;
        String welcome="""
        _|      _|    _|_|            _|_|_|_|_|  _|_|_|_|_|  _|_|_|_|_|
        _|_|    _|  _|    _|              _|          _|          _|
        _|  _|  _|  _|_|_|_|  _|_|_|_|_|  _|          _|          _|
        _|    _|_|  _|    _|              _|          _|          _|
        _|      _|  _|    _|              _|          _|          _|""";
        System.out.println(welcome);
        System.out.println("NotArrayless TicTacToe - (C) Andrei Ionel 2022-2025\nLicensed under the MIT License.");
        System.out.println("Version 2.0, running on Java "+System.getProperty("java.version") + " on "+System.getProperty("os.name"));
        System.out.println("Press return to continue...");
        Scanner s=new Scanner(System.in);
        s.nextLine();
        System.out.println("Enter the name for player 1:");
        String nameX = s.nextLine();
        System.out.println("Enter the name for player 2:");
        String name0 = s.nextLine();
        System.out.println("To recap, the players are:");
        System.out.println(nameX+" and "+name0);

        while (resflag == 0) {System.out.println();
            turncount++;
            System.out.println("Turn " + turncount + ":");
            System.out.println(" " + v[0][0] + " | " + v[0][1] + " | " + v[0][2]);
            System.out.println("-----------");
            System.out.println(" " + v[1][0] + " | " + v[1][1] + " | " + v[1][2]);
            System.out.println("-----------");
            System.out.println(" " + v[2][0] + " | " + v[2][1] + " | " + v[2][2]);
            String name="";
            if(player == true) {symbol = 'X'; name=nameX;}
            else {name=name0; symbol = 'O';} 
            int x,y;
            while(true){
                System.out.println(name + ", go ahead and input the coordinates for " + symbol + ":");
                System.out.println("You have to use the following format:\"line, column\"");
            
                poz = s.nextLine();
                String[] p=poz.split("\s*,\s*");
                try{
                    x= Integer.parseInt(p[0])-1;
                    y= Integer.parseInt(p[1])-1;
                    if(0<=x && x<=2 && 0<=y && y<=2) {
                        if(v[x][y]=='?') {v[x][y] = symbol; break;}
                        else {System.out.println("Invalid position. Input again."); continue;}
                    }
                    else {System.out.println("Invalid coordinates. Input again."); continue;}                     
                }
                catch(NumberFormatException | ArrayIndexOutOfBoundsException e){System.out.println("I can't understand the coordinates. Input again.");}
            }    
            if(turncount>=3) resflag=checkwin(v[0][0], v[0][1], v[0][2], v[1][0], v[1][1], v[1][2], v[2][0], v[2][1], v[2][2], turncount);
            player = !player; //switch to the other player
        }
        System.out.println("\nFinal result:");
        System.out.println(" " + v[0][0] + " | " + v[0][1] + " | " + v[0][2]);
        System.out.println("-----------");
        System.out.println(" " + v[1][0] + " | " + v[1][1] + " | " + v[1][2]);
        System.out.println("-----------");
        System.out.println(" " + v[2][0] + " | " + v[2][1] + " | " + v[2][2]);
        results(resflag,nameX,name0);
        System.out.println("The game is over.\n");
        System.out.println("Press return to exit...");
        s.nextLine();
        s.close();
        System.exit(0);
    }
        
    static byte checkwin(char a1,char a2,char a3,char b1, char b2, char b3, char c1, char c2, char c3, byte turncount){
        //0 - still going, 1 - player X has won, 2 - player 0 has won, -1 - draw
        //lines
        if (a1==a2 && a2==a3) return symbolcheck(a1);
        if (b1==b2 && b2==b3) return symbolcheck(b1);
        if (c1==c2 && c2==c3) return symbolcheck(c1);
        //diagonals
        if (a1==b2 && b2==c3) return symbolcheck(a1);
        if (a3==b2 && b2==c1) return symbolcheck(a3);
        //columns
        if (a1==b1 && b1==c1) return symbolcheck(a1);
        if (a2==b2 && b2==c2) return symbolcheck(a2);
        if (a3==b3 && b3==c3) return symbolcheck(a3);
        //final turn condition
        if (turncount>=9) return -1;
        return 0;
    }

    static byte symbolcheck(char a){
        if (a=='?') return 0;
        if (a=='X') return 1;
        return 2;
    }

    static void results(byte res,String nameX, String name0){
        if (res==1) System.out.println("The winner is... "+nameX+". Congrats!");
        else if (res==2) System.out.println("The winner is... "+name0+". Congrats!");
        else System.out.println("It's a draw.");
    }

}
