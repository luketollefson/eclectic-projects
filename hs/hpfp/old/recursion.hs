-- recursion.hs
module Recursion where

factorial :: Integer -> Integer
factorial 0 = 1
factorial n = n * factorial (n - 1)


inc :: Num a => a -> a
inc = (+1)

incTimes :: (Eq a, Num a) => a -> a -> a
incTimes 0 n = n
incTimes times n = 1 + (incTimes (times - 1) n)

applyTimes :: (Eq a, Num a) => a -> (b -> b) -> b -> b
applyTimes 0 f b = b
applyTimes n f b = f (applyTimes (n-1) f b)

incTimes' :: (Eq a, Num a) => a -> a -> a
incTimes' times n = applyTimes times (+1) n

-- bottom

--f :: Bool -> Int
--f True = error "blah"
--f False = 0

f :: Bool -> Maybe Int
f False = Just 0
f _ = Nothing

fibonacci :: Integral a => a -> a
fibonacci n
  | n < 0 = -10
fibonacci 0 = 0
fibonacci 1 = 1
fibonacci x = fibonacci (x - 1) + fibonacci (x - 2)

{-
type Numerator = Integer
type Denominator = Integer
type Quotient = Integer

divideBy :: Numerator -> Denominator -> Quotient
divideBy = div
-}

dividedBy :: Integral a => a -> a -> (a, a)
dividedBy num denom = go num denom 0
  where go n d count
          | n < d = (count, n)
          | otherwise = go (n - d) d (count + 1)

cattyConny :: String -> String -> String
cattyConny x y = x ++ " mrow " ++ y

flippy = flip cattyConny

appedCatty = cattyConny "woops"
frappe = flippy "haha"

summing :: (Eq a, Num a) => a -> a
summing 0 = 0
summing n = n + summing (n - 1)

data DividedResult a = Result a | DividedByZero deriving (Eq, Ord, Show)

dividedBy' :: Integral a => DividedResult a -> DividedResult a -> DividedResult (a, a)
dividedBy' _ (Result 0) = DividedByZero
dividedBy' (Result num) (Result den) = go num den 0
  where go n d count
          | abs n < abs d = Result (count, n)
          | n > 0 && d > 0 = go (n - d) d (count + 1)
          | n < 0 && d > 0 = go (n + d) d (count - 1)
          | n > 0 && d < 0 = go (n + d) d (count - 1)
          | n < 0 && d < 0 = go (n - d) d (count + 1)

mc91 :: (Ord a, Num a) => a -> a
mc91 n
  | n > 100 = n - 10
  | otherwise = 91
