# Order of operations
These commands are for linux/Mac, changes will need to made if you are running this in Microsoft Windows.

## Prerequisites
Docker is installed
psql client is installed

## Docker Notes
* docker images : image list
* docker image rm <image_name | image_id>
* docker ps -a  : container list
* docker container rm <container_name | container_id>
* docker rm -f <container_name | container_id> : çalışan bir Docker konteynerini zorla durdurmak ve silmek
* docker info   : docker çalışıyor mu? 
* docker volume ls : konteynerlerin geçici doğasına karşı verilerin kalıcı (persistent) olmasını sağlayan bir depolama mekanizmasıdır.

## Actions

### Running PostgreSQL
1. Pull Docker Image
`docker pull postgres:17`

2. Build data directory
`mkdir -p ~/srv/postgres`

3. Run docker image
`docker run --rm --name postgres-db -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -d -v pgdata:/var/lib/postgresql/data -p 5433:5432 postgres:17`

### Stopping PostgreSQL
`docker stop lil-postgres`

### Logging into Database
* `psql -h localhost -p 5433 -U postgres`
* `psql -h localhost -p 5433 -U postgres -d hplussport`
* `$SQL -> SELECT inet_server_addr(), inet_server_port(); ( 172.17.0.2, 5432 )`


### Creating starter data
1. `psql -h localhost -p 5433 -U postgres -f database.sql`
2. `psql -h localhost -p 5433 -U postgres -d hplussport -f customer.sql`
3. `psql -h localhost -p 5433 -U postgres -d hplussport -f product.sql`
4. `psql -h localhost -p 5433 -U postgres -d hplussport -f salesperson.sql`
5. `psql -h localhost -p 5433 -U postgres -d hplussport -f orders.sql`
