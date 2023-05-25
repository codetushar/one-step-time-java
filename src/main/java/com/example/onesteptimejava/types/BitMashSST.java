package com.example.onesteptimejava.types;

import java.util.ArrayList;

public class BitMashSST {
    String[] req_skills;
    ArrayList<ArrayList<String>> people;

    public BitMashSST() {

    }

    public BitMashSST(String[] req_skills, ArrayList<ArrayList<String>> people) {
        super();
        this.req_skills = req_skills;
        this.people = people;
    }

    public String[] getReq_skills() {
        return this.req_skills;
    }

    public void setReq_skills(String[] req_skills) {
        this.req_skills = req_skills;
    }

    public ArrayList<ArrayList<String>> getPeople() {
        return this.people;
    }

    public void setPeople(ArrayList<ArrayList<String>> people) {
        this.people = people;
    }
}
