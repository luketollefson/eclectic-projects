{-
data Nat = Zero | Succ Nat

add :: Nat -> Nat -> Nat
add Zero     m = m
add (Succ n) m = Succ (add n m)

111111111111111
-- SHOW THAT --
add n (Succ m) = Succ (add n m)

Base case:
	add Zero (Succ m)
=		{ applying add }
	Succ m
=		{ unapplying add }
	Succ (add Zero m)

Inductive case:
	add (Succ n) (Succ m)
=		{ applying add }
	Succ (add n (Succ m))
=		{ induction hypothesis }
	Succ (Succ (add n m))
=		{ unapplying add }
	Succ (add (Succ n) m)
						[]
-}

{-
-- SHOW THAT --
add n Zero = n

Base case:
	add Zero Zero
=		{ applying add }
	Zero

Inductive case:
	add (Succ n) Zero
=		{ applying add }
	Succ (add n Zero)
=		{ induction hypothesis }
	Succ n
						[]
-}

{-
222222222222222
-- SHOW THAT --
add n m = add m n

Base case:
	add Zero m
=		{ applying add }
	m
=		{ p: add n Zero = n }
	add m Zero

Inductive case:
	add (Succ n) m
=		{ applying add }
	Succ (add n m)
=		{ induction hypothesis }
	Succ (add m n)
=		{ p: add n (Succ m) = Succ (add n m) }
	add m (Succ n)
						[]
-}

{-
all p []     = True
all p (x:xs) = p x && all p xs

replicate :: Int -> a -> [a]
replicate 0 _ = []
replicate n x = x : replicate (n-1) x

333333333333333
-- SHOW THAT --
all (== x) (replicate n x) = True

Base case:
	all (== x) (replicate 0 x)
=		{ applying replicate }
	all (== x) []
=		{ applying all }
	True

Inductive case:
	all (== x) (replicate (n+1) x)
=		{ applying replicate }
	all (== x) (x : replicate n x)
=		{ applying all }
	(== x) x && all (== x) (replicate n x)
=		{ applying (== x) }
	True && all (== x) (replicate n x)
=		{ induction hypothesis }
	True && True
=		{ applying True }
	True
						[]
-}

{-
[]     ++ ys = ys
(x:xs) ++ ys = x : (xs ++ ys)

4444444444444-1
-- SHOW THAT --
xs ++ [] = xs

Base case:
	[] ++ []
=		{ applying ++ }
	[]

Inductive case:
	(x:xs) ++ []
=		{ applying ++ }
	x : (xs ++ [])
=		{ induction hypothesis }
	x:xs
						[]
-}

{-
4444444444444-2
-- SHOW THAT --
xs ++ (ys ++ zs) = (xs ++ ys) ++ zs

Base case:
	[] ++ (ys ++ zs)
=		{ applying ++ }
	ys ++ zs
=		{ unapplying ++ }
	([] ++ ys) ++ zs

Inductive case:
	(x:xs) ++ (ys ++ zs)
=		{ applying ++ }
	x : (xs ++ (ys ++ zs))
=		{ induction hypothesis }
	x : ((xs ++ ys) ++ zs)
=		{ unapplying ++ }
	(x:[]) ++ (xs ++ ys) ++ zs
=		{ applying ++ }
	x : (xs ++ ys) ++ zs
=		{ unapplying ++ }
	((x:xs) ++ ys) ++ zs
						[]
-}

{-
[]     ++ ys = ys
(x:xs) ++ ys = x : (xs ++ ys)

take 0 _      = []
take _ []     = []
take n (x:xs) = x : take (n-1) xs

drop 0 xs     = xs
drop _ []     = []
drop n (_:xs) = drop (n-1) xs

555555555555555
-- SHOW THAT --
take n xs ++ drop n xs = xs

Base case:
	take 0 xs ++ drop 0 xs
=		{ applying take }
	[] ++ drop 0 xs
=		{ applying drop }
	[] ++ xs
=		{ applying ++ }
	xs

Base case:
	take (n+1) [] ++ drop (n+1) []
=		{ applying take }
	[] ++ drop (n+1) []
=		{ applying drop }
	[] ++ []
=		{ applying ++ }
	[]

Inductive case:
	take (n+1) (x:xs) ++ drop (n+1) (x:xs)
=		{ applying take }
	(x : take n xs) ++ drop (n+1) (x:xs)
=		{ applying drop }
	(x : take n xs) ++ drop n xs
=		{ unapplying ++ on take n xs }
	(x : ([] ++ take n xs)) ++ drop n xs
=		{ unapplying ++ }
	((x:[]) ++ take n xs) ++ drop n xs
=		{ p: xs ++ (ys ++ zs) = (xs ++ ys) ++ zs }
	(x:[]) ++ (take n xs ++ drop n xs)
=		{ induction hypothesis }
	(x:[]) ++ xs
=		{ applying ++ }
	x : ([] ++ xs)
=		{ applying ++ }
	x:xs
						[]
-}

