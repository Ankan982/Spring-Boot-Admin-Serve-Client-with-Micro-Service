# Spring Boot Admin Server & Client

Leveled up my microservices observability game today! 🛠️📊

I’ve successfully integrated and configured a multi-service setup involving two Spring Boot microservices (app-service1 and app-service2) seamlessly registering 
with a centralized Spring Boot Admin Server.

Observability shouldn't be an afterthought, and having a single pane of glass to monitor distributed applications changes everything. 
Through this setup, I configured:

✅ Real-Time Log Streaming & Rotation: Integrated custom SLF4J/Logback configurations mapped directly into the Spring Boot Admin UI via Actuator (/actuator/logfile). Live logs are accessible instantly without ever needing to SSH into a server. 
✅ Advanced Application Health Monitoring: Exposed deep visibility into system metrics and service statuses using tailored Spring Boot Actuator endpoints.
✅ IP-Based Client Registration: Configured precise service tracking using dynamic IP-based client lookup (prefer-ip=true), making containerized or local multi-instance routing highly reliable.
