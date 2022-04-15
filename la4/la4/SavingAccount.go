package main

import "fmt"

type SavingAccount struct {
	number   string
	customer Customer
	balance  float32
}

func (sA *SavingAccount) Init(number string, name string, balance float32) {
	sA.customer.Init(name)
	sA.number = number
	sA.balance = balance
}

func (sA *SavingAccount) Accrue(rate float32) string {
	var interest float32 = 0
	interest = interest + sA.balance*rate
	sA.balance = sA.balance + sA.balance*rate
	return fmt.Sprintf("%f", sA.balance)
}

// func main() {
// 	savingAccount := new(SavingAccount)
// 	savingAccount.Init("1234", "Sena", 12.45)
// 	savingAccount.Accrue(0.05)

// 	// 	fmt.Println(customer.String())

// 	fmt.Println(savingAccount.String())
// }
