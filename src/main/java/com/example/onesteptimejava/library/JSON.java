package com.example.onesteptimejava.library;

import java.util.*;

public class JSON {
    public static Map<String, Object> convertToMap(String content) {
        HashMap<String, Object> map = new HashMap<>();
        Stack<Character> charSmbStack = new Stack<>();
        Stack<Object> objStack = new Stack<>();

        String str = new String();

        for (int i = 0; i < content.length(); i++) {
            char ch = content.charAt(i);
            switch (ch) {
                case '{':
                    if (charSmbStack.size() != 0) {
                        String nest = new String();
                        i += 1;
                        int openBracket = 0;
                        if (content.charAt(i) == '}') {
                            objStack.push(new HashMap<>());
                            break;
                        }
                        while (content.charAt(i) != '}' || openBracket != 0) {
                            nest += content.charAt(i);
                            if (content.charAt(i) == '{')
                                openBracket++;
                            else if (content.charAt(i) == '}')
                                openBracket--;
                            i++;
                        }
                        objStack.push(convertToMap(nest));
                    } else {
                        charSmbStack.push(ch);
                    }
                    break;
                case '[':
                    String nest = new String();
                    i += 1;
                    int openBracket = 0;
                    if (content.charAt(i) == ']') {
                        objStack.push(new HashMap<>());
                        break;
                    }
                    while (content.charAt(i) != ']' || openBracket != 0) {
                        nest += content.charAt(i);
                        if (content.charAt(i) == '[')
                            openBracket++;
                        else if (content.charAt(i) == ']')
                            openBracket--;
                        i++;
                    }
                    objStack.push(convertToList(nest));
                    break;
                case '"':
                    if (charSmbStack.size() > 0 && charSmbStack.peek() == '"') {
                        if (str.length() > 0)
                            objStack.push(str);
                        str = "";
                        charSmbStack.pop();
                    } else {
                        charSmbStack.push(ch);
                    }
                    break;
                case ':':
                    if (charSmbStack.size() == 0 || charSmbStack.peek() != '"')
                        str = "";
                    break;
                case ',':
                    if (objStack.size() > 1) {
                        Object v = objStack.pop();
                        String k = (String) objStack.pop();
                        map.put(k, v);
                    }
                    break;
                default:
                    if (charSmbStack.size() > 0 && charSmbStack.peek() == '"')
                        str += ch;
                    break;
            }
        }
        if (objStack.size() > 1) {
            Object v = objStack.pop();
            String k = (String) objStack.pop();
            map.put(k, v);
        }
        return map;
    }

    public static Object[] convertToList(String content) {
        Stack<Character> charSmbStack = new Stack<>();
        Stack<Object> objStack = new Stack<>();

        String str = new String();

        for (int i = 0; i < content.length(); i++) {
            char ch = content.charAt(i);
            switch (ch) {
                case '{':
                    if (i != content.length() - 1) {
                        String nest = new String();
                        i += 1;
                        int openBracket = 0;
                        if (content.charAt(i) == '}') {
                            objStack.push(new HashMap<>());
                            break;
                        }
                        while (content.charAt(i) != '}' || openBracket != 0) {
                            nest += content.charAt(i);
                            if (content.charAt(i) == '{')
                                openBracket++;
                            else if (content.charAt(i) == '}')
                                openBracket--;
                            i++;
                        }
                        objStack.push(convertToMap(nest));
                    }
                    break;
                case '[':
                    String nest = new String();
                    i += 1;
                    int openBracket = 0;
                    if (content.charAt(i) == ']') {
                        objStack.push(new HashMap<>());
                        break;
                    }
                    while (content.charAt(i) != ']' || openBracket != 0) {
                        nest += content.charAt(i);
                        if (content.charAt(i) == '[')
                            openBracket++;
                        else if (content.charAt(i) == ']')
                            openBracket--;
                        i++;
                    }
                    objStack.push(convertToList(nest));
                    break;
                case '"':
                    if (charSmbStack.size() > 0 && charSmbStack.peek() == '"') {
                        if (str.length() > 0)
                            objStack.push(str);
                        str = "";
                        charSmbStack.pop();
                    } else {
                        charSmbStack.push(ch);
                    }
                    break;
                case ',':
                    str = "";
                    break;
                default:
                    if (charSmbStack.size() > 0 && charSmbStack.peek() == '"')
                        str += ch;
                    break;
            }
        }
        return objStack.toArray();
    }
}
