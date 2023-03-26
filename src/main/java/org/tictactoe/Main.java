package org.tictactoe;
import javax.swing.JOptionPane;
public class Main {
    public static void main(String[] args) {
        char[][] v = {{'?','?','?'},{'?','?','?'},{'?','?','?'}};
        byte player = 1, stopflag = 0, turncount = 0;
        String poz;
        JOptionPane.showMessageDialog(null,"Welcome to NotArrayless Tic-Tac-Toe!");
        String nx = JOptionPane.showInputDialog("Enter the name for player 1:");
        String n0 = JOptionPane.showInputDialog("Enter the name for player 2:");
        Players p = new Players();
        p.Show(nx, n0);
        while (stopflag == 0) {
            System.out.println(" " + v[0][0] + " | " + v[0][1] + " | " + v[0][2]+"\n");
            System.out.println("-----------");
            System.out.println(" " + v[1][0] + " | " + v[1][1] + " | " + v[1][2]+"\n");
            System.out.println("-----------");
            System.out.println(" " + v[2][0] + " | " + v[2][1] + " | " + v[2][2]+"\n");
            turncount++;
            System.out.println("Turn " + turncount + ":\n");
            if (player == 1) {
                System.out.println(nx + ", go ahead and input the coordinates for X: \n");
                poz = JOptionPane.showInputDialog("You have to use the following form:\"line,column\"");
                if (poz.equals("1,1") && v[0][0] == '?') v[0][0] = 'X';
                else if (poz.equals("1,2") && v[0][1] == '?') v[0][1] = 'X';
                else if (poz.equals("1,3") && v[0][2] == '?') v[0][2] = 'X';
                else if (poz.equals("2,1") && v[1][0] == '?') v[1][0] = 'X';
                else if (poz.equals("2,2") && v[1][1] == '?') v[1][1] = 'X';
                else if (poz.equals("2,3") && v[1][2] == '?') v[1][2] = 'X';
                else if (poz.equals("3,1") && v[2][0] == '?') v[2][0] = 'X';
                else if (poz.equals("3,2") && v[2][1] == '?') v[2][1] = 'X';
                else if (poz.equals("3,3") && v[2][2] == '?') v[2][2] = 'X';
                else {System.out.println("The position that you're requesting is either already occupied, doesn't exist, or I cannot understand it. The game is over.");
                    System.exit(0);}
                player = 0;
            } else if (player == 0) {
                System.out.println(n0 + ", go ahead and input the coordinates for O: \n");
                poz = JOptionPane.showInputDialog("You have to use the following form:\"line,column\"");
                if (poz.equals("1,1") && v[0][0] == '?') v[0][0] = 'O';
                else if (poz.equals("1,2") && v[0][1] == '?') v[0][1] = 'O';
                else if (poz.equals("1,3") && v[0][2] == '?') v[0][2] = 'O';
                else if (poz.equals("2,1") && v[1][0] == '?') v[1][0] = 'O';
                else if (poz.equals("2,2") && v[1][1] == '?') v[1][1] = 'O';
                else if (poz.equals("2,3") && v[1][2] == '?') v[1][2] = 'O';
                else if (poz.equals("3,1") && v[2][0] == '?') v[2][0] = 'O';
                else if (poz.equals("3,2") && v[2][1] == '?') v[2][1] = 'O';
                else if (poz.equals("3,3") && v[2][2] == '?') v[2][2] = 'O';
                else {System.out.println("The position that you're requesting is either already occupied, doesn't exist, or I cannot understand it. The game is over.");
                    System.exit(0);}
                player = 1;
            }
            stopflag = p.checkflag(v[0][0], v[0][1], v[0][2], v[1][0], v[1][1], v[1][2], v[2][0], v[2][1], v[2][2], turncount);

        }
        System.out.println("Final results:\n");
        System.out.println(" " + v[0][0] + " | " + v[0][1] + " | " + v[0][2] + "\n");
        System.out.println("-----------");
        System.out.println(" " + v[1][0] + " | " + v[1][1] + " | " + v[1][2] + "\n");
        System.out.println("-----------");
        System.out.println(" " + v[2][0] + " | " + v[2][1] + " | " + v[2][2] + "\n");
        p.results(stopflag,nx,n0);
        JOptionPane.showMessageDialog(null,"Let's play again sometime!");
    }

}
