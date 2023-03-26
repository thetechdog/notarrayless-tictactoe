package org.tictactoe;
public class Players {

    public void Show(String nx, String n0){
        System.out.println("The players are:\n");
        System.out.println(nx+" ");
        System.out.println(n0+"\n");
    }
    public byte checkflag(char a1,char a2,char a3,char b1, char b2, char b3, char c1, char c2, char c3, byte turncount){
        //0 still going, 1 - player X has won, 2 - player 0 has won, -1 - draw
        //lines X
        if (a1==a2 && a2==a3 && a1=='X') return 1;
        if (b1==b2 && b2==b3 && b1=='X') return 1;
        if (c1==c2 && c2==c3 && c1=='X') return 1;
        //diagonals X
        if (a1==b2 && b2==c3 && a1=='X') return 1;
        if (a3==b2 && b2==c1 && a3=='X') return 1;
        //columns X
        if (a1==b1 && b1==c1 && a1=='X') return 1;
        if (a2==b2 && b2==c2 && a2=='X') return 1;
        if (a3==b3 && b3==c3 && a3=='X') return 1;
        //lines 0
        if (a1==a2 && a2==a3 && a1=='0') return 2;
        if (b1==b2 && b2==b3 && b1=='0') return 2;
        if (c1==c2 && c2==c3 && c1=='0') return 2;
        //diagonals 0
        if (a1==b2 && b2==c3 && a1=='0') return 2;
        if (a3==b2 && b2==c1 && a3=='0') return 2;
        //columns 0
        if (a1==b1 && b1==c1 && a1=='0') return 2;
        if (a2==b2 && b2==c2 && a2=='0') return 2;
        if (a3==b3 && b3==c3 && a3=='0') return 2;
        //final turn condition
        if (turncount==9) return -1;

        return 0;
    }
    public void results(byte res,String nx, String n0){
        if (res==1) System.out.println("The winner is... "+nx+". Congrats! \n");
        else if (res==2) System.out.println("The winner is... "+n0+". Congrats! \n");
        else if(res==-1) System.out.println("It's a draw.");
        return;

    }
}
