# Contact-Book-Management-System

Welcome to the Java Contact Book Management System! This application is built using Java Swing for the graphical user interface and MySQL for data storage.

## Features

- **Add Contacts**: Easily add new contacts with details such as name, phone number, and email.
- **View Contacts**: Browse through the list of saved contacts with their relevant information.
- **Update Contacts**: Edit contact details to keep information up-to-date.
- **Delete Contacts**: Remove contacts from the list that are no longer needed.
- **Display Contacts**: Displays all the contacts present in database

## Getting Started

### Prerequisites

- Ensure you have [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) installed on your machine.
- Set up a MySQL database to store contact information.

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/shiv-835/Contact-Book-Management-System.git

### Setting up the project
1. Import the project into your preferred Java IDE.
2. Set up the MySQL database by executing the SQL script provided in next step.
3. Run this query inside your database: CREATE TABLE AddressBook ( name varchar(255), phone_number bigint PRIMARY KEY, email varchar(255), city varchar(255), number_type varchar(255));
4. Ensure that sql-connector jar file is added to project

### Usage
Run the Management.java file to start the project