data Tree = Leaf Int | Node Tree Tree

nodes (Leaf _)   = 0
nodes (Node l r) = 1 + nodes l + nodes r

leaves (Leaf _)   = 1
leaves (Node l r) = leaves l + leaves r

{-
666666666666666
-- SHOW THAT --
leaves t = nodes t + 1

Base case:
	leaves (Leaf _)
=		{ applying leaves }
	1
=		{ unapplying + }
	0 + 1
=		{ unapplying 0 }
	nodes (Leaf _) + 1

Inductive case:
	leaves (Node l r)
=		{ applying leaves }
	leaves l + leaves r
=		{ induction hypothesis * 2 }
	nodes l + 1 + nodes r + 1
=		{ unapplying nodes }
	nodes (Node l r) + 1
						[]
-}

{-
data Maybe a = Nothing | Just a

fmap _ Nothing  = Nothing
fmap g (Just x) = Just (g x)

7777777777777-1
-- SHOW THAT --
fmap id x = x

Case 1:
	fmap id Nothing
=		{ applying fmap }
	Nothing

Case 2:
	fmap id (Just x)
=		{ applying fmap }
	Just (id x)
=		{ applying id }
	Just x
						[]

7777777777777-2
-- SHOW THAT --
fmap (g . f) x = fmap g (fmap f x)

Case 1:
	fmap (g . f) Nothing
=		{ applying fmap }
	Nothing

Case 2:
	fmap (g . f) (Just x)
=		{ applying fmap }
	Just ((g . f) x)
=		{ applying . }
	Just (g (f x))
=		{ unapplying fmap }
	fmap g (Just (f x))
=		{ unapplying fmap }
	fmap g (fmap f x)
						[]
-}

