public class AccountBank {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor mặc định
    public AccountBank() {
    }

    // Constructor với tham số
    public AccountBank(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Getter và Setter cho accountNumber
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    // Getter và Setter cho accountHolderName
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    // Getter và Setter cho balance
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Phương thức gửi tiền
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Gửi tiền thành công. Số dư mới: " + balance);
        } else {
            System.out.println("Số tiền gửi vào không hợp lệ.");
        }
    }

    // Phương thức rút tiền
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Rút tiền thành công. Số dư mới: " + balance);
        } else {
            System.out.println("Số tiền rút ra không hợp lệ hoặc không đủ số dư.");
        }
    }

    // Phương thức chuyển khoản
    public void transfer(AccountBank destinationAccount, double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            destinationAccount.deposit(amount);
            System.out.println("Chuyển khoản thành công. Số dư mới của tài khoản nguồn: " + balance);
        } else {
            System.out.println("Số tiền chuyển khoản không hợp lệ hoặc không đủ số dư.");
        }
    }

    // Phương thức hiển thị thông tin tài khoản
    public void displayAccountInfo() {
        System.out.println("Số tài khoản: " + accountNumber);
        System.out.println("Tên chủ tài khoản: " + accountHolderName);
        System.out.println("Số dư: " + balance);
    }
}
