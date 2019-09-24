-- scans.hs
module Scans where

fibs = 1 : scanl (+) 1 fibs

fibsN x = fibs !! x

fibs20 = take 20 fibs

fibsl100 = takeWhile (<100) fibs

facts = scanl (*) 1 [2..]

factorial n = facts !! n
