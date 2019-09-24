{- Laws
-- right id
m >>= return  =  m
-- left id
return x >>= f  =  f x

-- associativity
(m >>= f) >>= g  =  m >>= (\x -> f x >>= g)
-}

data Nope a = NopeDotJpg deriving (Eq, Show)

instance Functor Nope where
  fmap _ NopeDotJpg = NopeDotJpg

instance Applicative Nope where
  pure = const NopeDotJpg
  NopeDotJpg <*> NopeDotJpg = NopeDotJpg

instance Monad Nope where
  (>>=) NopeDotJpg _ = NopeDotJpg

data PhhhbbtttEither b a = Left' a | Right' b deriving (Eq, Show)

instance Functor (PhhhbbtttEither b) where
  fmap _ (Right' b) = Right' b
  fmap f (Left' a) = Left' (f a)

instance Applicative (PhhhbbtttEither b) where
  pure = Left'
  (<*>) (Right' b) _ = Right' b
  (<*>) _ (Right' b) = Right' b
  (<*>) (Left' f) (Left' a) = Left' (f a)

newtype Identity a = Identity a deriving (Eq, Ord, Show)

instance Functor Identity where
  fmap f (Identity a) = Identity (f a)

instance Applicative Identity where
  pure = Identity
  (<*>) (Identity f) (Identity a) = Identity $ f a

instance Monad Identity where
  return = pure
  (>>=) (Identity a) f = f a

data List a = Nil | Cons a (List a) deriving (Eq, Show)

instance Functor List where
  fmap f (Cons x xs) = Cons (f x) (fmap f xs)
  fmap _ Nil = Nil

instance Applicative List where
  pure x = Cons x Nil
  (<*>) Nil _ = Nil
  (<*>) _ Nil = Nil
  (<*>) fs xs = flatMap (\f -> fmap f xs) fs

instance Monad List where
  return = pure
  (>>=) a f = concat' $ fmap f a

append' :: List a -> List a -> List a
append' Nil ys = ys
append' (Cons x xs) ys = Cons x $ xs `append'` ys

fold' :: (a -> b -> b) -> b -> List a -> b
fold' _ b Nil = b
fold' f b (Cons h t) = f h (fold' f b t)

concat' :: List (List a) -> List a
concat' = fold' append' Nil

flatMap :: (a -> List b) -> List a -> List b
flatMap f as = concat' $ fmap f as

{- FUNCTIONS -}
j :: Monad m => m (m a) -> m a
j x = x >>= id 

l1 :: Monad m => (a -> b) -> m a -> m b
l1 = fmap

l2 :: Monad m => (a -> b -> c) -> m a -> m b -> m c
l2 f a b = f <$> a <*> b

a :: Monad m => m a -> m (a -> b) -> m b
a = flip (<*>)

meh :: Monad m => [a] -> (a -> m b) -> m [b]
meh [] _ = return []
meh (x:xs) f = do
  b <- f x
  bs <- meh xs f
  return $ b : bs

flipType :: (Monad m) => [m a] -> m [a]
flipType = (flip meh) id
