-- 1
exone = sum [x^2 | x <- [1..100]]

-- 2
-- evaluate the lattice points of a coordinate grid
-- of size m by n
grid :: Int -> Int -> [(Int,Int)]
grid m n = [(x,y) | x <- [0..m], y <- [0..n]]

-- 3
-- evaluate the lattice points of a square n by n
-- excluding diagonal points (0,0) to (n,n)
square :: Int -> [(Int,Int)]
square n = [(x,y) | (x,y) <- grid n n, x /= y]

-- 4
-- evalute a list of n identical elements
replicate' :: Int -> a -> [a]
replicate' n x = [x | _ <- [1..n]]

-- 5
-- evaluate a list of Pythagorean triples with
-- n being the longest permittable leg
pyths :: Int -> [(Int,Int,Int)]
pyths n = [(a,b,c) | a <- [1..n],
		     b <- [1..n],
		     c <- [1..n],
		     a^2+b^2==c^2]

-- 6
-- evaluate a list of factors of n
factors :: Int -> [Int]
factors n = [x | x <- [1..n], n `mod` x == 0]

-- evaluate a list of perfect numbers testing
-- values up to n
perfects :: Int -> [Int]
perfects n = [x | x <- [1..n], sum (init (factors x)) == x]

-- 7
table = [(x,y) | x <- [1,2], y <- [3,4]]
-- evaluate table only using one generator
table' = concat [[(x,y) | x <- [z], y <- [3,4]] | z <- [1,2]]

-- 8
-- evaluate the values of a particular key
-- in a key-value tuple table
find :: Eq a => a -> [(a,b)] -> [b]
find k t = [v | (k',v) <- t, k == k']

-- evaluate the positions of a particual element
positions :: Eq a => a -> [a] -> [Int]
positions x xs = [n | n <- find x (zip xs [0..])]

-- 9
-- evaluate the scalar product of two lists
scalarproduct :: [Int] -> [Int] -> Int
scalarproduct xs ys = sum [x*y | (x,y) <- zip xs ys]
