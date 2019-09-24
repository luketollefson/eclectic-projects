{- Identify the redexes and whether each is innermost, outermost, neither, or both
1 + (2*3)
	2 * 3	Both

(1+2) * (2+3)
	1+2	innermost
	2+3	neither

fst (1+2, 2+3)
	fst (1+2, 2+3)	Outermost
	1+2		Innermost
	2+3		neither

(\x -> 1 + x) (2*3)
	(\x -> 1 + x) (2*3)	Outermost
	(2*3)	Innermost
-}

{- Why outermost evaluation is preferable to innermost on fst (1+2,2+3)
Innermost 4 steps
fst (1+2,2+3)
fst (3,2+3)
fst (3,5)
3

Outermost - 3 steps
fst (1+2,2+3)
1+2
3

2+3 isn't unessarily evaluated
-}

{- how mult 3 4 where mult = \x -> (\y -> x * y) can be broken into 4 seperate steps
mult 3 4
(\x -> (\y -> x * y)) 3 4
(\y -> 3 * y) 4
3 * 4
12
-}
	
fibs :: [Integer]
fibs = 0 : 1 : [n0+n1 | (n0,n1) <- zip (fibs) (tail fibs)]

data Tree a = Leaf | Node (Tree a) a (Tree a)
	      deriving Show

repeat' :: a -> Tree a
repeat' x = Node (repeat' x) x (repeat' x)

take' :: Int -> Tree a -> Tree a
take' 0 _              = Leaf
take' _ Leaf           = Leaf
take' n (Node xl x xr) = Node (take' (n-1) xl) x (take' (n-1) xr)

replicate' :: Int -> a -> Tree a
replicate' n = take' n . repeat'

sqroot :: Double -> Double
sqroot x = snd ( head ( dropWhile (\(x0,x1) -> abs(x1-x0) > 0.00001) (zip roots (tail roots))))
	   where next a = (a + x/a) / 2
		 roots = iterate (next) x
