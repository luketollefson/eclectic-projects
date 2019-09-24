import Data.Char

inc :: [Int] -> [Int]
inc []     = []
inc (n:ns) = n+1 : inc ns

sqr :: [Int] -> [Int]
sqr []     = []
sqr (n:ns) = n^2 : sqr ns

map' :: (a -> b) -> [a] -> [b]
map' f []     = []
map' f (x:xs) = f x : map f xs

inc' = map' (+1)

sqr' = map' (^2)

data Maybe' a = Nothing' | Just' a
                deriving (Eq, Ord, Show, Read)

instance Functor Maybe' where
   -- fmap :: (a -> b) -> Maybe' a -> Maybe' b
   fmap _ Nothing'  = Nothing'
   fmap g (Just' x) = Just' (g x)

data Tree a = Leaf a | Node (Tree a) (Tree a)
	      deriving Show

instance Functor Tree where
   -- fmap :: (a -> b) -> Tree a -> Tree b
   fmap g (Leaf x) = Leaf (g x)
   fmap g (Node l r) = Node (fmap g l) (fmap g r)

inc'' :: Functor f => f Int -> f Int
inc'' = fmap (+1)

data List a = Empty | Cons a (List a)
	      deriving Show

append :: List a -> List a -> List a
append Empty ys = ys
append (Cons x xs) ys = Cons x (xs `append` ys)

-- violates functor laws
instance Functor List where
   -- fmap :: (a -> b) -> List a -> List b
   fmap g Empty       = Empty
   fmap g (Cons x xs) = (fmap g xs) `append` (Cons (g x) Empty)

instance Applicative Maybe' where
   -- pure :: a -> Maybe' a
   pure = Just'

   -- (<*>) :: Maybe' (a -> b) -> Maybe' a -> Maybe' b
   Nothing'  <*> _   = Nothing'
   (Just' g) <*> mx = fmap g mx

prods :: [Int] -> [Int] -> [Int]
prods xs ys = [x*y | x <- xs, y <- ys]

prods' :: [Int] -> [Int] -> [Int]
prods' xs ys = pure (*) <*> xs <*> ys

getChars :: Int -> IO String
getChars 0 = return []
getChars n = pure (:) <*> getChar <*> getChars (n-1)

sequenceA' :: Applicative f => [f a] -> f [a]
sequenceA' []     = pure []
sequenceA' (x:xs) = pure (:) <*> x <*> sequenceA' xs

getChars' :: Int -> IO String
getChars' n = sequenceA' (replicate n getChar)

{- Monads -}
data Expr = Val Int | Div Expr Expr
	    deriving Show

eval :: Expr -> Int
eval (Val n)   = n
eval (Div x y) = eval x `div` eval y

safediv :: Int -> Int -> Maybe Int
safediv _ 0 = Nothing
safediv n m = Just (n `div` m)

eval' :: Expr -> Maybe Int
eval' (Val n) = Just n
eval' (Div x y) = case eval' x of
		     Nothing -> Nothing
		     Just n  -> case eval' y of
				   Nothing -> Nothing
				   Just m  -> safediv n m

eval'' :: Expr -> Maybe Int
eval'' (Val n) = Just n
eval'' (Div x y) = eval'' x >>= \n ->
		   eval'' y >>= \m ->
		   safediv n m

eval''' :: Expr -> Maybe Int
eval''' (Val n) = Just n
eval''' (Div x y) = do n <- eval''' x
		       m <- eval''' y
		       safediv n m

pairs :: [a] -> [b] -> [(a,b)]
pairs xs ys = do x <- xs
 		 y <- ys
		 return (x,y)

pairs' :: [a] -> [b] -> [(a,b)]
pairs' xs ys = [(x,y) | x <- xs, y <- ys]

{- The State monad -}
type State = Int
newtype ST a = S (State -> (a,State))

app :: ST a -> State -> (a,State)
app (S st) x = st x

instance Functor ST where
   -- fmap :: (a -> b) -> ST a -> ST b
   fmap g st = S (\s -> let (x,s') = app st s in (g x, s'))

instance Applicative ST where
   -- pure :: a -> ST a
   pure x = S (\s -> (x,s))

   -- (<*>) :: ST (a -> b) -> ST a -> ST b
   stf <*> stx = S (\s ->
      let (f,s')  = app stf s
	  (x,s'') = app stx s' in (f x, s''))

instance Monad ST where
   -- (>>=) :: ST a -> (a -> ST b) -> ST b
   st >>= f = S (\s -> let (x,s') = app st s in app (f x) s')

-- data Tree a = Leaf a | Node (Tree a) (Tree a)
--	         deriving Show

tree :: Tree Char
tree = Node (Node (Leaf 'a') (Leaf 'b')) (Leaf 'c')

rlabel :: Tree a -> Int -> (Tree Int, Int)
rlabel (Leaf _)   n = (Leaf n, n+1)
rlabel (Node l r) n = (Node l' r', n'')
		      where
			 (l',n')  = rlabel l n
			 (r',n'') = rlabel r n'

fresh :: ST Int
fresh = S (\n -> (n, n+1))

alabel :: Tree a -> ST (Tree Int)
alabel (Leaf _)   = Leaf <$> fresh
alabel (Node l r) = Node <$> alabel l <*> alabel r

mlabel :: Tree a -> ST (Tree Int)
mlabel (Leaf _)   = do n <- fresh
		       return (Leaf n)
mlabel (Node l r) = do l' <- mlabel l
		       r' <- mlabel r
		       return (Node l' r')

{- Generic functions -}
conv :: Char -> Maybe Int
conv c | isDigit c = Just (digitToInt c)
       | otherwise = Nothing

filterM :: Monad m => (a -> m Bool) -> [a] -> m [a]
filterM p []     = return []
filterM p (x:xs) = do b <- p x
		      ys <- filterM p xs
		      return (if b then x:ys else ys)

join :: Monad m => m (m a) -> m a
join mmx = do mx <- mmx
	      x  <- mx
	      return x
