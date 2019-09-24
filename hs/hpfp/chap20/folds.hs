import Data.Foldable
import Data.Monoid

data Identity a = Identity a deriving (Eq, Show)

instance Foldable Identity where
  foldr f z (Identity x) = f x z
  foldl f z (Identity x) = f z x
  foldMap f (Identity x) = f x

data Optional a = Nada | Yep a deriving (Eq, Show)

instance Foldable Optional where
  foldr _ z Nada = z
  foldr f z (Yep x) = f x z

  foldl _ z Nada = z
  foldl f z (Yep x) = f z x

  foldMap _ Nada = mempty
  foldMap f (Yep a) = f a

{- Exercises -}
sum' :: (Foldable t, Num a) => t a -> a
sum' xs = getSum $ foldMap Sum xs

product' :: (Foldable t, Num a) => t a -> a
product' xs = getProduct $ foldMap Product xs

elem' :: (Foldable t, Eq a) => a -> t a -> Bool
elem' x xs = foldr ((||) . (==) x) False xs

minimum' :: (Foldable t, Ord a) => t a -> Maybe a
minimum' xs = foldr maybeMin Nothing xs
  where maybeMin :: Ord a => a -> Maybe a -> Maybe a
        maybeMin x (Just y) = Just $ min x y
        maybeMin x _        = Just x

maximum' :: (Foldable t, Ord a) => t a -> Maybe a
maximum' xs = foldr maybeMax Nothing xs
  where maybeMax :: Ord a => a -> Maybe a -> Maybe a
        maybeMax x (Just y) = Just $ max x y
        maybeMax x _        = Just x

null' :: (Foldable t) => t a -> Bool
null' xs = foldr (\a b -> True) False xs

length' :: (Foldable t) => t a -> Int
length' xs = foldr (\a n -> succ n) 0 xs

toList' :: (Foldable t) => t a -> [a]
toList' xs = foldr (:) [] xs

fold' :: (Foldable t, Monoid m) => t m -> m
fold' = foldMap id

foldMap' :: (Foldable t, Monoid m) => (a -> m) -> t a -> m
foldMap' f xs = foldr ((<>) . f) mempty xs

data Constant a b = Constant b deriving (Eq, Show)

instance Foldable (Constant a) where
  foldr f acc (Constant b) = f b acc

data Two a b = Two a b deriving (Eq, Show)

instance Foldable (Two a) where
  foldr f acc (Two a b) = f b acc

data Three a b c = Three a b c deriving (Eq, Show)

instance Foldable (Three a b) where
  foldr f acc (Three a b c) = f c acc

data Three' a b = Three' a b b deriving (Eq, Show) 

instance Foldable (Three' a) where
  foldr f acc (Three' a b b') = f b' $ f b acc

data Four' a b = Four' a b b b deriving (Eq, Show)

instance Foldable (Four' a) where
  foldr f acc (Four' a b b' b'') = f b'' $ f b' $ f b acc

filterF :: (Applicative f, Foldable t, Monoid (f a)) => (a -> Bool) -> t a -> f a
filterF p ts = foldMap (\a -> if p a then pure a else mempty) ts
