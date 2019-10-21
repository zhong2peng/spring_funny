# spring cloud 组件
eureka 注册中心
config 配置中心
zuul 网关
zipkin 链路
hystrix 熔断器
hystrix dashboard 观察面板 turbine
provider 提供者app
feign-consumer
ribbon-consumer
# 链接
http://localhost:8761/ 注册中心
http://192.168.1.41:8900/hystrix  hystrix监控平台
    单个应用调用监控，http://hystrix-app:port/actuator/hystrix.stream
http://localhost:9411/zipkin/ 链路器
