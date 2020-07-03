COPY myStartupScript.sh /usr/local/myscripts/myStartupScript.sh
source /etc/apache2/envvars
/usr/sbin/apache2 -DFOREGROUND &
java -jar app.jar
