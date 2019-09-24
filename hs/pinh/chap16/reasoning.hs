double :: Int -> Int
double x = x + x

isZero :: Int -> Bool
isZero 0 = True
isZero n = False

-- These are non-overlapping, in a sense that the
-- patterns do not rely on the order in which they are matched
isZero' 0          = True
isZero' n | n /= 0 = False

reverse''' :: [a] -> [a]
reverse''' []     = []
reverse''' (x:xs) = reverse''' xs ++ [x]

data Nat = Zero | Succ Nat

add :: Nat ->  Nat -> Nat
add Zero     m = m
add (Succ n) m = Succ (add n m)

replicate' :: Int -> a -> [a]
replicate' 0 _ = []
replicate' n x = x : replicate (n-1) x

reverse'' :: [a] -> [a] -> [a]
reverse'' []     ys = ys
reverse'' (x:xs) ys = reverse'' xs (x : ys)

reverse' :: [a] -> [a]
reverse' xs = reverse'' xs []

{- alternate definition
reverse = foldl (\xs x -> x:xs) []
-}

data Tree = Leaf Int | Node Tree Tree

flatten :: Tree -> [Int]
flatten (Leaf n)   = [n]
flatten (Node l r) = flatten l ++ flatten r

flatten' :: Tree -> [Int] -> [Int]
flatten' (Leaf n) ns = n : ns
flatten' (Node l r) ns = flatten' l (flatten' r ns)

flatten'' :: Tree -> [Int]
flatten'' t = flatten' t []
