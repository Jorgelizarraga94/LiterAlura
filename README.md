# 📚 LiterAlura - Challenge ONE Oracle + Alura

Este proyecto fue desarrollado como parte del **Challenge LiterAlura** del programa de formación **Oracle Next Education (ONE)** en alianza con **Alura Latam**.

Se trata de una aplicación de consola escrita en **Java 17** que permite buscar, almacenar y consultar libros utilizando la **API pública de Gutendex**. La información es guardada en una base de datos relacional (MySQL o PostgreSQL) utilizando **Spring Boot**, **JPA/Hibernate**, **Jackson**, **Lombok**, entre otras tecnologías.

---

## 🚀 Funcionalidades

Desde la consola, el usuario puede interactuar con el sistema mediante el siguiente menú:

1 - Buscar libro
2 - Listar libros registrados
3 - Listar autores registrados
4 - Listar autores vivos en un determinado año
5 - Listar libros por idioma
0 - Salir

---

## 🛠️ Tecnologías utilizadas

- Java 17  
- Spring Boot 3.5.0  
- Maven  
- JPA (Hibernate)  
- Lombok  
- Jackson  
- MySQL o PostgreSQL  
- Gutendex API (https://gutendex.com/)

---

## 📦 Estructura del Proyecto

- `model`: Entidades JPA (Libro, Autor, etc.)
- `repository`: Interfaces para acceso a datos con Spring Data JPA.
- `service`: Lógica de negocio.
- `client`: Conexión e integración con la API de Gutendex.

---

🌐 Fuente de datos
Este proyecto utiliza la Gutendex API para obtener información pública y gratuita sobre libros del Proyecto Gutenberg.

🧠 Aprendizajes
Este proyecto me permitió reforzar y aplicar conocimientos de:

-Consumo de APIs REST externas

-Persistencia de datos con JPA

-Uso de SpringBoot en aplicaciones de consola

-Modelado datos


## ⚙️ Configuración y ejecución

### 1. Clonar el repositorio

git clone https://github.com/Jorgelizarraga94/LiterAlura.git

### 2. Configurar el archivo application.properties

#-----------------------MYSQL-----------------------
#spring.jpa.hibernate.ddl-auto=update
#spring.datasource.url=jdbc:mysql://localhost:3306/literalura?useSSL=false&serverTimezone=UTC
#spring.datasource.username=${DB_USERNAME}
#spring.datasource.password=${DB_PASSWORD}
#spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

#-----------------------POSTGRES--------------------

spring.datasource.url=jdbc:postgresql://localhost:3307/literalura
spring.datasource.username=postgres
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=org.postgresql.Driver
hibernate.dialect=org.hibernate.dialect.HSQLDialect
spring.jpa.hibernate.ddl-auto=update

### 3. Ejecutar la aplicación

✍️ Autor
Lizarraga Jorge
Desarrollador Java | Programa Oracle Next Education
LinkedIn : https://www.linkedin.com/in/jorge-lizarraga-developer/
GitHub : https://github.com/Jorgelizarraga94

