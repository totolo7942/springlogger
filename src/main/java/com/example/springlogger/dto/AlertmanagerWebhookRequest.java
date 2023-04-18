package com.example.springlogger.dto;

import java.util.List;

public class AlertmanagerWebhookRequest {
    private String version;
    private String receiver;
    private String status;
    private List<AlertmanagerAlert> alerts;

    @Override
    public String toString() {
        return "AlertmanagerWebhookRequest{" +
                "version='" + version + '\'' +
                ", receiver='" + receiver + '\'' +
                ", status='" + status + '\'' +
                ", alerts=" + alerts +
                '}';
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<AlertmanagerAlert> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<AlertmanagerAlert> alerts) {
        this.alerts = alerts;
    }
}
