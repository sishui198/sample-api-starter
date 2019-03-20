#打包部署命令：mvn clean assembly:assembly -Pdev 
#目录结构如下
- bin启动和停止脚本
- logs日志路径
- conf 配置文件的位置
- lib 依赖的jar

#打包生产环境不需要配置的Jar命令:mvn  clean install -Pdev

#注意：打包生产环境后，本地需要运行，则需要执行 mvn clean install