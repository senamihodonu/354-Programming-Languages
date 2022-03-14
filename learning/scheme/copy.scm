#!/bin/guile
!#

(define (full-copy list)
(if (null? list) 
  '() 
  (if (list? list) 
      (cons (full-copy (car list)) (full-copy (cdr list)))
      list)))