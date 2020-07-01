FROM opencpu/rstudio:latest
COPY Rprofile /usr/lib/R/library/base/R/Rprofile
COPY Base.R etc/opencpu/Base.R
RUN R -e "install.packages(\"devtools\")"
RUN R -e "devtools::install_github(\"braverock/PerformanceAnalytics\")"
EXPOSE 80
