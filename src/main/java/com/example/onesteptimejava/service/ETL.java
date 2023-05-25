package com.example.onesteptimejava.service;

import java.util.*;

public class ETL {
    public ETL() {

    }

    public void levelByValue(List<Integer> list, List<Integer> list2) {
        int j = 0;
        for (int i = 0; i < list2.size(); i++, j++) {
            if (j < list.size() && !list2.get(i).equals(list.get(j))) {
                list.add(j, -1);
            } else if (j >= list.size())
                list.add(-1);
        }
    }
}
