# Project: Personnel_Search
## What does this achieve

- Get info of certain person or all persons in Oracle Database
- Need to log in before searching

## Getting start

- Run SearchForm
```cmd
java --enable-preview -cp ".\bin;.\lib\ojdbc11.jar" personnel.form.SearchForm
```
- Log in via admin account(TABLE ADMIN_INFO)
- Quit or search personnel info(TABLE PERSONNEL_INFO)

## Notes
- Searching is case sensitive
- Table ADMIN_INFO
```cmd
CREATE TABLE ADMIN_INFO (
    id int PRIMARY KEY,
    AdminName varchar(255) NOT NULL UNIQUE ,
    AdminPassword varchar(255) NOT NULL,
    CONSTRAINT Name_Length CHECK(LENGTH(AdminName) >= 8 AND LENGTH(AdminName) <= 20),
    CONSTRAINT Password_Length CHECK(LENGTH(AdminPassword) >= 6 AND LENGTH(AdminPassword) <= 15)
);
```
- Table ADMIN_INFO
```cmd
CREATE TABLE personnel_info (
    id int PRIMARY KEY,
    name varchar(255) NOT NULL,
    title varchar(255) NOT NULL, 
    skill varchar(255),
    address varchar(255) UNIQUE,
    phone varchar(255),
    salary varchar(255)
);
```