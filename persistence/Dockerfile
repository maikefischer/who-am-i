FROM mcr.microsoft.com/mssql/server:2017-latest

# Create work directory
RUN mkdir -p /usr/work
WORKDIR /usr/work

# Copy local data to Docker container
COPY resources/data /usr/work/data

# Copy sql file to populate DB
COPY resources/scripts /usr/work/scripts

# Grant permissions for the import-data script to be executable
RUN chmod +x /usr/work/scripts/import-data.sh

EXPOSE 1433

# Insert tables and respective data from .csv files
CMD /bin/bash /usr/work/scripts/entrypoint.sh