package com.huawei0410;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String string = sc.next();
        char[] charArray = string.toCharArray();
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        Character[] characterLeft = {'(','{','['};
        HashSet<Character> setLeft = new HashSet<Character>(Arrays.asList(characterLeft));
        Character[] characterRight = {')',']','}'};
        int countAll = 1;
        HashSet<Character> setRight = new HashSet<Character>(Arrays.asList(characterLeft));
        for (int i=0; i < charArray.length; i++){
            if ((charArray[i] >= 'a' && charArray[i] <= 'z') || (charArray[i] >= 'A' && charArray[i] <= 'Z')){
                if (countStack.isEmpty()) result.append(charArray[i]);
                else stack.push(charArray[i]);
            }
            //结束后到小括号了
            else if (charArray[i] >= '0' && charArray[i] <= '9'){
                int count = 0;
                while(charArray[i] >= '0' && charArray[i] <= '9'){
                    int numCur =charArray[i] - '0';
                    count = count * 10 + numCur;
                    i++;
                }
                //走到括号了
                i--;
                countStack.push(count);
                countAll = count * countAll;

            }
            else{
                if(setLeft.contains(charArray[i])){
                    stack.push(charArray[i]);
                }
                //右括号
                else {
                    char c;
                    StringBuilder curSB = new StringBuilder();
                    while (!setLeft.contains(stack.peek())){
                        c = stack.pop();
                        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
                            curSB.append(c);
                        }
                    }
                    stack.pop();
                    //reverse
                    curSB.reverse();
                    for (int j = 0; j < countAll; j++){
                        result.append(curSB);
                    }
                    int num = countStack.pop();
                    countAll /= num;
                }
            }
            //不带括号的字母
        }
        result.reverse();
        System.out.println(result);

    }
}
