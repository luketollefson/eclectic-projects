import Data.Foldable
import Data.Monoid

{-
class Monoid a where
   mempty  :: a
   mappend :: a -> a -> a

   mconcat :: [a] -> a
   mconcat = foldr mappend mempty
-}

{- 
instance Monoid [a] where
   -- mempty :: [a]
   mempty = []

   -- mappend :: [a] -> [a] -> [a]
   mappend = (++)
-}
{-
instance Monoid a => Monoid (Maybe a) where
   -- mempty :: Maybe a
   mempty = Nothing

   -- mappend :: Maybe a -> Maybe a -> Maybe a
   Nothing `mappend` my      = my
   mx	   `mappend` Nothing = mx
   Just x  `mappend` Just y  = Just (x `mappend` y)
-}
{- Not permitted 
instance Monoid Int where
   -- mempty :: Int
   mempty = 0

   -- mappend :: Int -> Int -> Int
   mappend = (+)

instance Monoid Int where
   -- mempty :: Int
   mempty = 1

   -- mappend :: Int -> Int -> Int
   mappend = (*)
-}

newtype Sum' a = Sum' a
   deriving (Eq, Ord, Show, Read)

getSum' :: Sum' a -> a
getSum' (Sum' x) = x

instance Num a => Monoid (Sum' a) where
   -- mempty :: Sum' a
   mempty = Sum' 0

   -- mappend :: Sum' a -> Sum' a -> Sum' a
   Sum' x `mappend` Sum' y = Sum' (x+y)

newtype Product' a = Product' a
   deriving (Eq, Ord, Show, Read)

getProduct' :: Product' a -> a
getProduct' (Product' x) = x

instance Num a => Monoid (Product' a) where
   -- mempty :: Product' a
   mempty = Product' 1

   -- mappend :: Product' a -> Product' a -> Product' a
   Product' x `mappend` Product' y = Product' (x*y)

{-
fold :: Monoid a => [a] -> a
fold []     = mempty
fold (x:xs) = x `mappend` fold xs
-}

{-
fold :: Monoid a => Tree a -> a
fold (Leaf x) = x
fold (Node l r) = fold l `mappend` fold r
-}

data Tree a = Leaf a | Node (Tree a) (Tree a)
	      deriving (Eq, Ord, Show)

instance Foldable Tree where
   -- fold :: Monoid a => Tree a -> a
   fold (Leaf x) = x
   fold (Node l r) = fold l `mappend` fold r

   -- foldMap :: Monoid b => (a -> b) -> Tree a -> b
   foldMap f (Leaf x) = f x
   foldMap f (Node l r) = foldMap f l `mappend` foldMap f r

   -- foldr :: (a -> b -> b) -> b -> Tree a -> b
   foldr f v (Leaf x)   = f x v
   foldr f v (Node l r) = foldr f (foldr f v r) l

   -- foldl :: (a -> b -> a) -> a -> Tree b -> a
   foldl f v (Leaf x)   = f v x
   foldl f v (Node l r) = foldl f (foldl f v l) r

tree :: Tree Int
tree = Node (Node (Leaf 1) (Leaf 2)) (Leaf 3)

average :: Foldable t => t Int -> Int
average ns = sum ns `div` length ns

dec :: Int -> Maybe Int
dec n = if n > 0 then Just (n-1) else Nothing

instance Functor Tree where
   -- fmap :: (a -> b) -> Tree a -> Tree b
   fmap g (Leaf x) = Leaf (g x)
   fmap g (Node l r) = Node (fmap g l) (fmap g r)

instance Traversable Tree where
   -- traverse :: Applicative f =>
   --	 (a -> f b) -> Tree a -> f (Tree b)
   traverse g (Leaf x)   = pure Leaf <*> g x
   traverse g (Node l r) =
      pure Node <*> traverse g l <*> traverse g r
