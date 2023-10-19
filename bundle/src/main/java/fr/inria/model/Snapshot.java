package fr.inria.model;

import java.util.Map;


public class Snapshot{

    private Map<String, Branch> branches;



    public Map<String, Branch> getBranches() {
        return branches;
    }
    public void setBranches(Map<String, Branch> branches) {
        this.branches = branches;
    }

    

}
