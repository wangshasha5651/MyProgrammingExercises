/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are+,-,*,/. Each operand may be an integer or another expression.
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */

import java.util.*;
 
public class Solution {
    public int evalRPN(String[] tokens) {
        int opNum1, opNum2, tmp = 0;
        String operator;
        Stack<String> stack = new Stack<String>();
        for(int i = 0; i < tokens.length; i++){
            if(!tokens[i].equals("+")  && !tokens[i].equals("-")  && !tokens[i].equals("*")  && !tokens[i].equals("/") ){
                stack.push(tokens[i]);
            } else{
                operator = tokens[i];
                opNum2 = Integer.parseInt(stack.pop());
                opNum1 = Integer.parseInt(stack.pop());
                switch(operator){
                    case "+":
                        tmp = opNum1 + opNum2;
                        break;
                    case "-":
                        tmp = opNum1 - opNum2;
                        break;
                    case "*":
                        tmp = opNum1 * opNum2;
                        break;
                    case "/":
                        tmp = opNum1 / opNum2;
                }
                stack.push(String.valueOf(tmp));
            }
        }
        return Integer.parseInt(stack.pop());
    }
}