package loans;

public class LoanService {

    private LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public LoanRepository getLoanRepository() {
        return loanRepository;
    }

    public int payForLoan(long id, int amount){
        int debt = (int) loanRepository.findLoanById(id).getDebt();

        if (amount>debt){
            loanRepository.updateDebtWithPayment(id, debt);
            return amount-debt;
        } else {
            loanRepository.updateDebtWithPayment(id, amount);
            return 0;
        }
    }
}
