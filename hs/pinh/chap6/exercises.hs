-- evaluate the factorial of n
fac :: Int -> Int
fac 0 = 1
fac n | n > 0 = n * fac (n-1)

-- evaluate the sum of numbers 0 to n
sumdown :: Int -> Int
sumdown 0 = 0
sumdown n = n + sumdown (n-1)

-- evaluate b to the e power
pow b 0 = 1
pow b e = b * (pow b (e-1))

-- evaluate the GCD using Euclid's algorithm
euclid :: Int -> Int -> Int
euclid m n | m == n = m
	   | m > n  = euclid (m-n) n
	   | n > m  = euclid m (n-m)

-- evaluate whether all elements are True
and' :: [Bool] -> Bool
and' []     = True
and' (b:bs) = b && and' bs

-- evaluate a list consisting of the
-- concatination of sublists
concat' :: [[a]] -> [a]
concat' [[]]        = []
concat' ([]:ys)     = concat' ys
concat' ((x:xs):ys) = x : concat' ((xs):ys)

-- evaluate a list with n identical elements
replicate' :: Int -> a -> [a]
replicate' 0 _ = []
replicate' n x = x : replicate' (n-1) x

-- evaluate the nth element of a list
choose :: Int -> [a] -> a
choose 0 xs = head xs
choose n xs = choose (n-1) (tail xs)

-- evaluate if an element is in a list or not
elem' :: Eq a => a -> [a] -> Bool
elem' _ []    = False
elem' x (y:ys) = if y == x then True else elem' x ys

-- evalautes a sorted list made from
-- two sorted lists
merge :: Ord a => [a] -> [a] -> [a]
merge xs [] = xs
merge [] ys = ys
merge (x:xs) (y:ys) | x <= y    = x : merge xs (y:ys)
		    | otherwise = y : merge (x:xs) ys

-- evaluates a tuple of two halfs of a list
halve :: [a] -> ([a],[a])
halve xs = (take half xs, drop half xs)
	   where half = length xs `div` 2

-- evaluates a sorted list using merge sort
msort :: Ord a => [a] -> [a]
msort [] = []
msort [x] = [x]
msort xs = (\(is, js) -> merge (msort is) (msort js)) (halve xs)

-- evaluates the sum of a list
sum' :: Num a => [a] -> a
sum' = foldr (+) 0

-- evaluates a list that is the first n elements of a list
take' :: Int -> [a] -> [a]
take' 0 _      = []
take' _ []     = []
take' n (x:xs) = x : take (n-1) xs

-- evaluate the last element of a list
last' :: [a] -> a
last' [x]    = x
last' (x:xs) = last' xs
