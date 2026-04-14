# Order of operations
* Video : Linkedin - Learning JDBC (Frank P Moley III)
* These commands are for linux/Mac, changes will need to made if you are running this in Microsoft Windows.

## Prerequisites
Docker is installed
psql client is installed

## Docker Notes
* docker images : image list
* docker image rm <image_name | image_id>
* docker ps: Sadece `şu an çalışan` konteynerleri gösterir.
* docker ps -a: Çalışan, durdurulmuş, hata alıp kapanmış `tüm konteynerleri` gösterir (-a harfi "all" yani "hepsi" anlamına gelir).
* docker container rm <container_name | container_id>
* docker rm -f <container_name | container_id> : çalışan bir Docker konteynerini zorla durdurmak ve silmek
* docker info   : docker çalışıyor mu? 
* docker volume ls : konteynerlerin geçici doğasına karşı verilerin kalıcı (persistent) olmasını sağlayan bir depolama mekanizmasıdır.
* docker run : İmajdan bir konteyner yaratır. Yeni bir konteyner oluşturur ve başlatır. **docker create** ve **docker start** komutlarının birleşimi olduğunu belirtmek önemlidir.
* **docker start <container_id>** : Konteyneri başlat
* Mevcut (daha önce oluşturulmuş veya durdurulmuş) bir konteynerı yeniden başlatmak için kullanılan komut **docker container start** komutudur.
* docker exec : Zaten `çalışmakta olan` bir konteynerin içine girer. Konteyner durmuşsa bu komut çalışmaz.
* docker logs <container_id> : Konteynerin neden ayakta kalmadığını anlamak için "ölü" konteynerin fısıltılarını (loglarını) dinlemek

## Actions

### Running PostgreSQL
1. Pull Docker Image
`docker pull postgres:17`

2. Build data directory
`mkdir -p ~/srv/postgres`

3. Run docker image
`docker run --name postgres-db -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -d -v pgdata:/var/lib/postgresql/data -p 5433:5432 postgres:17`
`docker exec -it postgres-db psql -U postgres -c "\l"`

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

### Creating stored procedure
1. `psql -h localhost -p 5433 -U postgres -d hplussport -f stored_proc.sql`