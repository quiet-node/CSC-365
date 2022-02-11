## After cloning the repo, run docker to get the appropriate working env

#### Mysql for apple m1

```
docker pull --platform linux/amd64 mysql
```

#### run mysql image

```
docker run --name myYelpSql -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=myYelpDB -d -p 3306:3306 mysql:latest
```

### Get to mysql bash

```
docker exec -it my_yelp_sql bash
```

### In the bash, to log into mysql

```
mysql -u root -p
```

Then insert password

### SQL commands

```
show databases;
```

```
USE myYelpDB;
SHOW TABLE;
SELECT * FROM business_model;
```

### Make sure springboot-demo-II/backend/src/main/resources/application.properties is filled with:

    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=password
    spring.datasource.url=jdbc:mysql://localhost:3306/mydb
    spring.jpa.hibernate.ddl-auto=update
