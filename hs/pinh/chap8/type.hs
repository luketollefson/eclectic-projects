type Pos = (Int, Int)

type Trans = Pos -> Pos

type Pair a = (a,a)

type Assoc k v = [(k,v)]

find :: Eq k => k -> Assoc k v -> v
find k t = head [v | (k',v) <- t, k == k']

data Move = North | South | East | West 
	    deriving (Eq, Show, Read)

-- evaluates a position a move points to from a position
move :: Move -> Pos -> Pos
move North (x,y) = (x,y+1)
move South (x,y) = (x,y-1)
move East  (x,y) = (x+1,y)
move West  (x,y) = (x-1,y)

-- evaluates a position a list of moves points to from a position
moves :: [Move] -> Pos -> Pos
moves []     p = p
moves (m:ms) p = moves ms (move m p)

-- evaluates the opposite direction a move points to
rev :: Move -> Move
rev North = South
rev South = North
rev East  = West
rev West  = East

data Shape = Circle Float | Rect Float Float deriving Show 

-- evaluate a square shape
square :: Float -> Shape
square n = Rect n n

-- evaluate the area of a shape
area :: Shape -> Float
area (Circle r) = pi * r^2
area (Rect x y) = x * y

data Maybe' a = Nothing' | Just' a

safediv :: Int -> Int -> Maybe Int
safediv _ 0 = Nothing
safediv m n = Just (m `div` n)

safehead :: [a] -> Maybe a
safehead [] = Nothing
safehead xs = Just (head xs)

-- newtype provides increased type saftey for what otherwise would be synonyms
-- newtype Nat = N Int

data Nat = Zero | Succ Nat

nat2int :: Nat -> Int
nat2int Zero     = 0
nat2int (Succ n) = 1 + nat2int n

int2nat :: Int -> Nat
int2nat 0 = Zero
int2nat n = Succ (int2nat (n-1))

{- way of adding natural number 
add :: Nat -> Nat -> Nat
add mn = int2nat (nat2int m + nat2int n)
-}

-- better way
add :: Nat -> Nat -> Nat
add Zero     n = n
add (Succ m) n = Succ (add m n)

data List a = Nil | Cons a (List a)

len :: List a -> Int
len Nil         = 0
len (Cons _ xs) = 1 + len xs

data Tree a = Leaf a | Node (Tree a) a (Tree a)
t :: Tree Int
t = Node (Node (Leaf 1) 3 (Leaf 4)) 5
	 (Node (Leaf 6) 7 (Leaf 9))

occurs :: Eq a => a -> Tree a -> Bool
occurs x (Leaf y) = x == y
occurs x (Node l y r) = x == y || occurs x l || occurs x r

flatten :: Tree a -> [a]
flatten (Leaf x)     = [x]
flatten (Node l x r) = flatten l ++ [x] ++ flatten r

-- for search trees
occurs' :: Ord a => a -> Tree a -> Bool
occurs' x (Leaf y)                 = x == y
occurs' x (Node l y r) | x == y    = True
		      | x < y     = occurs' x l
		      | otherwise = occurs' x r

{- classes -}
{- the Eq class
class Eq a where
   (==), (/=) :: a -> a -> Bool

   x /= y = not (x == y)

-- to make Bool and instance of that class
instance Eq Bool where
   False == False = True
   True  == True  = True
   _     == _     = False
-}
{- the Ord class
class Eq a => Ord a where
   (<), (<=), (>), (>=) :: a -> a -> Bool
   min, max		:: a -> a -> a

   min x y | x <= y    = x
	   | otherwise = y

   max x y | x <= y    = y
	   | otherwise = x

instance Ord Bool where
    False < True = True
    _     < _    = False

    b <= c = (b < c) || (b == c)
    b > c  = c < b
    b >= c = c <= b
-}
