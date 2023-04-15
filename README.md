

* prometheus.yml
  * https://prometheus.io/docs/introduction/overview/
```yml 
global:
scrape_interval: 15s

scrape_configs:
- job_name: "prometheus"
  static_configs:
    - targets: ["localhost:9090"]

- job_name: "node_exporter"
  static_configs:
    - targets: ["localhost:9100"]

- job_name: "redis_exporter"
  static_configs:
    - targets: ["localhost:9121"]

- job_name: "sb_exporter"
  metrics_path: '/actuator/prometheus'
  scrape_interval: 2s
  static_configs:
    - targets: ["localhost:8080"]
```
