package co.escuelaing.edu.co.examen2.model;

public class Math {
    private String operation;
    private int input;
    private String output;

    public Math(String operation, int input, String output) {
        this.operation = operation;
        this.input = input;
        this.output = output;
    }

    public String getOperation() { return operation; }
    public int getInput() { return input; }
    public String getOutput() { return output; }
}
