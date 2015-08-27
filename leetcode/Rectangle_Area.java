import java.util.Arrays;
public class Rectangle_Area {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int sum=(C-A)*(D-B)+(G-E)*(H-F);
        if(B>=H||F>=D||A>=G||E>=C) return sum;
        int[] w = {A,E,C,G};
        int[] h={B,F,D,H};
        Arrays.sort(w);
        Arrays.sort(h);
        return sum-Math.abs(w[2]-w[1])*Math.abs(h[2]-h[1]);
    }
}
