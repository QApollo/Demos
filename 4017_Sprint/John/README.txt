// Build an image from the Dockerfile assign it a name.
docker build -t eg_postgresql .

// starting DB
docker run --rm -P --name pg_test eg_postgresql

// to connect to remote postgresql DB type
psql -h localhost -p <port number 5#> -d docker -U docker --password
