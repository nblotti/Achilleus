FROM opencpu/rstudio:latest

COPY *.tar.gz nblottirstrategyproxy.tar.gz
RUN R -e "install.packages(\"nblottirstrategyproxy.tar.gz\", repos = NULL, type=\"source\")"
RUN R -e "install.packages(\"devtools\")"
RUN R -e "devtools::install_github(\"braverock/PerformanceAnalytics\")"
COPY Rprofile /usr/lib/R/library/base/R/Rprofile
COPY myStartupScript.sh /usr/local/myscripts/myStartupScript.sh


RUN apt-get update && apt-get install -y openjdk-11-jdk
# Setup JAVA_HOME -- useful for docker commandline
ENV JAVA_HOME /usr/lib/jvm/java-11-openjdk-amd64/
RUN export JAVA_HOME

ARG JAR_FILE=@project.artifactId@-@project.version@.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
CMD ["/bin/bash", "/usr/local/myscripts/myStartupScript.sh"]
