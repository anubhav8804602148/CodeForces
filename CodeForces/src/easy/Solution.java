package easy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {

    public static boolean canWin(int leap, int[] game) {
        int curr = 0;
        int lim = game.length-1;
        return travel(game, curr, leap, lim);
    }
    
    public static boolean travel(int[] game, int curr, int leap, int lim){
        if(curr+leap>lim || (curr+leap==lim && game[lim]==0)) return true;
        int min = -1;
        int max = -1;
        for(min=curr;min>=0 && game[min]==0;min--);
        for(max=curr;max<=lim && game[max]==0;max++);
        min++;
        max--;
        if(max+leap>lim || (max+leap==lim && game[lim]==0)) return true;
        for(int i=min;i<=max;i++){
            int nextInd = i+leap;
            if(nextInd>max && game[nextInd]==0 && (travel(game, nextInd, leap, lim))) return true;
        }
        return false;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.setOut(new PrintStream(new File("Output.txt")));
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
