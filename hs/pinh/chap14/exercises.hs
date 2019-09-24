import Data.Monoid
import Data.Foldable
import Data.Traversable

{-
instance (Monoid a, Monoid b) => Monoid (a,b) where
   -- mempty :: (a,b)
   mempty = (mempty, mempty)

   -- mappend :: (a,b) -> (a,b) -> (a,b)
   (x1,y1) `mappend` (x2,y2) = (x1 `mappend` x2, y1 `mappend` y2)
-}

{-
instance Monoid b => (a -> b) where
   -- mempty :: (a -> b)
   mempty = \_ -> mempty

   -- mappend :: (a -> b) -> (a -> b) -> (a -> b)
   f `mappend` g = \x -> f x `mappend` g x
-}

{-
instance Foldable Maybe where
   -- fold :: Monoid a => Maybe a -> a
   fold (Just x) = x

   -- foldMap :: Monoid b => (a -> b) -> Maybe a -> b
   foldMap f (Just x) = f x

   -- foldr :: (a -> b -> b) -> b -> Maybe a -> b
   foldr _ x Nothing = x
   foldr f v (Just x) = f v x

   -- foldl :: (a -> b -> a) -> a -> Maybe b -> a
   foldl _ x Nothing = x
   foldl f v (Just x) = f v x

instance Traversable Maybe where
   traverse :: Applicative f => (a -> f b) -> Maybe a -> f (Maybe b)
   traverse _ Nothing = pure Nothing
   traverse f (Just x) = pure Just <*> g x
-}

data Tree a = Leaf | Node (Tree a) a (Tree a)
	      deriving Show

tree :: Tree (Sum Int)
tree = Node (Leaf) (Sum 4) (Node (Leaf) (Sum 2) (Leaf))

instance Foldable Tree where
   -- fold :: Monoid a => Tree a -> a
   fold (Leaf) = mempty
   fold (Node l x r) = fold l `mappend` x `mappend` fold r

   -- foldMap :: Monoid b => (a -> b) -> Tree a -> b
   foldMap _ (Leaf) = mempty
   foldMap f (Node l x r) = foldMap f l `mappend` f x `mappend` foldMap f r

   -- foldr :: (a -> b -> b) -> b -> Tree a -> b
   foldr _ v (Leaf) = v
   foldr f v (Node l x r) = foldr f (f x (foldr f v r)) l

   -- foldl :: (a -> b -> a) -> a -> Tree b -> a
   foldl _ v (Leaf) = v
   foldl f v (Node l x r) = foldl f (f (foldl f v l) x) r

instance Functor Tree where
   -- fmap :: (a -> b) -> Tree a -> Tree b
   fmap _ (Leaf) = Leaf
   fmap f (Node l x r) = Node (fmap f l) (f x) (fmap f r)

instance Applicative Tree where
   -- pure :: a -> Tree a
   pure x = Node (Leaf) x (Leaf)

   -- (<*>) :: Tree (a -> b) -> Tree a -> Tree b
   (Node (Leaf) g (Leaf)) <*> (Node l x r) = Node (fmap g l) (g x) (fmap g r)

instance Traversable Tree where
   -- traverse :: Applicative f => (a -> f b) -> Tree a -> f (Tree b)
   traverse _ (Leaf) = pure Leaf
   traverse g (Node l x r) = pure Node <*> traverse g l <*> (g x) <*> traverse g r
