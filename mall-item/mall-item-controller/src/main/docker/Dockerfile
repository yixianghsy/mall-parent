FROM openjdk:8
VOLUME /tmp
ADD e3-item-web.jar app.jar
# 设置环境变量
#ENV JAVA_OPTS="-server -Xms512m -Xmx512m"
#ENV DUBBO_IP_TO_REGISTRY 192.168.10.140
# 时区设置
RUN echo "Asia/shanghai" > /etc/timezone
#RUN bash -c 'touch /app.jar'
EXPOSE 8022
ENTRYPOINT ["java", "-jar","/app.jar"]
#ENTRYPOINT ["java","exec java ${JAVA_OPTS}","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
#执行启动命令
#ENTRYPOINT ["java", "-jar","/certif-system-2.1.0.jar"]
#ENTRYPOINT exec java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /app.jar