{-
data Tree a = Leaf a | Node (Tree a) (Tree a)

instance Functor Tree where
   -- fmap :: (a -> b) -> Tree a -> Tree b
   fmap g (Leaf x)   = Leaf (g x)
   fmap g (Node l r) = Node (fmap g l) (fmap g r)

8888888888888-1
-- SHOW THAT --
fmap id t = t

Base case:
	fmap id (Leaf x)
=		{ applying fmap }
	Leaf (id x)
=		{ applying id }
	Leaf x

Inductive case:
	fmap id (Node l r)
=		{ applying fmap }
	Node (fmap id l) (fmap id r)
=		{ induction hypothesis }
	Node l r
						[]

8888888888888-2
-- SHOW THAT --
fmap (g . f) t = fmap g (fmap f t)

Base case:
	fmap (g . f) (Leaf x)
=		{ applying fmap }
	Leaf ((g . f) x)
=		{ applying . }
	Leaf (g (f x))
=		{ unapplying fmap }
	fmap g (Leaf f x)
=		{ unapplying fmap }
	fmap g (fmap f (Leaf x))

Inductive case:
	fmap (g . f) (Node l r)
=		{ applying fmap }
	Node (fmap (g . f) l) (fmap (g . f) r)
=		{ induction hypothesis * 2}
	Node (fmap g (fmap f l)) (fmap g (fmap f r))
=		{ unapplying fmap }
	fmap g (Node (fmap f l) (fmap f r)
=		{ unapplying fmap }
	fmap g (fmap f (Node l r))
						[]
-}

{-
data Maybe a = Nothing | Just a

instance Functor Maybe where
   -- fmap :: (a -> b) -> Maybe a -> Maybe b
   fmap _ Nothing  = Nothing
   fmap g (Just x) = Just (g x)

instance Applicative Maybe where
   -- pure :: a -> Maybe a
   pure = Just

   -- (<*>) :: Maybe (a -> b) -> Maybe a -> Maybe b
   Nothing  <*> _  = Nothing
   (Just g) <*> mx = fmap g mx

9999999999999-1
-- SHOW THAT --
pure id <*> x = x

Case 1:
	pure id <*> Nothing
=		{ applying pure }
	(Just id) <*> Nothing
=		{ applying <*> }
	fmap id Nothing
=		{ applying fmap }
	Nothing

Case 2:
	pure id <*> (Just x)
=		{ applying pure }
	(Just id) <*> (Just x)
=		{ applying <*> }
	fmap id (Just x)
=		{ applying fmap }
	Just (id x)
=		{ applying id }
	Just x
						[]

9999999999999-2
-- SHOW THAT --
pure (g x) = pure g <*> pure x

	pure (g x)
=		{ applying pure }
	Just (g x)
=		{ unapplying fmap }
	fmap g (Just x)
=		{ unapplying <*> }
	(Just g) <*> Just x
=		{ unapplying pure * 2 }
	pure g <*> pure x
						[]

9999999999999-3
-- SHOW THAT --
x <*> pure y = pure (\g -> g y) <*> x

Case 1:
	Nothing <*> pure y
=		{ applying <*> }
	Nothing
=		{ unapplying fmap }
	fmap _ Nothing
=		{ unapplying <*> }
	(Just _) <*> Nothing

Case 2:
	x <*> pure y
=		{ assume x is the form Just f }
	Just f <*> pure y
=		{ applying pure }
	Just f <*> Just y
=		{ applying <*> }
	fmap f (Just y)
=		{ applying fmap }
	Just (f y)
=		{ unapplying (\g -> g y) }
	Just ((\g -> g y) f)
=		{ unapplying fmap }
	fmap (\g -> g y) (Just f)
=		{ unapplying <*> }
	Just (\g -> g y) <*> Just f
=		{ unapplying pure & replace Just f }
	pure (\g -> g y) <*> x
						[]

9999999999999-4
-- SHOW THAT --
x <*> (y <*> z) = (pure (.) <*> x <*> y) <*> z
-- if any is Nothing, the whole thing is Nothing
-- so only when it is just is foused on

	(Just (.) <*> Just f <*> Just g) <*> Just x
=		{ applying <*> }
	(fmap (.) (Just f <*> Just g) <*> Just x
=		{ applying <*> }
	(fmap (.) (fmap f (Just g))) <*> Just x
=		{ applying fmap }
	(fmap (.) (Just (f g))) <*> Just x
=		{ applying fmap }
	Just ((.) f g) <*> Just x
=		{ applying <*> }
	fmap (f . g) Just x
=		{ applying fmap }
	Just ((f . g) x)
=		{ applying . }
	Just (f (g x))
=		{ unapplying fmap }
	fmap f (Just (g x))
=		{ uanpplying fmap }
	fmap f (fmap g (Just x))
=		{ unapplying <*> }
	fmap f (Just g <*> Just x)
=		{ unapplying <*> }
	Just f <*> (Just g <*> Just x)
						[]
-}
data [a] = [] | a:[a]

instance Functor [] where
   -- fmap :: (a -> b) -> [a] -> [b]
   fmap = map

instance Applicative [] where
   -- pure :: a -> [a]
   pure x = [x]

   -- (<*>) :: [a -> b] -> [a] -> [b]
   gs <*> xs = [g x | g <- gs, x <- xs]

instance Monad [] where
   -- (>>=) :: [a] -> (a -> [b]) -> [b]
   xs >>= f = [y | x <- xs, y <- f x]

   -- return :: a -> [a]
   -- return = pure

101010101010101
-- SHOW THAT --
return x >>= f = f x

	[x1] >>= f
=		{ applying >>= }
	[y | x <- x1, y <- f x]
=		{ evaluating list comprehention }
	f x

101010101010102
-- SHOW THAT --
xs >>= return = xs

	xs >>= return
=		{ applying >>= }
	[y | x <- xs, y <- return x]
=		{ applying list comprehension }
	xs

101010101010103
-- SHOW THAT --
(xs >>= f) >>= g = xs >>= (\x -> (f x >>= g))

	(xs >>= f) >>= g
=		{ applying >>= }
	[y | x <- xs, y <- f x] >>= g
=		{ applying >>= }
	[y' | x' <- [y | x <- xs, y <- f x], y' <- g x']
=		{ using properties of list comprehensions }
	[y' | x <- xs, y <- f x, y' <- g y]
=		{
	[y' | x <- xs, y' <- [y'' | y <- f x, y'' <- g y]
=
	[y' | x <- xs, y' <- f x >>= g]
=
	[y' | x <- xs, y' <- (\x' -> f x' >>= g) x]
=
	xs >>= (\x -> (f x >>= g))
-}
