#!/bin/guile
!#

;Tree Search And Replace operation for non-pairs
(define (atomtsar subj srch repl)
		(if (eq? subj srch)
			(car (cons repl '()))
			(if (not (eq? subj srch))
					 (car (cons subj '())))))
(define (last_element l)
  (cond ((null? (cdr l)) (car l))
        (else (last_element (cdr l)))))

(define (getLastNull lastElement)
	(cdr (cons (last_element '(x)) '())))


(define (combine_lst lst1 lst2)
  (if (null? lst1)
      lst2
      (cons (car lst1)
            (combine_lst (cdr lst1)
                    lst2))))

(define (mycopy lst1 lst2)
      (cons (lst1) (lst2)))


;Tree Search And Replace operation for pairs/non-pairs
(define (tsar subj srch repl)
	(if (null? subj)
      	    subj
	    ;if subj is a non-pair
	    (if (not (pair? subj)) 
                (atomtsar subj srch repl)
	        ;if subj is a pair
		(if (eq? (car subj) srch)
                    (cons repl (tsar (cdr subj) srch repl))
                    (if (pair? (car subj))
                        (cons (tsar (car subj) srch repl)          
                        (tsar (cdr subj) srch repl))
              (cons (car subj) (tsar (cdr subj) srch repl)))))))


;Test cases

;(display "(define (tsar subj srch repl))=")
;(display "\n") 
;(display (tsar 'z 'x 'y))
;(display "\n")
;(display (tsar 'x 'x 'y))
;(display "\n")
;(display (tsar 'x 'x 'x))
;(display "\n")
;(display (tsar '() 'x 'y))
;(display "\n")
;(display (tsar '(x x) 'x 'y))
;(display "\n")
;(display (tsar '(x (x) z) 'x 'y))
;(display "\n")
;(display (tsar '(x (x) z) '(x) '(y y)))
;(display "\n")
;(display (tsar '(x (x) ((x)) z) '(x) '(y y)))
;(display "\n")
;(display (tsar '(x (x) ((x)) z) '(x) '()))
;(display "\n")
;(display (tsar '(x (x) ((x)) z) '() '(y y)))
;(display "\n")
;(display (tsar '(x (x) ((x)) z) '(x) '(61 y)))
;(display "\n")
;(display (tsar '(x (x) ((x)) z) '(x) '(61 61)))
;(display "\n")


(display "(define (tsar subj srch repl))=")
(display "\n") 
(display (tsar 'z 'x 'y))
(display "\n")
(display (tsar 'x 'x 'y))
(display "\n")
(display (tsar 'x 'x 'x))
(display "\n")
(display (tsar '() 'x 'y))
(display "\n")
(display (tsar '(x x) 'x 'y))
(display "\n")
(display (tsar '(x (x) z) 'x 'y))
(display "\n")
(display (tsar '(x (x) z) '(x) '(y y)))
(display "\n")
(display (tsar '(x (x) ((x)) z) '(x) '(y y)))
(display "\n")
(display (tsar '(x (x) ((x)) z) '(x) '()))
(display "\n")
(display (tsar '(x (x) ((x)) z) '() '(y y)))
(display "\n")
(display (tsar '(x (x) ((x)) z) '(x) '(61 y)))
(display "\n")
(display (tsar '(x (x) ((x)) z) '(x) '(61 61)))
(display "\n")

