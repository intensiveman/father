package com.example;

public class Test {

    public static void main(String[] args) {
        String str = "ababcabcacbabb";
        String mode = "abcac";
        int modeString = getModeString(str, mode);
        System.out.println("modeString = " + modeString);
    }


    public static int getModeString(String str, String mode) {
        char[] strArray = str.toCharArray();
        char[] modeArray = mode.toCharArray();
        int i = 0;
        int j= 0;
        for (i = 0; i < strArray.length; i++) {
            if (j == 3) {
                break;
            }
            if (strArray[i] == modeArray[j]) {
                j++;
            } else {
                if (j > 0) {
                    i = i - j;
                    j = 0;
                }
            }
        }
        return i;
    }
}
