FROM devopsedu/webapp
ADD phpwebapp/ /var/www/html/
EXPOSE 80
CMD ["/usr/sbin/apachectl", "-D", "FOREGROUND"]
