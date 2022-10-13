package Else;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 98Bytes
 * @Date: 2022/10/02/17:11
 * @Description:
 *  得物APP 2023校招
 *  给出血型信息，父母的血型为输入，输出子女的血型
 *  (String A,Strin B) -> String[] result;
 *  "O","O" -> ["O"]
 */
public class BloodType {
    /**
     * 父母       可能       不可能
     * O与O      O        A、B、AB
     * A与O     A、O       B、AB
     * A与A     A、O      B、AB
     * 
     */
    public String[] getChildBloodType(String mother, String father){
        if (mother.equals("O")) {
            if(father.equals("O")) return new String[]{"O"};
            else if(father.equals("AB")) return new String[]{"A","B"};
            else if (father.equals("A")) return new String[]{"A","O"};
            else return new String[]{"B","O"};
        } else if (mother.equals("AB")) {
            if (father.equals("O")) return new String[]{"A","B"};
            else return new String[]{"A","B","AB"};
        } else if (mother.equals("A")) {
            if (father.equals("O") || father.equals("A")) return new String[]{"A","O"};
            else if (father.equals("AB")) return new String[]{"A","B","AB"};
            else return new String[]{"A","B","AB","O"};
        }else {
            if (father.equals("O") || father.equals("B")) return new String[]{"B","O"};
            else if (father.equals("AB")) return new String[]{"A","B","AB"};
            else return new String[]{"A","B","AB","O"};
        }
    }
    
}
