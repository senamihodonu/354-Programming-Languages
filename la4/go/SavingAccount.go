"SavingAccount extends Account"
Account subclass: SavingsAccount [
"instance variable(s)"
    |interest|

    init: num customer: cust balance: bal [
        number:=num.
        customer:=cust.
        balance:=bal.
	interest:=0.0
		
    ]

    accrue: rate [
        interest:=interest+(balance*rate).
        balance:=balance+(balance*rate).
    ]

]

"Testing 
Issue the following command to test program: gst Customer.st Account.st SavingAccount.st"

"|savingAccount| savingAccount:= SavingsAccount new: '01002' customer: 'Senami' balance: 200.00.
savingAccount asString printNl"
