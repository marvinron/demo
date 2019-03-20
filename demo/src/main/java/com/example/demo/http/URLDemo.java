package com.example.demo.http;

import java.net.URLDecoder;

/**
 * @author houlei
 * @DESC:URL
 * @create 2019-01-14 15:28
 */
public class URLDemo {

    public static String createSequence(long sourceInt, int[] offset, int[]... displacementPair) {
        return displacement(incremental(sourceInt, offset), displacementPair);
    }
    public static String incremental(long sourceInt, int[] offset) {
        String sourceStr = String.valueOf(sourceInt);
        if ((sourceStr == null) || (offset == null)) {
            return sourceStr;
        }
        int sourceStrLength = sourceStr.length();
        int offsetLength = offset.length;
        if (sourceStrLength > offsetLength) {
            return sourceStr;
        }
        StringBuffer source = new StringBuffer();
        for (int i = 0; i < offsetLength - sourceStrLength; i++) {
            source.append("0");
        }
        source.append(sourceStr);
        StringBuffer result = new StringBuffer();
        char[] sequence = source.toString().toCharArray();
        for (int i = 0; i < sequence.length; i++) {
            long position = Integer.parseInt(String.valueOf(sequence[i]));
            position = (position + offset[i]) % 10;
            result.append(position);
        }
        return result.toString();
    }
    public static String displacement(String sourceStr, int[]... displacementPair) {
        if (displacementPair == null) {
            return sourceStr;
        }
        char[] source = sourceStr.toCharArray();
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < displacementPair.length; i++) {
            if ((displacementPair[i].length != 2) || (source.length < displacementPair[i][0])
                    || (source.length < displacementPair[i][1])) {
                return sourceStr;
            }
            char tmp = source[displacementPair[i][0] - 1];
            source[displacementPair[i][0] - 1] = source[displacementPair[i][1] - 1];
            source[displacementPair[i][1] - 1] = tmp;
        }
        result.append(source);
        return result.toString();

    }

    public static void main(String[] args) {
        int[] arry = {0,1,2,3,4,5,6,7,8,9};
        int[][] arr= {{1,2},{3,4},{5,6},{7,8},{9,0}};
        String sequence = createSequence(15, arry, arr);
        System.out.println(sequence);

    }


}
