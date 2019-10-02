copy appl\target\arapp.war C:\sres\apache-tomcat-8.5.32\webapps /Y
catalina.bat stop
del C:\sres\apache-tomcat-8.5.32\webapps\arapp /Q
catalina.bat start 