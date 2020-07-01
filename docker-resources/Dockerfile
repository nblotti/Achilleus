FROM opencpu/rstudio:latest

RUN R -e "install.packages(\"devtools\")"
RUN R -e "devtools::install_github(\"braverock/PerformanceAnalytics\")"
COPY Rprofile /usr/lib/R/library/base/R/Rprofile
COPY Base.R etc/opencpu/Base.R
EXPOSE 80
