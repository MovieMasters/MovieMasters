package domain;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest extends Model {
    private Ticket ticket;
    private Show show;

    @BeforeAll
    static void setUpBeforeAll(){
        System.out.println("----- Running tests for domain.Ticket -----\n");
    }

    @BeforeEach
    void setUp(TestInfo testInfo){
        LocalDate date = LocalDate.of(2018, Month.OCTOBER, 10);
        LocalTime time = LocalTime.of(22, 00);
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        show = new Show(1, date, time,2, 2);
        Account account = new Account("Kees", new char[]{'t','e','s','t'}, "kees@mail.com","Kees" ,"Kogel" );
        PriceCategory priceCategory = new PriceCategory("Ticket", new BigDecimal(2));

        ticket = new Ticket(1, show, account, priceCategory, dateTime);

        System.out.println("Start..." + testInfo.getDisplayName());
    }

    @Test
    @DisplayName("test method getId")
    void getId() {
        assertEquals(1, ticket.getId());
    }

    @Test
    @DisplayName("test method getId")
    void getShow() {
        assertSame(show, ticket.getShow());
    }

    @Test
    void setShow() {
    }

    @Test
    void getAccount() {
    }

    @Test
    void setAccount() {
    }

    @Test
    void getPriceCategory() {
    }

    @Test
    void setPriceCategory() {
    }

    @Test
    void getSellingDate() {
    }

    @AfterEach
    void tearDown(TestInfo testInfo){
        ticket = null;
        assertNull(ticket);

        System.out.println("Finished..." + testInfo.getDisplayName() + "\n");
    }

    @AfterAll
    static void tearDownAfterAll(){
        System.out.println("\n----- Finished testing total class");
    }
}