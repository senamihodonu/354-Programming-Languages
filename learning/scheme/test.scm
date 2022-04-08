#!/bin/guile
!#
(define (tsar subj srch repl)
	(if (null? subj)
      subj
      (if (eq? srch (car subj))
          (cons repl (tsar (cdr subj) srch repl))
          (if (pair? (car subj))
              (cons (tsar (car subj) srch repl)          
                    (tsar (cdr subj) srch repl))
              (cons (car subj) (tsar (cdr subj) srch repl))))))

(display "(define (tsar subj srch repl))=")

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
(display (tsar '(x (x) ((x)) z) '(x) '(RANDOM y)))
(display "\n")
(display (tsar '(x (x) ((x)) z) '(x) '(RANDOM RANDOM)))
(display "\n")

(let ((A 1)) ; outer scope, with A defined to be 1
(let ((A 2) ; inner scope, with A defined to be 2
(B A)) ; and B defined to be A
B)) ; return the value of B

(display (B))
