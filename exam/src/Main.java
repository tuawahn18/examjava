import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập thông tin tài khoản từ bàn phím
        System.out.println("Nhập thông tin tài khoản:");
        System.out.print("Số tài khoản: ");
        String accountNumber = sc.nextLine();
        System.out.print("Tên chủ tài khoản: ");
        String accountHolderName = sc.nextLine();
        System.out.print("Số dư: ");
        double balance = sc.nextDouble();

        // Tạo đối tượng AccountBank mới
        AccountBank account = new AccountBank(accountNumber, accountHolderName, balance);

        // Thực hiện các giao dịch
        System.out.println("Chọn loại giao dịch (1: Gửi tiền, 2: Rút tiền, 3: Chuyển khoản):");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.print("Nhập số tiền cần gửi: ");
                double depositAmount = sc.nextDouble();
                account.deposit(depositAmount);
                break;
            case 2:
                System.out.print("Nhập số tiền cần rút: ");
                double withdrawAmount = sc.nextDouble();
                account.withdraw(withdrawAmount);
                break;
            case 3:
                sc.nextLine(); // Đọc ký tự xuống dòng
                System.out.print("Nhập số tài khoản đích: ");
                String destinationAccountNumber = sc.nextLine();
                System.out.print("Nhập số tiền cần chuyển: ");
                double transferAmount = sc.nextDouble();
                AccountBank destinationAccount = new AccountBank(); // Tạo tài khoản đích mới
                destinationAccount.setAccountNumber(destinationAccountNumber);
                account.transfer(destinationAccount, transferAmount);
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }

        // Hiển thị thông tin tài khoản sau giao dịch
        System.out.println("Thông tin tài khoản sau giao dịch:");
        account.displayAccountInfo();

        sc.close();
    }
}
