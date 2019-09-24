import Data.Foldable

inc :: Int -> Int
inc n = n + 1

mult :: (Int,Int) -> Int
mult (x,y) = x * y

mult' :: Int -> Int -> Int
mult' x = \y -> x * y

inf :: Int
inf = 1 + inf

square :: Int -> Int
square n = n * n

ones :: [Int]
ones = 1 : ones

take' 0 _     = []
take' _ []    = []
take' n (x:xs) = x : take' (n-1) xs

primes :: [Int]
primes = sieve [2..]

sieve :: [Int] -> [Int]
sieve (p:xs) = p : sieve [x | x <- xs, x `mod` p /= 0]

sumwith :: Int -> [Int] -> Int
sumwith v []     = v
sumwith v (x:xs) = sumwith (v+x) xs

sumwith' :: Int -> [Int] -> Int
sumwith' v []     = v
sumwith' v (x:xs) = (sumwith' $! (v+x)) xs
