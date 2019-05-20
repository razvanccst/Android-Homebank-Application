package com.example.homebankapplication;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String username;
    private String password;
    private List<Account> accounts;

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
        this.accounts = new ArrayList<Account>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public Account getAccount(int id){
        for(Account account: accounts){
            if(id == account.getId()){
                return account;
            }
        }
        return null;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean changePassword(String currentPassword,String newPassword){
        if(currentPassword == this.password){
            setPassword(newPassword);
            return true;
        }
        return false;
    }

    public void addAccount(Account account){
        this.accounts.add(account);
    }

    public void removeAccount(Account account){
        this.accounts.remove(account);
    }


}