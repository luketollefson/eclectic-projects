-- chap9ex.hs
module Chap9Ex where

import Data.Char

onlyUpper :: String -> String
onlyUpper = filter isUpper

capFirst :: String -> String
capFirst "" = ""
capFirst (x:xs) = toUpper x : xs

caps :: String -> String
caps "" = ""
caps (x:xs) = toUpper x : caps xs

capFirstLetter :: String -> Char
capFirstLetter = toUpper . head

myOr :: [Bool] -> Bool
myOr [] = False
myOr (x:xs) = x || myOr xs

myAny :: (a -> Bool) -> [a] -> Bool
myAny _ [] = False
myAny p (x:xs) = p x || myAny p xs

myElem' :: Eq a => a -> [a] -> Bool
myElem' _ [] = False
myElem' e (x:xs) = e == x || myElem' e xs

myElem :: Eq a => a -> [a] -> Bool
myElem e xs = any (==e) xs

myReverse :: [a] -> [a]
myReverse [] = []
myReverse (x:xs) = myReverse xs ++ [x]

squish :: [[a]] -> [a]
squish [] = []
squish (x:xs) = x ++ squish xs

squishMap :: (a -> [b]) -> [a] -> [b]
squishMap f xs = squish $ map f xs

squishAgain :: [[a]] -> [a]
squishAgain xs = squishMap id xs

myMaximumBy :: (a -> a -> Ordering) -> [a] -> a
myMaximumBy _ [x] = x
myMaximumBy c (x:xs) = case xVSxs of GT -> x
                                     _  -> xsCompare
  where xsCompare = myMaximumBy c xs
        xVSxs = c x xsCompare
        
myMinimumBy :: (a -> a -> Ordering) -> [a] -> a
myMinimumBy _ [x] = x
myMinimumBy c (x:xs) = case xVSxs of LT -> x
                                     _  -> xsCompare
  where xsCompare = myMinimumBy c xs
        xVSxs = c x xsCompare

myMaximum :: (Ord a) => [a] -> a
myMaximum xs = myMaximumBy compare xs

myMinimum :: (Ord a) => [a] -> a
myMinimum xs = myMinimumBy compare xs

