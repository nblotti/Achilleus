FROM opencpu/rstudio:latest

COPY *.tar.gz nblottirstrategyproxy.tar.gz
RUN R -e "install.packages(\"nblottirstrategyproxy.tar.gz\", repos = NULL, type=\"source\")"
RUN R -e "install.packages(\"devtools\")"
RUN R -e "devtools::install_github(\"braverock/PerformanceAnalytics\")"
COPY Rprofile /usr/lib/R/library/base/R/Rprofile
EXPOSE 80
