package com.example.onesteptimejava.service;

import java.util.*;

public class Solution {
    public Solution() {
    }

    public List<Integer> getLIS(List<Integer> in) {
        List<Integer> recycle = new ArrayList<Integer>();
        List<Integer> output = new ArrayList<Integer>();
        recycle.add(in.get(0));
        output.add(in.get(0));
        for (int i = 1; i < in.size(); i++) {
            Integer target = in.get(i);
            int l = 0;
            int r = recycle.size();
            while (l < r) {
                int mid = (int) Math.floor((l + r) / 2);
                if (recycle.get(mid) > target) {
                    r = mid;
                } else if (recycle.get(mid) < target) {
                    l = mid + 1;
                } else {
                    l = mid;
                    break;
                }
            }
            if (l == recycle.size()) {
                recycle.add(target);
                output = new ArrayList<Integer>(recycle);
            } else {
                recycle.set(l, target);
            }
        }
        return output;
    }

}
