-- concatenates lists of lists
concat' :: [[a]] -> [a]
concat' xss = [x | xs <- xss, x <- xs]

-- select the first component of doubles
firsts :: [(a,b)] -> [a]
firsts ps = [x | (x,_) <- ps]

-- evaluate the length
length' :: [a] -> Int
length' xs = sum [1 | _ <- xs]

-- evaluate the factors of a number
factors :: Int -> [Int]
factors n = [x | x <- [1..n], n `mod` x == 0]

-- evaluate if a number is prime or not
prime :: Int -> Bool
prime n = factors n == [1,n]

-- evaluate a list of primes up to n
primes :: Int -> [Int]
primes n = [x | x <- [2..n], prime x]

-- evaluate the values of a particular key
-- in a key-value tuple table
find :: Eq a => a -> [(a,b)] -> [b]
find k t = [v | (k',v) <- t, k == k']

-- evaluate a list of all pairs of adjacent elements
-- of a list
pairs :: [a] -> [(a,a)]
pairs xs = zip xs (tail xs)

-- evaluate if a list of Ord is sorted
sorted :: Ord a => [a] -> Bool
sorted xs = and [x <= y | (x,y) <- pairs xs]

-- evaluate the position(s) of an element in a list
positions :: Eq a => a -> [a] -> [Int]
positions x xs = [i | (x',i) <- zip xs [0..], x == x']

-- evaluate the number of lowercase letters in a string
lowers :: String -> Int
lowers xs = length [x | x <- xs, x >= 'a' && x <= 'z']

-- evaluate the number of a particular character in a string
count :: Char -> String -> Int
count x xs = length [x' | x' <- xs, x == x']
