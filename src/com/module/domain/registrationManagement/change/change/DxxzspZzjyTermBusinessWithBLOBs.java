package com.module.domain.registrationManagement.change.change;

public class DxxzspZzjyTermBusinessWithBLOBs extends DxxzspZzjyTermBusiness {
    private String userProcessSolution;

    private String shgsqk;

    private String shclssjh;

    public String getUserProcessSolution() {
        return userProcessSolution;
    }

    public void setUserProcessSolution(String userProcessSolution) {
        this.userProcessSolution = userProcessSolution == null ? null : userProcessSolution.trim();
    }

    public String getShgsqk() {
        return shgsqk;
    }

    public void setShgsqk(String shgsqk) {
        this.shgsqk = shgsqk == null ? null : shgsqk.trim();
    }

    public String getShclssjh() {
        return shclssjh;
    }

    public void setShclssjh(String shclssjh) {
        this.shclssjh = shclssjh == null ? null : shclssjh.trim();
    }
}