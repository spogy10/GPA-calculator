/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gpa.calculator;

/**
 *
 * @author poliv
 */


public class Course {//3.12, 3.06, 3.36, 3.47, 3.46

    
   /*
    A                 4.00                90-10
    A-                3.67                80-89
    B+               3.33                75-79
    B                 3.00                70-74
    B-                2.67                65-69
    C+              2.33                60-64
    C                 2.00                55-59
    C-                1.67                50-54
    D+              1.33                45-49
    D                 1.00                40-44
    D-               0.67                35–39
    U                 0.00                0-34
    Absent                     AB 0.00
    Pass                          P– 
    Fail                            F–
    
    */
    
    //public final static float A = 4, a =(float) 3.67, BB = (float) 3.33, B = 3, b = (float) 2.67, CC = (float) 2.33, C = 2, c = (float) 1.67, DD = (float) 1.33, D = 1, d = (float) 0.67, U = 0, AB = 0;
    
    
    private String name;
    private int credits = 0;
    private String grade = "";
    private float gradePoint = (float) 0;

    public Course() {
        name = "";
        credits = 0;
        grade = "";
        gradePoint = 0;
    }
    
    public Course(String name, int credits, String grade) {
        this.name = name;
        this.credits = credits;
        this.grade = grade;
        gradePoint = calculateGradePoint();
    }
    
    public Course(int credits, String grade) {
        
        this.credits = credits;
        this.grade = grade;
        gradePoint = calculateGradePoint();
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
        gradePoint = calculateGradePoint();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
        gradePoint = calculateGradePoint();
    }

    public float getGradePoint() {
        return gradePoint;
    }

    public void setGradePoint(float gradePoint) {
        this.gradePoint = gradePoint;
    }
    
    public final static float getGradePointFromGrade(String grade){
        
        switch (grade){
            case "A":  return Grades.A.value;
            case "A-":  return Grades.a.value;
            case "B+":  return Grades.BB.value;
            case "B":  return Grades.B.value;
            case "B-":  return Grades.b.value;
            case "C+":  return Grades.CC.value;
            case "C":  return Grades.C.value;
            case "C-":  return Grades.c.value;
            case "D+":  return Grades.DD.value;
            case "D":  return Grades.D.value;
            case "D-":  return Grades.d.value;
            case "U":  return Grades.U.value;
            case "AB":  return Grades.AB.value;
            default: return 0;
        }
    }
    
    public final float calculateGradePoint(){
        return credits * getGradePointFromGrade(grade);
    }
    
    public final static float calculateGPA(Course[] courses){
        float totalCredits = (float) 0, totalGP = (float) 0;
        
        for (Course course : courses){
            totalCredits += course.getCredits();
            totalGP += course.getGradePoint();
        }
        
        return totalGP/totalCredits;
        
    }

    public final static float calculateGPA(Iterable<Course> courses){
        float totalCredits = (float) 0, totalGP = (float) 0;

        for (Course course : courses){
            totalCredits += course.getCredits();
            totalGP += course.getGradePoint();
        }

        return totalGP/totalCredits;

    }
    
}
