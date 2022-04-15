package main

import "fmt"

type Customer struct {
	name string
}

func (c *Customer) Init(name string) {
	c.name = name
}

func (c *Customer) String() string {
	return fmt.Sprintf("%s", c.name)
}

// For testing only
// func main() {
// 	customer := new(Customer)
// 	customer.Init("Senami")
// 	fmt.Println(customer.String())
// }
