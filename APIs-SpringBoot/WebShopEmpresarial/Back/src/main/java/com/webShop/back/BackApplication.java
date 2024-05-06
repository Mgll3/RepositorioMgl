package com.webShop.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackApplication.class, args);
        /* 
        mvn package -DskipTests
        docker build -t lab2:1.03 .
		docker pull mysql:8.1
		docker run --name mysql-standalonewb -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=dbwebshop -e MYSQL_USER=dev -e MYSQL_PASSWORD=dev -p 3306:3306 -d mysql:8.1
		docker run -d -p 8080:8080 --name web-shop --link mysql-standalonewb:mysql e5ffd3c9309b






		docker image ls

		docker commit nombre_del_contenedor nombre_de_la_imagen
		docker commit 925ec13322ac agro-plantation
		docker commit 36b6f8129087 mysql-standalone

		docker tag nombre_de_la_imagen usuario_dockerhub/nombre_del_repositorio
		docker tag lab2:1.02 mgll3/web-shop:Api-v1.02
		docker tag mysql-standalone mgll3/web-shop:Mysql-v1.0
		
		docker push mgll3/web-shop:Api-v1.02
		docker push mgll3/web-shop:Mysql-v1.1
        */
    }

    
    

    
    

}
