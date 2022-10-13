package Else.Tencent;

import java.util.*;

public class Column {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] charArray = new char[1001][1001];
        int columns = 0, rows = 0;
        for(int i=0; i<n; i++){
            String str = sc.next();
            char[] nums = str.toCharArray();
            for(int j=0; j<nums.length; j++){
//                System.out.println(nums[j]);
                charArray[i][j] = nums[j];
            }
            columns =nums.length;
            rows = n;
        }

        for(int j=0; j<columns; j++) {
            for(int k=0; k<rows; k++){
                if(k==0 && charArray[k][j]=='0') continue;
                else    System.out.print(charArray[k][j]);
            }
            System.out.println();
        }

    }
}
