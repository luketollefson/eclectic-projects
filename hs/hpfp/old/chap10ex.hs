-- chap10ex.hs
module Chap10Ex where

--import Data.Bool

stops  = "pbtdkg"
vowels = "aeiou"

combos :: [(Char,Char,Char)]
combos = [('p',v,s2) | s2 <- stops, v <- vowels]

nouns = ["dog", "fish", "cake"]
verbs = ["eats", "sees", "smells"]

combos2 = [(n1,v,n2) | n1 <- nouns, n2 <- nouns, v <- verbs]

avgWordLength :: String -> Int
avgWordLength x = div (sum (map length (words x))) (length (words x))

avgWordLength' :: String -> Double
avgWordLength' x = fromIntegral (sum . map length $ words x) /
                   fromIntegral (length $ words x)

myOr :: [Bool] -> Bool
myOr = foldr (||) False

myAny :: (a -> Bool) -> [a] -> Bool
--myAny p = foldr (\a b -> p a || b) False
--myAny p = foldr ((||) . p) False
myAny = flip foldr False . ((||) .)

myElem :: Eq a => a -> [a] -> Bool
--myElem e = foldr (\a b -> e == a || b) False
--myElem e = foldr ((||) . (==e)) False
myElem = flip foldr False . ((||) .) . (==)

myElem' :: Eq a => a -> [a] -> Bool
myElem' = any . (==)

myReverse :: [a] -> [a]
myReverse = foldl (flip (:)) []

myMap :: (a -> b) -> [a] -> [b]
--myMap f = foldr (\a b -> f a : b) []
myMap = flip foldr [] . ((:) .)

myFilter :: (a -> Bool) -> [a] -> [a]
myFilter p = foldr (\a b -> if p a then (a : b) else b) []
--myFilter = flip foldr [] . ((:) 

squish :: [[a]] -> [a]
squish = foldr (++) []

squishMap :: (a -> [b]) -> [a] -> [b]
squishMap = flip foldr [] . ((++) .)

squishAgain :: [[a]] -> [a]
squishAgain = squishMap id

myMaximumBy :: (a -> a -> Ordering) -> [a] -> a
--myMaximumBy o l = foldr (\a b -> case o a b of GT -> a
--                                               otherwise -> b) (head l) l
myMaximumBy o l = foldr (\a b -> if o a b == GT then a else b) (head l) l

myMinimumBy :: (a -> a -> Ordering) -> [a] -> a
myMinimumBy o l = foldr (\a b -> if o a b == LT then a else b) (head l) l
