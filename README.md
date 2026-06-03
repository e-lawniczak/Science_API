# ScienceAPI

This project aim is to implement collaborative text editor such as Google Docs and pair it with groups and supervising features.

The Idea came from a friend of mine who is working in chemistry laboratory. Most useful notes like this online are paid
and offer wide range of features that might not be useful for project keeping and supervising within a student's group.

The main function is to create documents and tables that track chemical reactions done withing a scope of a paper or
a project. Such list has to be available to the supervisor. He also needs to be able to provide comments and make edits.
Documents should provide access control and be visible only to those who are privileged to view them.

## Built with
[![Spring][Spring]][Spring-url]
[![Typescript][Typescript]][Typescript-url]
[![React][React.js]][React-url]
[![Postgres][Postgres]][Postgres-url]
[![Docker][Docker]][Docker-url]


## Running the project
```
docker compose -f docker-compose.yml
```

## ICD 11 Search


## LAB_NOTES
### Functional requirements 
#### Anonymous user
- View login page
- Log in
- Reset password
#### Basic user
- View assigned science groups
- Leave a science group
- View accessible documents within science group
- Comment accessible documents withing science group
- Edit accessible documents within science group
- Create and edit new document
- Set privileges for documents
- Soft delete owned documents
- Manage profile (change password and email)
#### Supervisor user
- Everything basic user can do
- Create, view, edit, and delete science group
- Add users to science group using email or username
- Permanently delete documents from science group
- Edit all documents within science group
- View all documents within science group
#### Admin user
- Create users
- Reset user password
- Manage users (change roles, deactivate accounts, delete accounts)
### Nonfunctional requirements
- App is dockerized and easy to deploy on any server
- UI compatible with Mozilla Firefox and Chrome
- After logging in creating or accessing recently view document requires only 1 click
- Text editor handles basic rich text functions and images

[Spring]:https://img.shields.io/badge/Spring-2eca12?style=for-the-badge&logo=spring&logoColor=ffffff
[Spring-url]: https://docs.spring.io/spring-framework/docs/current/reference/html/
[React.js]: https://img.shields.io/badge/react-61DAFB?style=for-the-badge&logo=react&logoColor=000000
[React-url]: https://reactjs.org/
[Typescript]: https://img.shields.io/badge/typescript-007acc?style=for-the-badge&logo=Typescript&logoColor=ffffff
[Typescript-url]: https://www.typescriptlang.org/
[Postgres]:https://img.shields.io/badge/Postgres-0064a5?style=for-the-badge&logo=Postgresql&logoColor=ffffff
[Postgres-url]:https://www.postgresql.org/
[Docker]:https://img.shields.io/badge/Docker-0db7ed?style=for-the-badge&logo=Docker&logoColor=ffffff
[Docker-url]:https://www.docker.com/