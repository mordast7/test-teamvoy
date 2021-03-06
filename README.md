# Teamvoy Shop

---

## Description

Create Spring Boot application using Java 11 that serves Rest API for creating orders for some goods for example iPhones.

Requirements

* As a manager you should be able to add goods to db so clients will be able to buy them 
* As a manager/client you should be able to list all available goods and their prices and quantities 
* As a client you should be able to place orders for goods (multiple allowed for example in you order you can buy iPhone 13 Pro 5 units, and iPhone 11 10 units) 
* Your application should manage risks and automatically delete not paid orders after 10 minutes after creation 
* As a client you should be able to pay for your order so provide endpoint that will mark clients order as paid

---

## Technologies

* Java 11
* Spring Boot
* Spring Data
* Spring Boot Security
* Maven
* H2 Database

---

## Structure

### Project built on 3-layered architecture:
* Data access object (DAO)
* Business logic (service)
* Presentation layer (controller)

---

## Features
* create products and goods as admin
* login as user or admin
* display all users as admin
* add goods to shopping cart
* complete order
