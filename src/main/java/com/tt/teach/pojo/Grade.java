package com.tt.teach.pojo;

public class Grade {
    private Integer gradeID;
    private String gradeName;

    public Grade(Integer gradeID) {
        this.gradeID = gradeID;
    }

    public Grade(Integer gradeID, String gradeName) {
        this.gradeID = gradeID;
        this.gradeName = gradeName;
    }

    public Integer getGradeID() {
        return gradeID;
    }

    public void setGradeID(Integer gradeID) {
        this.gradeID = gradeID;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }
}
