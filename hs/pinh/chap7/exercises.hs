-- map f on the list for elements that satisfy a predicate
condapply :: (a -> Bool) -> (a -> b) -> [a] -> [b]
--condapply p f = (map f) . (filter p)
condapply p f xs = map f (filter p xs)

-- evalute if all elements satisfy a predicate
all' :: (a -> Bool) -> [a] -> Bool
all' p = and . map p

-- evalute if an elements satisfy a predicate
any' :: (a -> Bool) -> [a] -> Bool
any' p = or . map p

-- evalute elements that satify a predicate upto
-- the first one that doesn't
takeWhile' :: (a -> Bool) -> [a] -> [a]
takeWhile' _ []               = []
takeWhile' p (x:xs) | p x       = x : takeWhile' p xs
	  	    | otherwise = []

-- evaluate elements after predicate fails
dropWhile' :: (a -> Bool) -> [a] -> [a]
dropWhile' _ [] 	        = []
dropWhile' p (x:xs) | p x       = dropWhile' p xs
		    | otherwise = x:xs

map' :: (a -> b) -> [a] -> [b]
map' f = foldr (\x xs -> f x : xs) []

filter' :: (a -> Bool) -> [a] -> [a]
filter' p = foldr (\x xs -> if p x then x:xs else xs) []

dec2int :: [Int] -> Int
dec2int = foldl (\v x -> 10*v + x) 0

-- evaluate a function on pairs into a curried function
curry' :: ((a,b) -> c) -> (a -> b -> c)
curry' f = \x y -> f (x,y)

test :: Num a => (a,a) -> a
test (x,y) = x * y

-- evaluate a curry function into a uncurried function
uncurry' :: (a -> b -> c) -> ((a,b) -> c)
uncurry' f = \(x,y) -> f x y

-- evaluate a list where p is a predicate for termination of
-- list generation, h is applied to the head of the list, and
-- t is applied to the tail
unfold :: (a -> Bool) -> (a -> b) -> (a -> a) -> a -> [b]
unfold p h t x | p x = []
	       | otherwise = h x : unfold p h t (t x)

int2bin :: Int -> [Int]
int2bin = unfold (== 0) (`mod` 2) (`div` 2)

chop8 :: [a] -> [[a]]
chop8 = unfold (null) (take 8) (drop 8)

map'' :: (a -> b) -> [a] -> [b]
map'' f = unfold (null) (f . head) (drop 1)

iterate' :: (a -> a) -> a -> [a]
iterate' f x = unfold (\_ -> False) id (f) x

-- apply alternating functions on a list
altMap :: (a -> b) -> (a -> b) -> [a] -> [b]
altMap _  _  []     = []
altMap f1 f2 (x:xs) = f1 x : altMap f2 f1 xs

luhnDouble :: Int -> Int
luhnDouble x = if x*2 > 9 then x*2-9 else x*2

luhn :: [Int] -> Bool
luhn xs = (sum . altMap id luhnDouble . reverse) xs `mod` 10 == 0
