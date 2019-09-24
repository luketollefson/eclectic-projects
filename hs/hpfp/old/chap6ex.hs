import Data.List
{-
1 c
2 b
3 a
4 c
5 a
-}

data Person = Person Bool deriving Show

printPerson :: Person -> IO ()
printPerson person = putStrLn (show person)

data Mood = Blah | Woot deriving (Eq, Show)

settleDown x = if x == Woot
               then Blah
               else x

type Subject = String
type Verb = String
type Object = String

data Sentence = Sentence Subject Verb Object
  deriving (Eq, Show)

s1 = Sentence "dogs" "drools"
s2 = Sentence "Julie" "loves" "dogs"

data Rocks = Rocks String deriving (Eq, Show)

data Yeah = Yeah Bool deriving (Eq, Show)

data Papu = Papu Rocks Yeah deriving (Eq, Show)

phew = Papu (Rocks "chases") (Yeah True)

truth = Papu (Rocks "chomskydoz") (Yeah True)

equalityForall :: Papu -> Papu -> Bool
equalityForall p p' = p == p'

{-
comparePapus :: Papu -> Papu -> Bool
copmarePapus p p' = p > p'
-}

--f :: Fractional a => a
--f :: RealFrac a => a
--f = 1.0

freud :: Ord a => a -> a
freud x = x

freud' :: Int -> Int
freud' x = x

{-
myX = 1 :: Int

sigmund :: Num a => a -> a
sigmund x = myX
-}

{-
jung :: [Int] -> Int
jung xs = head (sort xs)
-}

{-
young :: Ord a => [a] -> a
young xs = head (sort xs)

mySort :: [Char] -> [Char]
mySort = sort

--signifier :: Ord a => [a] -> a
signifier xs = head (mySort xs)
-}

chk :: Eq b => (a -> b) -> a -> b -> Bool
chk f a b = f a == b

arith :: Num b => (a -> b) -> Integer -> a -> b
arith f x a = f a * (fromInteger x)
