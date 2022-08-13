
# 基于java镜像创建新镜像
FROM java:8
# 作者
MAINTAINER chunyizanchi
# 将jar包添加到容器中并更名为app.jar
ADD  jar/app.jar /root/dockerApp/app.jar
# 运行jar包
ENTRYPOINT ["nohup","java","-jar","/root/dockerApp/jar/app.jar","&"]
