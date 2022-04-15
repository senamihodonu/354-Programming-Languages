package main

import "fmt"

type Bank struct {
	accounts map[*IAccount]IAccount
}

func (b *Bank) Add(account IAccount) {
	b.accounts = make(map[*IAccount]IAccount)
	b.accounts[&account] = account
}

func (b *Bank) Accrue(rate float32) {
	for _, account := range b.accounts {
		account.Accrue(rate)
	}
}

func (b *Bank) String() {
	for _, account := range b.accounts {
		fmt.Println(account)
	}
}

func main() {
	bank := new(Bank)

	checkingAccount := new(CheckingAccount)
	checkingAccount.Init("01001", "Ann", 100.00)
	bank.Add(checkingAccount)
	bank.Accrue(0.02)
	bank.String()

	savingAccount := new(SavingAccount)
	savingAccount.Init("01002", "Ann", 200.00)
	bank.Add(savingAccount)
	bank.Accrue(0.02)
	bank.String()
}
