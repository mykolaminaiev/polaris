1. Add tool Liquibase to the project. Add new fields to User object using liquibase scripts.
2. Add h2 database to the project and cover DAO layer with integration tests.
3. Add new domain object Organization(use liquibase for persistence migration). Users must belong to some organization. Add service/view layers.
4. Currently in project used Spring Data JPA, migrate project to Spring Data Mongo. What data store is optimal for this application area?