data Nat = Zero | Succ Nat deriving Show

-- evaluate the addition of two natural numbers
add :: Nat -> Nat -> Nat
add Zero     n = n
add (Succ m) n = Succ (add m n)

-- evaluate the multiplication of two natural numbers
mult :: Nat -> Nat -> Nat
mult Zero        n = Zero
mult (Succ Zero) n = n
mult (Succ m)    n = add (add Zero n) (mult m n)

-- evaluate the natural number from an integer
int2nat :: Int -> Nat
int2nat 0 = Zero
int2nat n = Succ (int2nat(n-1))

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
occurs' x (Leaf y)     = x == y
occurs' x (Node l y r) = case compare x y of
			    LT -> occurs' x l
			    EQ -> True
			    GT -> occurs' x r

data Tree2 a = Leaf2 a | Node2 (Tree2 a) (Tree2 a) deriving Show

-- evaluate the number of leaves on a node
noleaves :: Tree2 a -> Int
noleaves (Leaf2 _) = 1
noleaves (Node2 l r) = noleaves l + noleaves r

-- evaluate wether or not a tree is balanced
balanced :: Tree2 a -> Bool
balanced (Leaf2 _) = True
balanced (Node2 l r) = abs(noleaves l - noleaves r) <= 1 && balanced l && balanced r

t2 :: Tree2 Int
t2 = Node2 (Node2 (Leaf2 1) (Leaf2 2)) (Node2 (Leaf2 3) (Leaf2 4))
t3 = Node2 (Node2 (Node2 (Node2 (Leaf2 1) (Leaf2 2)) (Leaf2 3)) (Leaf2 4)) (Leaf2 5)

-- evaluate a list into half
halve :: [a] -> ([a],[a])
halve [] = ([],[])
halve xs = (take len xs, drop len xs)
	   where len = length xs `div` 2

-- evaluate a balanced tree off of list
balance :: [a] -> Tree2 a
balance [x] = Leaf2 x
balance xs   = ((\(h1s,h2s) -> Node2 (balance h1s) (balance h2s)) . halve) xs
