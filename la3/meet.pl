#!/bin/gprolog --consult-file

:- include('data.pl').
:- include('uniq.pl').

% Your code goes here.

lte(time(Hour,_,Period),time(Hour1,_,Period)) :- Hour < Hour1.

lte(time(Hour,Minute,Period),time(Hour,Minute1,Period)) :- Minute =< Minute1.

available(slot(M1,M2),slot(F1,F2))
    :-lte(F1,M1),lte(M2,F2).

meetone(Person,ProposedSlot)
    :-free(Person,FreeSlot),available(ProposedSlot,FreeSlot).
    
people([ann,bob,carla]).

main :- findall(Slot, meet(Slot), Slots),
        uniq(Slots, Uniq),
        write(Uniq), nl, halt.

:- initialization(main).
