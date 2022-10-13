package Else;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 98Bytes
 * @Date: 2022/10/02/17:19
 * @Description:
 *  给出两个字符串，是否存在来个字串颠倒了位置或者两个字符串本来就相等
 *  “ABCD” "CDAB" true
 *  "ABCD" "DCAB" false
 *  "ABCD" "ABCD" true
  */
public class subString1 {

    public static boolean splitStr(String str1, String str2){
        if (str1 == null || str2== null || str1.length()!=str2.length()) return false;
        if (str1.equals("") && str2.equals("")) return true;
        int strLength = str1.length(), splitIndex = -1;
        for (int i = 0; i < strLength; i++) {
            if (str1.charAt(i) == str2.charAt(0)) {
                System.out.println(str1.substring(i, strLength));
                System.out.println(str2.substring(0, strLength - i));
                System.out.println(str1.substring(0, i));
                System.out.println(str2.substring(strLength - i, strLength));
                if(str1.substring(i,strLength).equals(str2.substring(0,strLength-i)) && str1.substring(0,i).equals(str2.substring(strLength-i,strLength)))  return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        String str1 = "ABCD", str2 = "CDAB";
        System.out.println(splitStr(str1, str2));
        str1 = "ABCD";
        str2 = "DCAB";
        System.out.println(splitStr(str1, str2));
        str1 = "ABCD";
        str2 = "ABCD";
        System.out.println(splitStr(str1, str2));
        str1 = "";
        str2 = "";
        System.out.println(splitStr(str1, str2));
    }
}
