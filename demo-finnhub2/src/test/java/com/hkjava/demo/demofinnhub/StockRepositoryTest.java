// package com.hkjava.demo.demofinnhub;


// import static org.hamcrest.MatcherAssert.assertThat;
// import static org.hamcrest.Matchers.equalTo;
// import static org.hamcrest.Matchers.hasItem;
// import static org.hamcrest.Matchers.hasProperty;
// import static org.hamcrest.Matchers.not;
// import static org.mockito.ArgumentMatchers.isNotNull;
// import static org.mockito.ArgumentMatchers.isNull;
// import org.hamcrest.CoreMatchers;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
// import org.springframework.context.annotation.Import;
// import org.springframework.test.context.TestPropertySource;
// import com.hkjava.demo.demofinnhub.config.TestDatabaseConfig;
// import com.hkjava.demo.demofinnhub.entity.Stock;
// import com.hkjava.demo.demofinnhub.repository.StockRepository;

// @DataJpaTest // inject Repository related Beans
// @Import(TestDatabaseConfig.class)
// @TestPropertySource(properties = {"spring.jpa.hibernate.ddl-auto=update"})
// public class StockRepositoryTest {

//   @Autowired
//   private StockRepository stockRepository;

//   @Autowired
//   private TestEntityManager entityManager;

//   /*
//    * [ERROR] Errors: [ERROR] StockRepositoryTest.testDeleteById:64 » SQLGrammar could not prepare statement [Table "FINNHUB_STOCK" not found (this database is empty); SQL statement: insert into
//    * finnhub_stock (company_name,country,currency,ipo_date,logo,market_cap) values (?,?,?,?,?,?) [42104-214]] [insert into finnhub_stock (company_name,country,currency,ipo_date,logo,market_cap) values
//    * (?,?,?,?,?,?)] [ERROR] StockRepositoryTest.testFindById:41 » SQLGrammar could not prepare statement [Table "FINNHUB_STOCK" not found (this database is empty); SQL statement: insert into
//    * finnhub_stock (company_name,country,currency,ipo_date,logo,market_cap) values (?,?,?,?,?,?) [42104-214]] [insert into finnhub_stock (company_name,country,currency,ipo_date,logo,market_cap) values
//    * (?,?,?,?,?,?)]
//    * 
//    * 因為.yml 炒左 : validate , update,
//    *  
//    * slove :  create-drop
//    */
//   @Test
//   void testFindById() {
//     Stock entity = new Stock();
//     // entity.setId(15L);
//     entity.setCountry("CN");
//     entity.setCompanyName("Orange Company");
//     entity.setMarketCap(98761234.23);
//     entityManager.persist(entity); // JPA <-> cache memory <-> database harddisk
//     entityManager.flush(); // Database commit; -> harddisk

//     // I am testing the "select * from table where id = 15;"
//     Stock stock = stockRepository.findById(1L).orElse(null);
//     assertThat(stock, hasProperty("country", equalTo("CN")));
//     assertThat(stock, hasProperty("companyName", equalTo("Orange Company")));


//     Stock entity2 = new Stock();
//     entity2.setCountry("US");
//     entity2.setCompanyName("Apple Company");
//     entityManager.persist(entity2);
//     entityManager.flush();;
//   }

//   @Test
//   void testDeleteById() {
//     Stock stock = new Stock();
//     stock.setCountry("CN");
//     stock.setCompanyName("Orange Company");
//     stock.setMarketCap(123456.23);
//     // Use Entitymanaget to save and get id
//     Long id = (long) entityManager.persistAndGetId(stock);
//     // Test case L JPA deleteById()
//     stockRepository.deleteById(id);
//     // Use entityManaget to find by id
//     Stock afterDelete = entityManager.find(Stock.class, id);
//     assertThat(afterDelete, CoreMatchers.nullValue());
//   }

// }
