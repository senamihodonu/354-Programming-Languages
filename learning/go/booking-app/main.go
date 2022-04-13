package main //go requires a package
import (
	"fmt"     //used to print
	"strings" //used for Fields
)

func main() { //entrypoint
	//var conferenceName = "Go Conference"
	//var conferenceName string = "Go Conference"
	conferenceName := "Go Conference" //we can also use :=. := does not work for constants or when we have to explicitly declare a type
	const conferenceTickets = 50
	var remainingTickets uint = 50 //unit - positive value only
	//var bookings [50]string //array with 50 elements
	var bookings []string //slice

	fmt.Printf("conferenceTickets is %T, remainingTickets is %T, conferenceName is %T\n", conferenceTickets, remainingTickets, conferenceName)
	// fmt.Println("Welcome to", conferenceName, "our conference booking application")
	// fmt.Println("We have a total of", conferenceTickets, "tickets and", remainingTickets, "remaining")

	fmt.Printf("Welcome to %v our conference booking application\n", conferenceName) //print format functions
	fmt.Printf("We have a total of %v tickets and %v remaining\n", conferenceTickets, remainingTickets)
	fmt.Println("Get your tickets here")

	for {
		var firstName string
		var lastName string
		var email string
		var userTickets uint
		//read user inputs
		fmt.Println("Please enter your first name")
		fmt.Scan(&firstName) //memory address of firstName

		fmt.Println("Please enter your last name")
		fmt.Scan(&lastName)

		fmt.Println("Please enter your email address")
		fmt.Scan(&email)

		fmt.Println("Pleae enter number of tickets")
		fmt.Scan(&userTickets)

		// if userTickets > remainingTickets {
		// 	fmt.Printf("We only have %v tickets available, can't book %v tickets\n", conferenceTickets, userTickets)
		// 	continue
		// }

		if userTickets < remainingTickets {
			remainingTickets = remainingTickets - userTickets

			//bookings[0] = firstName + " " + lastName //for arrays
			bookings = append(bookings, firstName+" "+lastName)

			//fmt.Printf("The whole bookings array: %v\n", bookings)
			fmt.Printf("The whole bookings slice: %v\n", bookings)
			fmt.Printf("The first value: %v\n", bookings[0])
			//fmt.Printf("Array type: %T\n", bookings)
			fmt.Printf("Slice type: %T\n", bookings)
			//fmt.Printf("Array length: %v\n", len(bookings))
			fmt.Printf("Slice length: %v\n", len(bookings))
			fmt.Printf("User %v %v with email address %v booked %v tickets\n", firstName, lastName, email, userTickets)
			fmt.Printf("There are %v tickets remaining\n", remainingTickets)

			firstNames := []string{} //slice to store only first names
			//iterating through the slice of bookings
			//"strings.Fields()"
			//Splits the string with white space as separator
			//And returns a slice with the split elements
			//"Nicole Smith" --> ["Nicole", "Smith"]
			for _, booking := range bookings { //_ used for unused indentifiers
				var names = strings.Fields(booking)
				firstNames = append(firstNames, names[0])
			}

			fmt.Printf("The first names of bookings are: %v\n", firstNames)
			noTicketRemaining := remainingTickets == 0
			if noTicketRemaining {
				//end program
				fmt.Println("Our conference is booked out.")
				break
			}

		} else {
			fmt.Printf("We only have %v tickets available, can't book %v tickets\n", conferenceTickets, userTickets)
		}

	}
}
