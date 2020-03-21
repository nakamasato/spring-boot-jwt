# Spring Boot JWT

## Set up

1. Create project at https://start.spring.io/
1. Add README  
1. First Commit
1. Follow the blog [Secure a Spring Boot REST API with JSON Web Token](https://medium.com/better-programming/secure-a-spring-boot-rest-api-with-json-web-token-reference-to-angular-integration-e57a25806c50)

## Usage

1. Start App

    ```
    docker-compose up
    ```
    
1. Get token with `joe.doe`

    ```
    curl testjwtclientid:XY7kmzoNzl100@localhost:8080/oauth/token -d grant_type=password -d username="john.doe" -d password="jwtpass"
    {"access_token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidGVzdGp3dHJlc291cmNlaWQiXSwidXNlcl9uYW1lIjoiam9obi5kb2UiLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXSwiZXhwIjoxNTg0MjEzMjY0LCJhdXRob3JpdGllcyI6WyJTVEFOREFSRF9VU0VSIl0sImp0aSI6IjBhYTliODMyLWVhOTAtNGE5Mi04NWViLTI2MWRiMjM2ZmJlMSIsImNsaWVudF9pZCI6InRlc3Rqd3RjbGllbnRpZCJ9.6EeW7puOoicvcNAyfDLATqXue5z9WRH3gYrdvKUyT5E","token_type":"bearer","expires_in":43199,"scope":"read write","jti":"0aa9b832-ea90-4a92-85eb-261db236fbe1"}
    ```
    
1. Try to get resource but fails

    ```
    curl http://localhost:8080/springjwt/users -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidGVzdGp3dHJlc291cmNlaWQiXSwidXNlcl9uYW1lIjoiam9obi5kb2UiLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXSwiZXhwIjoxNTg0MjEzMjY0LCJhdXRob3JpdGllcyI6WyJTVEFOREFSRF9VU0VSIl0sImp0aSI6IjBhYTliODMyLWVhOTAtNGE5Mi04NWViLTI2MWRiMjM2ZmJlMSIsImNsaWVudF9pZCI6InRlc3Rqd3RjbGllbnRpZCJ9.6EeW7puOoicvcNAyfDLATqXue5z9WRH3gYrdvKUyT5E"
    {"error":"access_denied","error_description":"Access is denied"}%
    ```

1. Get token with `admin.admin`

    ```
    ± curl testjwtclientid:XY7kmzoNzl100@localhost:8080/oauth/token -d grant_type=password -d username="admin.admin" -d password="jwtpass"
    {"access_token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidGVzdGp3dHJlc291cmNlaWQiXSwidXNlcl9uYW1lIjoiYWRtaW4uYWRtaW4iLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXSwiZXhwIjoxNTg0MjEzNTIwLCJhdXRob3JpdGllcyI6WyJTVEFOREFSRF9VU0VSIiwiQURNSU5fVVNFUiJdLCJqdGkiOiI0OTM3YWI2ZC04ZGJkLTRhMTktOTMyZi0xNDA5YmJhYzc5ZDUiLCJjbGllbnRfaWQiOiJ0ZXN0and0Y2xpZW50aWQifQ.jsh2pxKY-fOdkOQa8tE72DQ69A_NsoDxJy4BdJMBZe4","token_type":"bearer","expires_in":43199,"scope":"read write","jti":"4937ab6d-8dbd-4a19-932f-1409bbac79d5"}%
    ```
    
1. Successfully get resource

    ```
    ± curl http://localhost:8080/springjwt/users -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidGVzdGp3dHJlc291cmNlaWQiXSwidXNlcl9uYW1lIjoiYWRtaW4uYWRtaW4iLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXSwiZXhwIjoxNTg0MjEzNTIwLCJhdXRob3JpdGllcyI6WyJTVEFOREFSRF9VU0VSIiwiQURNSU5fVVNFUiJdLCJqdGkiOiI0OTM3YWI2ZC04ZGJkLTRhMTktOTMyZi0xNDA5YmJhYzc5ZDUiLCJjbGllbnRfaWQiOiJ0ZXN0and0Y2xpZW50aWQifQ.jsh2pxKY-fOdkOQa8tE72DQ69A_NsoDxJy4BdJMBZe4"
    [{"id":1,"username":"john.doe","firstName":"John","lastName":"Doe","roles":[{"id":1,"roleName":"STANDARD_USER","description":"Standard User - Has no admin rights"}]},{"id":2,"username":"admin.admin","firstName":"Admin","lastName":"Admin","roles":[{"id":1,"roleName":"STANDARD_USER","description":"Standard User - Has no admin rights"},{"id":2,"roleName":"ADMIN_USER","description":"Admin User - Has permission to perform admin tasks"}]}]
    ```

# Notice

If you want to use h2 for datastore, you can revert [#4](https://github.com/nakamasato/spring-boot-jwt/pull/4)
