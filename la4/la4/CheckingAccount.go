package main

import "fmt"

// import (
// 	"fmt"
// )

type CheckingAccount struct {
	number   string
	customer Customer
	balance  float32
}

func (cA *CheckingAccount) Init(number string, name string, balance float32) {
	cA.customer.Init(name)
	cA.number = number
	cA.balance = balance
}

func (cA *CheckingAccount) Accrue(rate float32) string {
	return fmt.Sprintf("%f", cA.balance)
}

// func (cA *CheckingAccount) String() string {
// 	return fmt.Sprintf("number: %s customer: %s balance: %f", cA.number, cA.Customer.name, cA.balance)
// }

// public class CheckingAccount extends Account {

//     public CheckingAccount(String number, Customer customer, double balance) {
// 	this.number=number;
// 	this.customer=customer;
// 	this.balance=balance;
//     }

//     public void accrue(double rate) {}

// }

// func main() {
// 	customer := new(CheckingAccount)
// 	customer.Init("123", "Senami", 2.0)

// 	fmt.Println(customer.String())
// }
