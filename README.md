# bc2307-springboot

RESTful -> GET , PUT ,DELETE ....
POST 用黎insert，not update



JoaRepositoty -> dependency 做操作


1.搵@autowire -> 有冇bean
2.搵@value（not Lombok） -> 可唔可以create object
3.該Class create Bean 
4.scan @Service / @Configuration / @Controller -> start server


AppConfig 都係bean

### 就咁有controller已經叫切片編程AOP
有人會autowired你，因為你係Bean

#### 18 Sep

- enum (Code. java, ApiResponse. java)

- BusinessException, JPHException

- Mapper Logic (UserMapper. java, used to convert from User -> UserDTO)

- @WebMvcTest -> @Autowird MockMvc -> @MockBean

- @SpringBootTest (Complete SB environment, full context)

- ResponseEntity because sometimes we have to return non-200 status

- GlobalExceptionHandler (ControllerAdvice)


modelMapper 自動map 2 個class，唔洗自己寫，兩個class field 名一樣就自動map


server out of memory : 有Bean 未處理好 -> restTemplate -> multy thread