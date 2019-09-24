-- lists.hs


module Lists where

import Data.Bool (bool)

myTail :: [a] -> [a]
myTail []     = []
myTail (_:xs) = xs

safeTail :: [a] -> Maybe [a]
safeTail []     = Nothing
safeTail (_:[]) = Nothing
safeTail (_:xs) = Just xs

safeHead :: [a] -> Maybe a
safeHead []    = Nothing
safeHead (x:_) = Just x

myEnumFromTo :: Enum a => a -> a -> [a]
myEnumFromTo x y
  | (fromEnum x) >  (fromEnum y) = []
  | (fromEnum x) == (fromEnum y) = [x]
  | otherwise = x : myEnumFromTo (succ x) y

eftBool :: Bool -> Bool -> [Bool]
eftBool True True = [True]
eftBool False False = [False]
eftBool True _ = []
eftBool _ _ = [False, True]

eftOrd :: Ordering -> Ordering -> [Ordering]
eftOrd o p
  | o > p = []
  | o == p = [o]
  | otherwise = o : eftOrd (succ o) p

eftInt :: Int -> Int -> [Int]
eftInt x y
  | x > y = []
  | x == y = [x]
  | otherwise = x : eftInt (x + 1) y

eftChar :: Char -> Char -> [Char]
eftChar c k
  | c > k = []
  | c == k = [c]
  | otherwise = c : eftChar (succ c) k

myWords :: String -> [String]
myWords "" = []
--myWords (' ':s) = takeWhile (/= ' ') s : myWords (dropWhile (/= ' ') s)
myWords s = takeWhile (/= ' ') s : myWords (dropWhile (== ' ') (dropWhile (/= ' ') s))

myLines :: String -> [String]
myLines "" = []
myLines s = takeWhile (/= '\n') s : myLines (safeTail $ dropWhile (/= '\n') s)
  where safeTail xs = case xs of [] -> []
                                 (_:xss) -> xss

mySep :: (Eq a) => a -> [a] -> [[a]]
mySep _ [] = []
mySep sep s = takeWhile (/= sep) s : mySep sep (dropWhile (== sep) (dropWhile (/= sep) s))

shouldEqual =
  [ "Tyger Tyger, buring bright"
  , "In the forests of the night"
  , "What immortal hand or eye"
  , "Could fame thy fearful symmetry?" ]

{-
main :: IO ()
main =
  print $
  "Are they equal? "
  ++ show (myLines sentences == shouldEqual)
-}

myWords' :: String -> [String]
myWords' = mySep ' '

myLines' :: String -> [String]
myLines' = mySep '\n'

mySum :: Num a => [a] -> a
mySum [] = 0
mySum (x:xs) = x + mySum xs

foldBool :: a -> a -> Bool -> a
foldBool x y p = if p then y else x

mapBool :: (a -> Bool) -> (a -> b) -> (a -> b) -> [a] -> [b]
mapBool p f g xs = map (\a -> bool (g a) (f a) (p a)) xs

myFilter :: String -> [String]
myFilter = filter (\w -> not $ elem w ["the","a","an"]) . words

zip' :: [a] -> [b] -> [(a, b)]
zip' [] _ = []
zip' _ [] = []
zip' (x:xs) (y:ys) = (x, y) : zip' xs ys

zipWith' :: (a -> b -> c) -> [a] -> [b] -> [c]
zipWith' _ [] _ = []
zipWith' _ _ [] = []
zipWith' f (x:xs) (y:ys) = f x y : zipWith' f xs ys
