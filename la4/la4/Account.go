package main

import "fmt"

type IAccount interface {
	//Name() string
	//Customer() Customer
	//Balance() float32
	Accrue(rate float32) string
}

type Account struct {
	number   string
	customer Customer
	balance  float32
}

func NewAccount(name string, number string, balance float32) (a *Account) {
	a = new(Account)
	a.Init(name, number, balance)
	return
}

func (a *Account) Init(name string, number string, balance float32) {
	a.customer.Init(name)
	a.number = number
	a.balance = balance
	return
}

func (a *Account) Balance() float32 {
	return a.balance
}

func Deposit(amount float32) (a *Account) {
	a.balance = a.balance + amount
	return
}

func Withdraw(amount float32) (a *Account) {
	a.balance = a.balance - amount
	return
}

func (a *Account) String() string {
	return fmt.Sprintf("%s : %s : %f", a.number, a.customer.String(), a.balance)
}

// func main() {
// 	var aa *Account = NewAccount("Senami", "123", 12.5)

// 	fmt.Println(aa)
// }

// public abstract class Account {

//     protected String number;
//     protected Customer customer;
//     protected double balance;

//     public abstract void accrue(double rate);

//     public double balance() {
// 	return balance;
//     }

//     public void deposit(double amount) {
// 	balance+=amount;
//     }

//     public void withdraw(double amount) {
// 	balance-=amount;
//     }

//     public String toString() {
// 	return number+":"+customer+":"+balance;
//     }

// }
