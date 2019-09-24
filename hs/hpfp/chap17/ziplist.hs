--import Control.Applicative
--import Data.Monoid

-- instance Semigroup a => Semigroup (ZipList a) where
--   (<>) = liftA2 (<>)

-- instance Monoid a => Monoid (ZipList a) where
--   mempty = ZipList $ repeat mempty

-- instance Applicative ZipList where
--   pure = ZipList . repeat
-- --  pure = ZipList
--   (<*>) (ZipList f) (ZipList a) = ZipList (f <*> a)

data List a = Nil | Cons a (List a) deriving (Eq, Show)

instance Functor List where
  fmap f (Cons x xs) = Cons (f x) (fmap f xs)
  fmap _ Nil = Nil

instance Applicative List where
  pure x = Cons x Nil
  (<*>) Nil _ = Nil
  (<*>) _ Nil = Nil
  (<*>) fs xs = flatMap (\f -> fmap f xs) fs


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

