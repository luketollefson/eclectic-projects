module Main where

import Control.Monad
import Data.Monoid
import Test.QuickCheck

-- data Optional a = Nada | Only a deriving (Eq, Show)

-- instance Semigroup a => Semigroup (Optional a) where
--   (<>) (Only a) (Only b) = Only (a <> b)
--   (<>) a Nada = a
--   (<>) Nada b = b

-- instance Monoid a => Monoid (Optional a) where
--   mempty = Nada

-- newtype First' a = First' { getFirst' :: Optional a } deriving (Eq, Show)

-- instance Semigroup (First' a) where
--   (<>) (First' (Only a)) _ = First' (Only a)
--   (<>) (First' Nada) b = b

-- instance Monoid (First' a) where
--   mempty = First' Nada

-- firstMappend :: First' a -> First' a -> First' a
-- firstMappend = mappend

-- type FirstMappend = First' String -> First' String -> First' String -> Bool

-- type FstId = First' String -> Bool

-- onlyGen :: (Arbitrary a) => Gen (First' a)
-- onlyGen = do
--   a <- arbitrary
--   return $ First' (Only a)

-- instance Arbitrary (First' a) where
--   arbitrary = frequency [ (1, return $ First' Nada)] --, (3, return onlyGen)]

-- -- main :: IO ()
-- -- main = do
-- --   quickCheck (monoidAssoc :: FirstMappend)
-- --   quickCheck (monoidLeftIdentity :: FstId)
-- --   quickCheck (monoidRightIdentity :: FstId)

-- data Trivial = Trivial deriving (Eq, Show)

-- instance Semigroup Trivial where
--   _ <> _ = Trivial

-- instance Arbitrary Trivial where
--   arbitrary = return Trivial

-- type TrivAssoc = Trivial -> Trivial -> Trivial -> Bool

-- semigroupAssoc :: (Eq m, Semigroup m) => m -> m -> m -> Bool
-- semigroupAssoc a b c = (a <> (b <> c)) == ((a <> b) <> c)

-- newtype Identity a = Identity a deriving (Show, Eq)

-- instance Semigroup (Identity a) where
--   a <> _ = a

-- idGen :: (Arbitrary a) => Gen (Identity a)
-- idGen = do
--   a <- arbitrary
--   return (Identity a)

-- instance (Arbitrary a) => Arbitrary (Identity a) where
--   arbitrary = idGen

-- type IdenAssoc = Identity String -> Identity String -> Identity String -> Bool

-- data Two a b = Two a b deriving (Show, Eq)

-- instance Semigroup (Two a b) where
--   (Two a b) <> _ = Two a b

-- twoGen :: (Arbitrary a, Arbitrary b) => Gen (Two a b)
-- twoGen = do
--   a <- arbitrary
--   b <- arbitrary
--   return (Two a b)

-- instance (Arbitrary a, Arbitrary b) => Arbitrary (Two a b) where
--   arbitrary = twoGen

-- type TwoAssoc = Two String Char -> Two String Char -> Two String Char -> Bool

-- newtype BoolConj = BoolConj Bool deriving (Show, Eq)

-- instance Semigroup BoolConj where
--   (BoolConj True) <> _ = BoolConj True
--   _ <> b@_ = b

-- type BoolConjAssoc = BoolConj -> BoolConj -> BoolConj -> Bool

-- boolConjGen :: Gen BoolConj
-- boolConjGen = do
--   a <- arbitrary
--   return $ BoolConj a

-- instance Arbitrary BoolConj where
--   arbitrary = boolConjGen

-- data Or a b = Fst a | Snd b deriving (Show, Eq)

-- instance Semigroup (Or a b) where
--   a@(Snd _) <> _   = a
--   _         <> b@_ = b

-- orGen :: (Arbitrary a, Arbitrary b) => Gen (Or a b)
-- orGen = do
--   a <- arbitrary
--   b <- arbitrary
--   elements [Fst a, Snd b]

-- instance (Arbitrary a, Arbitrary b) => Arbitrary (Or a b) where
--   arbitrary = orGen

-- type OrAssoc = Or Char String -> Or Char String -> Or Char String -> Bool

-- newtype Combine a b = Combine { unCombine :: (a -> b) } 

-- instance Semigroup b => Semigroup (Combine a b) where
--   Combine g <> Combine f = Combine $ \x -> g x <> f x

-- combineGen :: Arbitrary b => Gen (Combine a b)
-- combineGen = do
--   b <- arbitrary
--   return $ Combine (\_ -> b)

-- instance Arbitrary b => Arbitrary (Combine a b) where
--   arbitrary = combineGen

-- type CombineAssoc = Combine Char String -> Combine Char String -> Combine Char String -> Bool

-- newtype Comp a = Comp { unComp :: (a -> a) }

-- instance Semigroup (Comp a) where
--   Comp g <> Comp f = Comp $ \x -> g . f $ x

-- data Validation a b = Failure' a | Success' b deriving (Eq, Show)

-- instance Semigroup a => Semigroup (Validation a b) where
--   (Failure' a) <> (Failure' a') = Failure' $ a <> a'
--   (Success' a) <> _             = Success' a
--   _            <> b@_           = b

-- main :: IO ()
-- main = do
--   let failure :: String -> Validation String Int
--       failure = Failure'
--       success :: Int -> Validation String Int
--       success = Success'
--   print $ success 1 <> failure "blah"
--   print $ failure "woot" <> failure "blah"
--   print $ success 1 <> success 2
--   print $ failure "woot" <> success 2

--main :: IO ()
--main =
--  quickCheck (semigroupAssoc :: OrAssoc)

{------------------------------MONOIDS------------------------------}

data Trivial = Trivial deriving (Eq, Show)

instance Semigroup Trivial where
  _ <> _ = Trivial

instance Monoid Trivial where
  mempty = Trivial
  mappend = (<>)

type TrivAssoc = Trivial -> Trivial -> Trivial -> Bool

trivialGen :: Gen Trivial
trivialGen = return Trivial

instance Arbitrary Trivial where
  arbitrary = trivialGen

-- main :: IO ()
-- main = do
--   let sa = semigroupAssoc
--       mli = monoidLeftIdentity
--       mri = monoidRightIdentity
--   quickCheck (sa :: TrivAssoc)
--   quickCheck (mli :: Trivial -> Bool)
--   quickCheck (mri :: Trivial -> Bool)

newtype Mem s a = Mem { runMem :: s -> (a, s) }

instance Semigroup a => Semigroup (Mem s a) where
  (Mem g) <> (Mem f) = Mem $ \x -> ((fst $ gf x) <> (fst $ f x), snd $ gf x)
    where gf = g . snd . f


instance Monoid a => Monoid (Mem s a) where
  mempty = Mem $ \s -> (mempty, s)

f' = Mem $ \s -> ("hi", s + 1)

main :: IO ()
main = do
  let rmzero = runMem mempty 0
      rmleft = runMem (f' <> mempty) 0
      rmright = runMem (mempty <> f') 0
  print $ rmleft
  print $ rmright
  print $ (rmzero :: (String, Int))
  print $ rmleft == runMem f' 0
  print $ rmright == runMem f' 0

semigroupAssoc :: (Eq m, Semigroup m) => m -> m -> m -> Bool
semigroupAssoc a b c =
  (a <> (b <> c)) == ((a <> b) <> c)

monoidLeftIdentity :: (Eq m, Monoid m) => m -> Bool
monoidLeftIdentity a = (mempty <> a) == a

monoidRightIdentity :: (Eq m, Monoid m) => m -> Bool
monoidRightIdentity a = (a <> mempty) == a

-- main :: IO ()
-- main = do
--   let ma = monoidAssoc
--       mli = monoidLeftIdentity
--       mlr = monoidRightIdentity
--   quickCheck (ma :: BullMappend)
--   quickCheck (mli :: Bull -> Bool)
--   quickCheck (mlr :: Bull -> Bool)
 
-- data Bull = Fools | Twoo deriving (Eq, Show)

-- instance Arbitrary Bull where
--   arbitrary = frequency [ (1, return Fools), (1, return Twoo) ]

-- instance Semigroup Bull where
--   _ <> _ = Fools

-- instance Monoid Bull where
--   mempty = Fools

-- type BullMappend = Bull -> Bull -> Bull -> Bool
