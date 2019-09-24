
import Data.List (elemIndex)
import Control.Applicative
import Data.Monoid
--import Data.Functor.Constant

-- f x =
--   lookup x [ (3, "hello")
--            , (4, "julie")
--            , (5, "kbai")]

-- g y =
--   lookup y [ (7, "sup?")
--            , (8, "chris")
--            , (9, "aloha")]

-- h z =
--   lookup z [(2, 3), (5, 6), (7, 8)]

-- m x =
--   lookup x [(4, 10), (8, 13), (1, 9001)]

-- {- Exercises -}

-- added :: Maybe Integer
-- added = (+3) <$> (lookup 3 $ zip [1, 2, 3] [4, 5, 6])

-- y :: Maybe Integer
-- y = lookup 3 $ zip [1,2,3] [4,5,6]

-- z :: Maybe Integer
-- z = lookup 2 $ zip [1,2,3] [4,5,6]

-- tupled :: Maybe (Integer, Integer)
-- tupled = pure (,) <*> y <*> z

-- x :: Maybe Int
-- x = elemIndex 3 [1,2,3,4,5]

-- y :: Maybe Int
-- y = elemIndex 4 [1,2,3,4,5]

-- max' :: Int -> Int -> Int
-- max' = max

-- maxed :: Maybe Int
-- maxed = max' <$> x <*> y

xs = [1,2,3]
ys = [4,5,6]

x :: Maybe Integer
x = lookup 3 $ zip xs ys

y :: Maybe Integer
y = lookup 2 $ zip xs ys

summed :: Maybe Integer
summed = fmap sum $ (,) <$> x <*> y

newtype Identity a = Identity a deriving (Eq, Ord, Show)

instance Functor Identity where
  fmap f (Identity a) = Identity (f a)

instance Applicative Identity where
  pure a = Identity a
  (<*>) (Identity f) (Identity a) = Identity (f a)

newtype Constant a b = Constant { getConstant :: a }
  deriving (Eq, Ord, Show)

instance Functor (Constant a) where
  fmap _ (Constant a) = Constant a

instance Monoid a => Applicative (Constant a) where
  pure _ = Constant mempty
  (<*>) (Constant a) (Constant a') = Constant (a <> a')
                                             
