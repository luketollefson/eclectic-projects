even' :: Integral a => a -> Bool
even' n = n `mod` 2 == 0

splitAt :: Int -> [a] -> ([a],[a])
splitAt n xs = (take n xs, drop n xs)

abs' :: Int -> Int
abs' n = if n >= 0 then n else -n

signum :: Int -> Int
signum n = if n < 0 then -1 else
	      if n == 0 then 0 else 1

abs'' n | n >= 0    = n
	| otherwise = -n

signum' n | n < 0     = -1
          | n == 0    = 0
	  | otherwise = 1

not :: Bool -> Bool
not False = True
not True  = False

fst' :: (a,b) -> a
fst' (x,_) = x

snd' :: (a,b) -> b
snd' (_,y) = y

test :: [Char] -> Bool
test ['a',_,_] = True
test _	       = False

test2 :: [Char] -> Bool
test2 ('a':_) = True
test2 _       = False

addL :: Int -> (Int -> Int)
addL = \x -> (\y -> x + y)

const' :: a -> b -> a
const' x _ = x

const'' :: a -> (b -> a)
const'' x = \_ -> x

odds :: Int -> [Int]
odds n = map f [0..n-1]
	 where f x = x*2 + 1

odds' :: Int -> [Int]
odds' n = map (\x -> x*2+1) [0..n-1]
