# Order of operations
* Video : Linkedin - Spring Web MVC 6 (Ketkee Aryamane)

### Docker
1. Pull Docker Image
`docker pull mysql:8.4`

2. Run docker image
`docker run --name mysql-db -e MYSQL_ROOT_PASSWORD=root1234 -v mysql_data:/var/lib/mysql -p 3307:3306 -d mysql:8.4`

3. **Run docker container**
`docker start <container_id>`
 Mevcut (daha önce oluşturulmuş veya durdurulmuş) bir konteynerı yeniden başlatmak için kullanılan komut **docker container start** komutudur.

### Logging into Database
1. `docker exec -it <container_id> sh`
2. `sh-5.1# mysql -p`
3. `mysql> show databases;`