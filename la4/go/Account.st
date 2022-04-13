Object subclass: Account [
"instance variable"
    |number|
    |customer|
    |balance|
    
"Account class constructor"
    Account class [
        new: num customer: cust balance: bal [
            ^self new init: num customer: cust balance: bal
        ]
    ]
    
"abstract method"
    accrue: rate [
		^self subclassResponsibility
	]

    balance [
	    ^balance
    ]

    deposit: amount [
	    balance:=balance+amount
    ]

    withdraw: amount [
	    balance:=balance-amount
    ]

    asString [
		^number asString, ':', customer asString, ':', balance asString.
	]

]

"Testing included in CheckingAccount.st & SavingsAccount.st files"


