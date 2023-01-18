package loans;

public class Loan {

    private Long id;
    private String name;
    private long debt;
    private double interest;

    public Loan(Long id, String name, long debt, double interest) {
        this.id = id;
        this.name = name;
        this.debt = debt;
        this.interest = interest;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getDebt() {
        return debt;
    }

    public double getInterest() {
        return interest;
    }
}
