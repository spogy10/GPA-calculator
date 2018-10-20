package gpa.calculator;

public enum Grades {
    A (4), a ( (float) 3.67), BB ( (float) 3.33), B (3), b ( (float) 2.67), CC ( (float) 2.33), C (2), c ( (float) 1.67), DD ( (float) 1.33), D (1), d ( (float) 0.67), U (0), AB (0);

    public final float value;

    private Grades(float value){
        this.value = value;
    }

}
