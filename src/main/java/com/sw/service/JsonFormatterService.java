package com.sw.service;

import org.springframework.stereotype.Service;

import java.util.Stack;

@Service
public class JsonFormatterService {

    public String prettyFormat(String s, int indent){
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int currentIndent = 0 ;
        for(char c : s.toCharArray()){
            if(c == '[' || c == '{' ){
                stack.push(c);
                currentIndent += indent;
                sb.append(c + "\n"+getIndentation(currentIndent));
            }else if(c == ']' || c == '}'){
                stack.pop();
                currentIndent -= indent;
                sb.append("\n"+getIndentation(currentIndent)+c);
            }else if(c==','){
                sb.append(c);
                if(stack.isEmpty() || stack.peek() == '{' || stack.peek() == '['){
                    sb.append("\n"+getIndentation(currentIndent));
                }
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String getIndentation(int n){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(" ");
        }
        return sb.toString();
    }


}
