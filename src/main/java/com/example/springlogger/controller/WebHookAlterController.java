package com.example.springlogger.controller;

import com.example.springlogger.dto.AlertmanagerWebhookRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class WebHookAlterController {

    @PostMapping("/alert")
    @ResponseStatus(HttpStatus.OK)
    public void alter(@RequestBody AlertmanagerWebhookRequest alertNotification) {
        System.out.println(alertNotification.toString());
    }
}

//# prometheus webhook request
/*
alerting:
  alertmanagers:
    - static_configs:
         - targets:
              - localhost:9093
rule_files:
  - "/opt/homebrew/etc/alert.yml"

 */

//# altermanager.yml
/*
route:
  group_by: ['alertname']
  group_wait: 2s
  group_interval: 10s
  repeat_interval: 1m
  receiver: 'web.hook'
receivers:
  - name: 'web.hook'
    webhook_configs:
      - url: 'http://127.0.0.1:5001/alert'
inhibit_rules:
  - source_match:
      severity: 'critical'
    target_match:
      severity: 'warning'
    equal: ['alertname', 'dev', 'instance']
 */

//# alert.yml & checked promtool check rules alert.yml
/*
groups:
- name: example
  rules:
  - alert: NodeExporterDown
    expr: up{job="node_exporter"} == 0
    for: 10s
    labels:
      severity: critical
    annotations:
      summary: "Node exporter is down (instance {{ $labels.instance }})"
      description: "Node exporter is down for more than 5 minutes."
 */

