package main

import (
	"fmt"
)

type Customer struct {
	name string
}

type CheckingAccount struct {
	number   string
	customer Customer
	balance  float32
}

func (cA *CheckingAccount) Init(number string, customer Customer, balance float32) {
	cA.number = number
	cA.customer = customer
	cA.balance = balance
}

func (cA *CheckingAccount) String() string {
	return fmt.Sprintf("number: %s customer: %s balance: %f", cA.number, cA.customer, cA.balance)
}

// public class CheckingAccount extends Account {

//     public CheckingAccount(String number, Customer customer, double balance) {
// 	this.number=number;
// 	this.customer=customer;
// 	this.balance=balance;
//     }

//     public void accrue(double rate) {}

// }

func main() {
	customer := new(CheckingAccount)
	customer.Init("Senami", Customer{"Senami"}, 2.0)

	fmt.Println(customer.String())
}

