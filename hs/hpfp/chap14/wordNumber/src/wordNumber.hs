-- wordNumber.hs
module WordNumber where

import Data.List (intersperse)

digitToWord :: Int -> String
digitToWord 0 = "zero"
digitToWord 1 = "one"
digitToWord 2 = "two"
digitToWord 3 = "three"
digitToWord 4 = "four"
digitToWord 5 = "five"
digitToWord 6 = "six"
digitToWord 7 = "seven"
digitToWord 8 = "eight"
digitToWord 9 = "nine"
digitToWord _ = error "bad number"

digitsHelper :: Int -> [Int]
digitsHelper n
  | (fst nd) == 0 = (snd nd) : []
  | otherwise = (snd nd) : (digitsHelper (fst nd))
  where nd = divMod n 10

digits :: Int -> [Int]
digits = reverse . digitsHelper

wordNumber :: Int -> String
wordNumber = concat . intersperse "-" . map digitToWord . digits
