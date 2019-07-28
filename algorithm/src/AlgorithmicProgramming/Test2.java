package AlgorithmicProgramming;

import java.nio.ByteBuffer;

/*
* 将一个字符串中的空格替换成“%20”。
例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。*/
public class Test2 {

    public static void main(String[] args) {
        String s = "We Are Happy";
        String s1 = " ";
        String s2 = "%20";
        func(s, s1, s2);
        System.out.println(s);
    }

    private static String func(String s, String s1, String s2) {
        StringBuffer sb=new StringBuffer(s);
        if (sb == null) {
            return null;
        }
        for (int i=0;i<sb.length();i++){
            if (sb.equals(s1)){
                sb.append(s2);
            }else {
                sb.append(s1);
            }
        }
        return String.valueOf(sb);
    }
}
