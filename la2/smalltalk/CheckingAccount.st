"CheckingAccount extends Account"
Account subclass: CheckingAccount [


    init: num customer: cust balance: bal [
	    number:=num.
	    customer:=cust.
	    balance:=bal.
    ]

    accrue: rate [
        
    ]

]

"Testing
Issue the following command to test program: gst Customer.st Account.st CheckingAccount.st"

"|checkingAccount| checkingAccount:= CheckingAccount new:'01001' customer: 'Senami' balance: 100.00.
checkingAccount asString printNl"
