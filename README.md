
* docker-compose.yml
```yaml
Version: '3.7'  # 파일 규격 버전
services:       # 이 항목 밑에 실행하려는 컨테이너 들을 정의
  prometheus:
    image: prom/prometheus
    container_name: prometheus
    volumes:
      - ./prometheus/config:/etc/prometheus
      - ./prometheus/volume:/prometheus
    ports:
      - 9090:9090
    command: # web.enalbe-lifecycle은 api 재시작없이 설정파일들을 reload 할 수 있게 해줌
      - '--web.enable-lifecycle'
      - '--config.file=/etc/prometheus/prometheus.yml'
    restart: always
    networks:
      - promnet

  grafana:
    image: grafana/grafana
    container_name: grafana
    # user: "$GRA_UID:$GRA_GID"
    ports:
      - 3000:3000 # 접근 포트 설정 (컨테이너 외부:컨테이너 내부)
    volumes:
      - ./grafana/volume:/var/lib/grafana
    restart: always
    networks:
      - promnet

networks:
  promnet:
    driver: bridge
```

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
