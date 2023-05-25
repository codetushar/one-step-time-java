package com.example.onesteptimejava.service;

import java.util.*;

import com.example.onesteptimejava.types.Graph;
import com.example.onesteptimejava.types.Matrix;

public class DPService {
    Solution solve = new Solution();
    ETL etl = new ETL();

    public DPService() {
    }

    public Matrix LIS(Matrix inputs) {
        List<List<Integer>> in = inputs.getMatrix();
        List<List<Integer>> outputs = new ArrayList<>();

        for (int i = 0; i < in.size(); i++) {
            outputs.add(solve.getLIS(in.get(i)));
        }
        for (int i = 0; i < outputs.size(); i++) {
            etl.levelByValue(outputs.get(i), in.get(i));
        }
        return new Matrix(outputs);
    }

    public Graph smallestSufficientTeam(String[] req_skills, ArrayList<ArrayList<String>> people) {
        Map<String, Integer> req = new HashMap<>();
        for (int i = 0; i < req_skills.length; i++)
            req.put(req_skills[i], i);

        HashMap<Integer, ArrayList<Integer>> dp = new HashMap<>();
        dp.put(0, new ArrayList<Integer>());
        for (int i = 0; i < people.size(); i++) {
            ArrayList<String> skillSet = people.get(i);
            int personSkills = 0;
            for (int j = 0; j < skillSet.size(); j++)
                if (req.containsKey(skillSet.get(j)))
                    personSkills |= 1 << req.get(skillSet.get(j)).intValue();

            if (personSkills == 0)
                continue;
            if (dp.containsKey(personSkills) && (dp.get(personSkills).size() == 1))
                continue;

            int[] keys = dp.keySet().stream().mapToInt(num -> num).toArray();
            for (int skill : keys) {
                ArrayList<Integer> team = dp.containsKey(skill) ? dp.get(skill) : new ArrayList<Integer>();
                int withHim = personSkills | skill;

                if (withHim == skill)
                    continue;
                if (!dp.containsKey(withHim) || dp.get(withHim).size() > team.size() + 1) {
                    ArrayList<Integer> newTeam = new ArrayList<>(team);
                    newTeam.add(i);
                    dp.put(withHim, newTeam);
                }

            }
        }
        return new Graph(dp);
    }

}
