-- evaluate a function twice on it's arguments
twice :: (a -> a) -> a -> a
twice f x = f (f x)

-- evaluate f onto each element in the list
map' :: (a -> b) -> [a] -> [b]
map' f xs = [f x | x <- xs]

-- evaluate f onto each element in the list
map'' :: (a -> b) -> [a] -> [b]
map'' f []   = []
map'' f (x:xs) = f x : map f xs

-- evaluate which elements satify a predicate (property)
filter' :: (a -> Bool) -> [a] -> [a]
filter' p xs = [x | x <- xs, p x]

-- evaluate which elements satify a predicate (property)
filter'' :: (a -> Bool) -> [a] -> [a]
filter'' p []		      = []
filter'' p (x:xs) | p x	      = x : filter p xs
		  | otherwise = filter p xs

-- evalute the sum of squares of even integers of a list
sumsqreven :: [Int] -> Int
sumsqreven ns = sum (map (^2) (filter even ns))

{- Using foldr
sum :: Num a => [a] -> a
sum = foldr (+) 0

product :: Num a => [a] -> a
product = foldr (*) 1

or :: [Bool] -> Bool
or = foldr (||) False

and :: [Bool] -> Bool
and = foldr (&&) True
-}

-- evaluate a function on the head and recursivly processed tail
-- more practiaclly think of every cons operater being replaced
-- by the function and v being the empty list
foldr' :: (a -> b -> b) -> b -> [a] -> b
foldr' f v []     = v
foldr' f v (x:xs) = f x (foldr f v xs)

-- evaluate the length of a list
length' :: [a] -> Int
length' = foldr (\_ n -> 1+n) 0

-- evaluate the reverse of a list
reverse' :: [a] -> [a]
reverse' [] = []
reverse' (x:xs) = reverse xs ++ [x]

-- evaluate an appending on the end of a list
-- (backwards of cons)
snoc :: a -> [a] -> [a]
snoc x xs = xs ++ [x]

-- evaluate the reverse of a list
reverse'' :: [a] -> [a]
reverse'' = foldr snoc []

-- evaluate the sum of list
sum' :: Num a => [a] -> a
sum' = sum'' 0
       where
	  sum'' v [] = v
	  sum'' v (x:xs) = sum'' (v+x) xs

{- Using foldl
sum :: Num a => [a] -> a
sum = foldl (+) 0

product :: Num a => [a] -> a
product = foldl (*) 0

or :: [Bool] -> Bool
or = foldl (||) False

and :: [Bool] -> Bool
and = foldl (&&) True

reverse'' :: [a] -> [a]
reverse'' = foldl (\xs x -> x:xs) []
-}

dot :: (b -> c) -> (a -> b) -> a -> c
f `dot` g = \x -> f (g x)

odd' = not . even
twice' f = f . f
sumsqreven' = sum . map (^2) . filter even

compose :: [a -> a] -> (a -> a)
compose = foldr (.) id
