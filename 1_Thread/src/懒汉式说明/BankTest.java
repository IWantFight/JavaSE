package 懒汉式说明;

public class BankTest {
    public static void main(String[] args) {

    }
}

class Bank {
    private static Bank instance;

    public static Bank getInstance() {
        if (instance == null) {
            synchronized (Bank.class) {
                //双重保险。提高懒汉式单例模式的效率
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}
