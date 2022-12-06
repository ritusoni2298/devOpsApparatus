package com.brudite.devops.model;

public enum StageStatus {
    STEP_ONE("Step 1", 1, "Step 1 Completed"),
    STEP_TWO("Step 2", 2, "Step 2 Completed"),
    STEP_THREE("Step 3", 3, "Task Completed");

    private final String name;
    private final Integer statusCode;
    private final String result;

    private StageStatus(String name, Integer statusCode, String result){
        this.name = name;
        this.statusCode = statusCode;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getResult() {
        return result;
    }
}
