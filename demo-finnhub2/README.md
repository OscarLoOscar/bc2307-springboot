1.0.1 -> Version 版本-> api/v1 -> 連唔到version

1. @Controller + @ResponseBody -> @RestController
-> Bean + Web Layer
2. @Service
->Bean
3. Repository (JPA + Hibernate)
-> before 做JPA-> define Entity 先,with @Id 
-> Bean
-> Jpa include basic CRUD operations
-> method name rules for Hibernate generating implements
-> Query (JPQL or NativeQuery/NativeSQL)
-> nativeQuery = True
2. RestTemplate
-> getForObject
-> UriComponentBuilder(with yml , @Value)
-> Define the return type (Object or Array)
3. model class , 接野 用DTO，轉番落自己model度
-> lombok
-> ModelMapper
-> mapper Class
4. Test Code
-> By Environment & Layer
 -> @WebMvcTest (@Controller Only)
 ->@MockBean for Service (Controller Autowird Service)
 ->Mockito , when -> thenReturn for MockBean
