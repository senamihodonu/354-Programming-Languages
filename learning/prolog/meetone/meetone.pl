#!/bin/gprolog --consult-file

:- include('data.pl').


compareEnd(time(Hour,Minute,Period),time(Hour1,Minute1,Period1)) :- Hour1 >= Hour, Minute1 >= Minute, Period1 == Period.
compareStart(time(Hour,Minute,Period),time(Hour1,Minute1,Period1)) :- Hour1 =< Hour, Minute1 =< Minute, Period1 == Period.
meetone(Person, slot(Time, Time1)) :- free(Person, slot(Time2,Time3)), compareStart(Time,Time2), compareEnd(Time1,Time3).

main :- debug, trace, debugging, spy(meetone), findall(Person,
		meetone(Person,slot(time(8,30,am),time(8,45,am))),
		People),
	write(People), nl, halt.

:- initialization(main).