#!/bin/gprolog --consult-file

:- include('data.pl').

% Your code goes here.

lte(time(Hour,_,Period),time(Hour1,_,Period)) :- Hour < Hour1.

lte(time(Hour,Minute,Period),time(Hour,Minute1,Period)) :- Minute =< Minute1.

available(slot(M1,M2),slot(F1,F2))
    :-lte(F1,M1),lte(M2,F2).

meetone(Person,ProposedSlot)
    :-free(Person,FreeSlot),available(ProposedSlot,FreeSlot).


main :- findall(Person,
		meetone(Person,slot(time(8,30,am),time(8,45,am))),
		People),
	write(People), nl, halt.

:- initialization(main).
