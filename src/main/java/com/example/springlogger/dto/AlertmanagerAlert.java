package com.example.springlogger.dto;

import java.util.Map;

public class AlertmanagerAlert {
    private String status;
    private Map<String, String> labels;

    private Map<String, String> annotations;

    @Override
    public String toString() {
        return "AlertmanagerAlert{" +
                "status='" + status + '\'' +
                ", labels=" + labels +
                ", annotations=" + annotations +
                '}';
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<String, String> getLabels() {
        return labels;
    }

    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }

    public Map<String, String> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(Map<String, String> annotations) {
        this.annotations = annotations;
    }
}
