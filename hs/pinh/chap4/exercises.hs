-- splits an even list into halves
halve :: [a] -> ([a],[a])
halve xs = (take half xs, drop half xs)
	   where half = length xs `div` 2

-- returns the third element in a list that
-- contains at least this many elements
third :: [a] -> a
third xs = head (tail (tail xs))

-- returns the third element in a list that
-- contains at least this many elements
third' :: [a] -> a
third' xs = xs !! 2

-- returns the third element in a list that
-- contains at least this many elements
third'' :: [a] -> a
third'' (_:_:x:_) = x

-- same as tail but produces an empty list if
-- asked for the tail of an empty list
safetail :: [a] -> [a]
safetail []     = []
safetail (_:xs) = xs


-- same as tail but produces an empty list if
-- asked for the tail of an empty list
safetail' :: [a] -> [a]
safetail' xs = if null xs then [] else tail xs

-- same as tail but produces an empty list if
-- asked for the tail of an empty list
safetail'' :: Eq a => [a] -> [a]
safetail'' xs | null xs   = xs
	      | otherwise = tail xs

or' :: Bool -> Bool -> Bool
True  `or'` True  = True
True  `or'` False = True
False `or'` True  = True
False `or'` False = False

or'' :: Bool -> Bool -> Bool
True  `or''` _     = True 
_     `or''` True  = True 
False `or''` False = True 

or''' :: Bool -> Bool -> Bool
True `or'''` _ = True
_    `or'''` b = b

or'''' :: Bool -> Bool -> Bool
False `or''''` False = False
_     `or''''` _     = True

or''''' :: Bool -> Bool -> Bool
b1 `or'''''` b2 | b1 == b2  = b1
		| otherwise = True

and' :: Bool -> Bool -> Bool
and' b1 b2 = if b1 then 
		if b2 then True
		else False
	     else False

and'' :: Bool -> Bool -> Bool
and'' b1 b2 = if b1 then b2 else False

mult' :: Int -> Int -> Int -> Int
mult' = \x -> \y -> \z -> x*y*z

luhnDouble :: Int -> Int
luhnDouble x = 2*x - if 2*x > 9 then 9 else 0

luhn :: Int -> Int -> Int -> Int -> Bool
luhn x y z w = if total `mod` 10 == 0 then True else False
	       where total = sum [luhnDouble x,y,luhnDouble z,w]
