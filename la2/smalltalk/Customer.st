"gst Customer.st"

"Smalltalk Customer program"

Object subclass: Customer [
	|name|

"initialize constructor"
	Customer class [ 
		new [
			^super new init
		]
	]

"initial name"
	init [
		name:= ''
	]

"set name"
	setName: newName [
		name := newName
	]

"asString method"
	asString [
		^name
	]
]
"Testing - Issue the following command to test code:
$ gst Customer.st"
"|customer| customer := Customer new setName: 'Senami'.
customer asString printNl"
