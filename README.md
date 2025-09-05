# Trivia Party

## How to run the project

**Prerequities:**
Make sure Docker Desktop is installed

### Running the entire project
To run the entire project, simply run the following command on the CLI in the root of the project:

```
docker compose watch
```

- This will run the frontend application on `localhost:5173`, and it will make use of Vite's HMR to automatically sync the changes you make in the code editor to the container.
- The backend server will run on `localhost:8080`
- The PostgreSQL DB server will be running on `localhost:5433` locally, but `localhost:5432` within the docker container.

While the above command runs all services, it will only "watch" the frontend service, meaning while all services will run, 
only the frontend service will reflect live changes when you edit the source code. 

Don't forget to rebuild your images if you make any changes to the source code (this is for non-watched services):
```
docker compose build
```

### Running specific services
To run only the frontend service:
```
docker compose watch frontend
```

To run the backend service + DB:
```
docker compose up backend -d
```

To run only the DB:
```
docker compose up db -d
```

## How to access the Postgres DB
**Note:** Make sure you are running the Postgres container

There are 3 ways to access the Postgres DB: Through pgAdmin4 (provides GUI), the terminal, or Docker Desktop
- pgAdmin4:
  - Register a new server connection
  - Fill in the credentials (hostname: `localhost`, port: `5433`, database name: `trivia_party`, username: `postgres`, password: `password`) and connect
- Terminal:
  - Within the terminal, type in the command `docker exec -it postgres-db bash` to enter the bash shell of the postgres container
  - Type `psql -U postgres` to connect using the `postgres` user role
  - When finished, use `exit` to leave the bash shell
- Docker Desktop:
  - Within Docker Desktop, click on the actively running `trivia-party-db` container, then go to the `Exec` tab
  - Type `bash`, then type `psql -U postgres`
  - When finished, use `exit` to leave the bash shell

**Note:** During local development, if you desire fresh creation and deletion of all data on every run in the 
Postgres DB, within the `docker-compose.yml` file, change the following environment variable under the backend service to:
```
SPRING_JPA_HIBERNATE_DDL_AUTO=create-drop
```
This will create the schema at startup, and will drop it on shutdown
