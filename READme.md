### Notes about things done and TODOs

#### Find in the project all occurrences of "TODO"/"FIXME" and add/fix them

- Some useful plugins to have in IntelliJ during development:
  - Sonarlint
  - JPA Buddy
  - GenerateAllSetter
  - Lombok
  
- BaseEntity is currently a BaseEntity, which actually has no behaviour or data (so it can be removed).  
If common behaviour like Auditing is required,  instead of extending BaseEntity, the Entities can extend AbstractAuditingEntity.  

- If detailed view-model and corresponding attributes information for OpenAPI is required, use anotations on ResponseMessage.java

- On src/main/java/com/elearningsystem/vm -> put request/response models for the enpoints. also the actual view-model for each entity.
- com/elearningsystem/vm/common => If an endpoint might require that on the response you add a message (success/warning etc), 
the response e.g. StudentCreateResponse.java should extend BaseResponse.java. Even if for example the response should contain just the created student,
it can be an attribute of StudentCreateResponse.java.
- com/elearningsystem/vm/common => If you need pagination use PagedDataResponse - add more attributes if needed

- Unlike the example project, @Autowired should be avoided. Instead, use constructor injection.  
Since we are using lombok, the fields of a Service, can be declared final, and the service can be annotated with @RequiredArgsConstructor.

- Annotations from  jakarta.validation.constraints can be used on entities as well (optional). These causes entities to be validated
before calling the database for inserts/updated. Not required - just an optimization.

- Only relevant if you can change the DB at this point, its better to name DB columns and also the naming
on @Column(name = "column_name") to be in snake_case. e.g. enrollment_date  
Also no need to name PK of each entity as EnrollmentID, simply id for both entity and DB column.

- Security, roles seem fine from the example project. Same structure can be reused

- Creating interfaces for services when there will only be one implementation is not really necessary. You can decide yourself if you want them or not.
If yes, to avoid having "...Impl" use "I..." for interface name.