import java.util.*;

public class Customer {
    private String firstName;
    private String lastName;
    private ArrayList<Account> acct;
    private int numOfAccount;
    
    public Customer() {
        this("","");
    }
    
    public Customer(String firstName ,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        acct = new  ArrayList();
    }
    
    public Account getAccount(int index) {
        return this.acct.get(index);
    }
    
    public void addAccount(Account acct) {
        this.acct.add(acct);
        this.numOfAccount += 1;
    }
    
    public int getNumOfAccount() {
        return this.acct.size();
    }
    
    @Override
    public String toString() {
        return this.firstName+" "+this.lastName+" has "+this.getNumOfAccount()+" accounts.";
    }
}

//public class Customer {
//    private String firstName, lastName;
//    private Account[] acct;
//    private int numOfAccount;
//    
//    public Customer() {
//        this("", "");
//    }
//    
//    public Customer(String firstName, String lastName) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.acct = new Account[5];
//    }
//   
//    
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//    
//    public String getFirstName() {
//        return firstName;
//    }
//    
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//    
//    public String getLastName() {
//        return lastName;
//    }
//    
//    public Account getAccount(int index) {
//        return acct[index];
//    }
//    
//    public void addAccount(Account acct) {
//        this.acct[this.numOfAccount] = acct;
//        this.numOfAccount ++;
//    }
//    
//    public int getNumOfAccount() {
//        return this.numOfAccount;
//    }
//    
//    @Override
//    public String toString() {
//        if (this.acct.length > 0) {
//           return this.firstName+" "+this.lastName+" doesn’t have account.";
//        } 
//        
//        return "The "+this.firstName+" "+this.lastName+" account has "+this.numOfAccount+" Account.";
//    }
//    
//    public boolean equals(Customer c) {
//        return (this.firstName+this.lastName).equals(c.firstName+c.lastName);
//    }
//}