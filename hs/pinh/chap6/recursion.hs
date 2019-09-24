-- evaluate the factorial of n
fac :: Int -> Int
fac 0 = 1
fac n = n * fac (n-1)

-- evaluate the product of m and n
mult :: Int -> Int -> Int
mult m 0 = 0
mult m n = m + (m * (n-1))

-- evaluate the product of a list
product' :: Num a => [a] -> a
product' []     = 1
product' (n:ns) = n * product ns

-- evaluate the length of a list
length' :: [a] -> Int
length' []     = 0
length' (_:xs) = 1 + length' xs

-- evaluate the reverse of a list
reverse' :: [a] -> [a]
reverse' []     = []
reverse' (x:xs) = reverse' xs ++ [x]

-- evaluate a list comprising of a
-- list appended on a list
append :: [a] -> [a] -> [a]
append [] ys = ys
append (x:xs) ys = x : (xs ++ ys)

-- evaluate a sorted list with an
-- element inserted into a sorted list
insert :: Ord a => a -> [a] -> [a]
insert x []                 = [x]
insert x (y:ys) | x <= y    = x : y : ys
		| otherwise = y : insert x ys

-- evaluate a sorted list using insertion sort
isort :: Ord a => [a] -> [a]
isort []     = []
isort (x:xs) = insert x (isort xs)

-- evaluate a "zipped" listed of tuples
zip' :: [a] -> [b] -> [(a,b)]
zip' []      _     = []
zip' _      []     = []
zip' (x:xs) (y:ys) = (x,y) : zip xs ys

-- evaluate a list with the first n elements dropped
drop' :: Int -> [a] -> [a]
drop' 0 xs     = xs
drop' _ []     = []
drop' n (_:xs) = drop (n-1) xs

-- evaluate the nth Fibonacci number
fib :: Int -> Int
fib 0 = 0
fib 1 = 1
fib n = fib (n-2) + fib (n-1)

-- evaluate a sorted list using quicksort
qsort :: Ord a => [a] -> [a]
qsort [] = []
qsort (x:xs) = qsort smaller ++ [x] ++ qsort larger
	       where
		  smaller = [a | a <- xs, a <= x]
		  larger  = [b | b <- xs, b > x]

-- evaluate if n is even
even' :: Int -> Bool
even' 0 = True
even' n = odd (n-1)

-- evaluate if n is odd
odd' :: Int -> Bool
odd' 0 = False
odd' n = even (n-1)

-- evaluate a list of even positioned numbers
evens :: [a] -> [a]
evens []     = []
evens (x:xs) = x : odds xs

-- evaluate a list of odd positioned numbers
odds :: [a] -> [a]
odds []     = []
odds (_:xs) = evens xs
