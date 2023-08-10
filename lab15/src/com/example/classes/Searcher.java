package com.example.classes;

import com.example.interfaces.ISearcher;

import java.util.ArrayList;

public class Searcher implements ISearcher {
    private int getHash(String str, int length) {
        String strToHash = str.substring(0, length);
        return strToHash.hashCode();
    }

    @Override
    public ArrayList<Integer> search(String text, String pattern) {
        int m = pattern.length();
        int n = text.length();
        ArrayList<Integer> res = new ArrayList<>(n - m);

        int patternHash = getHash(pattern, m);
        int strHash = getHash(text, m);

        for (int i = 0; i < n - m + 1; i++) {
            if (patternHash == strHash) {
                int k = 0;
                for (int j = i; j < i + m; j++, k++) {
                    if (text.charAt(j) != pattern.charAt(k)) {
                        break;
                    }
                }
                if (k == m) {
                    res.add(i);
                }
            }
            else{
                strHash = getHash(text.substring(i + 1, i + m + 1), m);
            }
        }
        return res;
    }
}
