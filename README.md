# Project: Personnel_Search
## What does this achieve

- Get info of certain person in Oracle Database
- Need to log in as admin before searching

## Getting start

- Run java module
```cmd
Powershell.exe ".\LDAP_Sort.ps1" -srcLDAPFile ".\example.ldif" -resultLDAPFile ".\sorted.ldif" -order "0"
```
- Log in via admin account
- Search or quit

## Notes

- Table admin_info
```cmd
CREATE TABLE admin_info (
    id int PRIMARY KEY,
    AdminName varchar(255) NOT NULL UNIQUE ,
    AdminPassword varchar(255) NOT NULL,
    CONSTRAINT Name_Length CHECK(LENGTH(AdminName) >= 8 AND LENGTH(AdminName) <= 20),
    CONSTRAINT Password_Length CHECK(LENGTH(AdminPassword) >= 6 AND LENGTH(AdminPassword) <= 15)
);
```
- You can modify the config file(names.dat) to show personalized row names





java -cp "..\lib\ojdbc11.jar" .\SearchForm.java