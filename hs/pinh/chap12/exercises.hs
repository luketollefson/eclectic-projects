data Tree a = Leaf | Node (Tree a) a (Tree a)
	      deriving Show

instance Functor Tree where
   -- fmap :: (a -> b) -> Tree a -> Tree b
   fmap g Leaf	       = Leaf
   fmap g (Node l x r) = Node (fmap g l) (g x) (fmap g r)

tree :: Tree Int
tree = Node (Node Leaf 5 Leaf) 2 Leaf

{-
instance Functor ((->) a) where
   -- fmap :: (b -> c) -> (a -> b) -> (a -> c)
   fmap = (.)
-}
{-
instance Applicative ((->) a) where
   -- pure :: b -> (a -> b)
   pure = const

   -- (<*>) :: (a -> b -> c) -> (a -> b) -> (a -> c)
   g <*> h = \x -> g x (h x)
-}

{-
instance Monad ((->) a) where
   -- (>>=) :: (a -> b) -> (b -> c -> d) -> (a -> d)
   g >>= h = \r -> h (g r) r
-}

newtype ZipList a = Z [a] deriving Show

instance Functor ZipList where
   -- fmap :: (a -> b) -> ZipList a -> ZipList b
   fmap g (Z xs) = Z (fmap g xs)

instance Applicative ZipList where
   -- pure :: a -> ZipList a
   pure x = Z (repeat x)

   -- <*> :: ZipList (a -> b) -> ZipList a -> ZipList b
   (Z gs) <*> (Z xs) = Z (zipWith ($) gs xs)

data Expr a = Var a | Val Int | Add (Expr a) (Expr a)
	      deriving Show

expr1 :: Expr Int
expr1 = Add (Var 1) (Add (Var 2) (Val 5))
-- expr1 = Add (Var 'b') (Add (Var 'c') (Val 5))

expr2 :: Expr Int
expr2 = Add (Var 3) (Add (Var 4) (Val 6))
-- expr2 = Add (Var 'd') (Add (Var 'e') (Val 6))

instance Functor Expr where
   -- fmap :: (a -> b) -> Expr a -> Expr b
   fmap g (Var x)   = Var (g x)
   fmap g (Val i)   = Val i
   fmap g (Add l r) = Add (fmap g l) (fmap g r)

instance Applicative Expr where
   -- pure :: a -> Expr a
   pure x = Var x

   -- (<*>) :: Expr (a -> b) -> Expr a -> Expr b
   _       <*> (Val i)   = Val i
   (Val i) <*> _ 	 = Val i
   (Var f) <*> (Var x)   = Var (f x)
   (Var f) <*> (Add x y) = Add ((Var f) <*> x) ((Var f) <*> y)
   (Add l r) <*> ey      = Add (l <*> ey) (r <*> ey)

instance Monad Expr where
   -- (>>=) :: Expr a -> (a -> Expr b) -> Expr b
   (Var x)     >>= f = f x
   (Val i)     >>= f = Val i
   (Add ex ey) >>= f = Add (ex >>= f) (ey >>= f)

type State = Int

newtype ST a = S (State -> (a,State))

app :: ST a -> State -> (a,State)
app (S st) x = st x

instance Functor ST where
   -- fmap :: (a -> b) -> ST a -> ST b
   fmap g st = do x <- st
		  return (g x)

instance Applicative ST where
   -- pure :: a -> ST a
   pure x = S (\s -> (x,s))

   -- (<*>) :: ST (a -> b) -> ST a -> ST b
   stf <*> stx = do f <- stf
		    x <- stx
		    return (f x)

instance Monad ST where
   -- (>>=) :: ST a -> (a -> ST b) -> ST b
   st >>= f = S (\s ->
      let (x,s') = app st s in app (f x) s')
