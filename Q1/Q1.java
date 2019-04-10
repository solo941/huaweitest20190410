package com.huawei0410;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q1 {
    private static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int stringsNum = sc.nextInt();
        if (stringsNum == 0) System.out.print("");
        while (stringsNum-- > 0){
            String string = sc.next();
            toValidString(string);
        }
        String[] stringArray = new String[list.size()];
        int count = 0;
        for (String s: list){
            stringArray[count++] = s;
        }
        Arrays.sort(stringArray);
        StringBuilder sb = new StringBuilder();
        for(String s: stringArray){
            sb.append(s);
            sb.append(" ");
        }
        System.out.print(sb);
    }

    private static void toValidString(String string) {
        if (string == null) return;
        int length = string.length();
        int newStringsCount = length / 8;
        for (int i = 0; i<newStringsCount; i++){
            String subString = string.substring(i * 8, (i + 1) * 8 );
            list.add(subString);
        }
        int lastStringLength = length % 8;
        if (lastStringLength == 0) return;
        String lastString = string.substring( length -lastStringLength,length);
        for (int j = lastStringLength; j < 8; j++){
            lastString = lastString + "0";
        }
        list.add(lastString);
    }
}
