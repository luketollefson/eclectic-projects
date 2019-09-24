{-
impOne :: a -> a -> a
impOne a b = a

impTwo :: a -> a -> a
impTwo a b = b

impTre :: a -> b -> b
impTre a b = b
-} 

bigNum = (^) 5 $ 10

{-
a = 12 + b
b = 10000 * c
c = 10
-}

--functionH :: [a] -> a
functionH (x:_) = x

--functionC :: Ord a => a -> a -> Bool
functionC x y =
  if (x > y) then True else False

--functionS :: (a, b) -> b
functionS (x, y) = y

myFunc :: (x -> y) -> (y -> z) -> c -> (a, x) -> (a, z)
myFunc xToY yToZ _ (a, x) = (a, (yToZ (xToY x)))

i :: a -> a
i a = a

c :: a -> b -> a
c a _ = a

c'' :: b -> a -> b
c'' b _ = b

c' :: a -> b -> b
c' _ b = b

r :: [a] -> [a]
r (_:xs) = xs

co :: (b -> c) -> (a -> b) -> a -> c
co f g a = f $ g a

a :: (a -> c) -> a -> a
a _ b = b

a' :: (a -> b) -> a -> b
a' f x = f x
