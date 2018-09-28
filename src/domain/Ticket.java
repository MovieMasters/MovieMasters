package domain;

import java.util.Date;

public class Ticket {
    private int id;
    private Show show;
    private Account account;
    private PriceCategory priceCategory;
    private Date sellingDate;

    public Ticket(int id, Show show, Account account, PriceCategory priceCategory, Date sellingDate) {
        this.id = id;
        this.show = show;
        this.account = account;
        this.priceCategory = priceCategory;
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

    public Date getSellingDate() {
        return sellingDate;
    }
}
