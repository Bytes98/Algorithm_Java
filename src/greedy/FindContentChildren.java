package greedy;

import java.util.Arrays;

public class FindContentChildren {
    public int findContentChildren(int[] children, int[] cookies) {
        int count = 0;
        int indexCookies= cookies.length-1;
        Arrays.sort(children);
        Arrays.sort(cookies);
        for(int i = children.length-1; i>=0;i--){
            // 这里的局部最优就是大饼干喂给胃口大的，充分利用饼干尺寸喂饱一个，
            // 全局最优就是喂饱尽可能多的小孩。
            if(indexCookies>=0 && children[i]<=cookies[indexCookies]){
                indexCookies--;
                count++;
            }
        }
        return count;
    }
}
