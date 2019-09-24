import Data.Monoid
import Test.QuickCheck

monoidAssoc :: Eq a => (a -> a -> a) -> a -> a -> a -> Bool
monoidAssoc a b c =
  a <> (b <> c) == (a <> b) <> c
