FROM mcr.microsoft.com/mssql/server:2017-latest

#Set environment vars
ENV ACCEPT_EULA Y
ENV sa_password MyDBPassword!

# Copy local data to Docker container
COPY resources/data /tmp/data

#Copy sql file to populate DB
COPY resources/scripts /tmp/scripts

EXPOSE 1433

# Insert tables and respective data from .csv files
CMD /opt/mssql-tools/bin/sqlcmd -S localhost -U SA -P "MyDBPassword!" -i /tmp/scripts/local-sql-setup.sql