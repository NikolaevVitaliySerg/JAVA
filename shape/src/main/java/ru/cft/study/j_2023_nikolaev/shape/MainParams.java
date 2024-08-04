package ru.cft.study.j_2023_nikolaev.shape;

public class MainParams {
    private String inputFilePath;
    private String outputFileName;
    private OutputType outputType;

    public MainParams(String inputFilePath, String outputFileName, OutputType outputType) {
        setInputFilePath(inputFilePath);
        setOutputFileName(outputFileName);
        setOutputType(outputType);
    }

    public String getInputFilePath() {
        return this.inputFilePath;
    }

    public void setInputFilePath(String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    public String getOutputFileName() {
        return this.outputFileName;
    }

    public void setOutputFileName(String outputFileName) {
        this.outputFileName = outputFileName;
    }

    public OutputType getOutputType() {
        return this.outputType;
    }

    public void setOutputType(OutputType outputType) {
        this.outputType = outputType;
    }
}
