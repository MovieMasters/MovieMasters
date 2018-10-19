package domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class Ticket {
    private int id;
    private Show show;
    private Account account;
    private PriceCategory priceCategory;
    private LocalDateTime sellingDate;

    //Constructor to create Ticket to store in Database
    public Ticket(Show show, Account account, PriceCategory priceCategory) {
        this.show = show;
        this.account = account;
        this.priceCategory = priceCategory;
        this.sellingDate = this.sellingDate.now();
    }

    //Constructor to create Ticket with retrieved data from database
    public Ticket(int id, Show show, Account account, PriceCategory priceCategory, LocalDateTime sellingDate) {
        this(show, account, priceCategory);
        this.id = id;
        this.sellingDate = sellingDate;
    }

    public int getId() {
        return id;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public PriceCategory getPriceCategory() {
        return priceCategory;
    }

    public void setPriceCategory(PriceCategory priceCategory) {
        this.priceCategory = priceCategory;
    }

    public LocalDateTime getSellingDate() {
        return sellingDate;
    }

    @Override
    public String toString() {
        return "Ticket{\n" +
                "id=" + id +
                "\n, show=" + show +
                "\n, account=" + account +
                "\n, priceCategory=" + priceCategory +
                "\n, sellingDate=" + sellingDate +
                "\n}";
    }
}
