import java.util.*;

public class tictactoe {
    static void printTable(String[][] table) {
        for (int i=0; i<7; i++) {
            for (int y=0; y<6; y++) {
                System.out.print(table[i][y]);
            }
            System.out.println(table[i][6]);
        }
    }

    static boolean Win(String[][]table, String who){
        for (int a=1; a<=5; a+=2) {
            int Row = 0;
            int Column = 0;
            for (int b=1; b<=5; b+=2) {
                if (table[a][b]==who) Row+=1;
                if (table[b][a]==who) Column+=1;
            }
            if (Row==3 || Column==3) return true;
        }
        if (table[1][1]==who && table[3][3]==who && table[5][5]==who) return true;
        else if (table[5][1]==who && table[3][3]==who && table[1][5]==who) return true;
        return false;
    }

    static String[][] AI_DEFENSE(String[][] table) {
        int a; 
        int sub;
        int b[] = {1,3,5};
        for (int num=1; num<=9; num++) {
            if (num>=1 && num<=3) {
                a=1; sub=0;
            }
            else if (num>=4 && num<=6) {
                a=3; sub=1;
            }
            else {
                a=5; sub=2;
            }
            if (table[a][b[num-a-sub]] == " ") {
                table[a][b[num-a-sub]]="O";
                if (Win(table, "O")) {
                    table[a][b[num-a-sub]]="O";
                    return table;
                } else {
                    table[a][b[num-a-sub]]= " ";
                }
            }
        }

        for (int num=1; num<=9; num++) {
            if (num>=1 && num<=3) {
                a=1; sub=0;
            }
            else if (num>=4 && num<=6) {
                a=3; sub=1;
            }
            else {
                a=5; sub=2;
            }
            if (table[a][b[num-a-sub]] == " ") {
                table[a][b[num-a-sub]]="X";
                if (Win(table, "X")) {
                    table[a][b[num-a-sub]]="O";
                    return table;
                } else {
                    table[a][b[num-a-sub]]= " ";
                }
            }
        }
        return AI_GO(table);
    }

    static String[][] AI_GO(String[][] table) {
        Random AI = new Random();
        int a;
        int sub;
        int num;
        int[]b = {1,3,5};
        
        while (true) {
            num = AI.nextInt(8)+1;
            if (num>=1 && num<=3) {

                a=1; sub=0;
            }
            else if (num>=4 && num<=6) {
                a=3; sub=1;
            }
            else {
                a=5; sub=2;
            }
            if (table[a][b[num-a-sub]] == " ") {
                table[a][b[num-a-sub]]="O";
                return table;
            }
        }
    }

    public static void main(String[] args) {
        String[][] table = {{"|","-","|","-","|","-","|"},
                            {"|"," ","|"," ","|"," ","|"},
                            {"|","-","|","-","|","-","|"},
                            {"|"," ","|"," ","|"," ","|"},
                            {"|","-","|","-","|","-","|"},
                            {"|"," ","|"," ","|"," ","|"},
                            {"|","-","|","-","|","-","|"}};
        boolean run = true;
        System.out.println("You are X and the AI is O");
        int[] b = {1,3,5};
        printTable(table);
        while (run) {
            Scanner input = new Scanner(System.in);
            System.out.print("Select number(1-9): ");
            String x = input.nextLine();
            int num = Integer.parseInt(x);
            int a;
            int sub;
            if (num>=1 && num<=9) {
                if (num>=1 && num<=3) {
                    a=1; sub=0;
                }
                else if (num>=4 && num<=6) {
                    a=3; sub=1;
                }
                else {
                    a=5; sub=2;
                };
                if (table[a][b[num-a-sub]]==" ") {
                    table[a][b[num-a-sub]]="X";
                    if (Win(table, "X")) {
                        printTable(table);
                        System.out.println("You win!");
                        input.close();
                        run = false;
                        break;
                    }
                    table = AI_DEFENSE(table);
                    if (Win(table, "O")) {
                        printTable(table);
                        System.out.println("You lose :(");
                        input.close();
                        run = false;
                        break;
                    }
                } 

                else {
                        System.out.println("Select again");
                }
            } 
            else {
                System.out.println("Select again");
            }
            if (run) printTable(table);
        }
    }
}
