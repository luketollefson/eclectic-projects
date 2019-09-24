{-# LANGUAGE GeneralizedNewtypeDeriving, FlexibleInstances #-}

-- types.hs
module Types where

import Data.Int
{-
data PugType = PugData

data HuskyType a = HuskyData

data DogueDeBordeaux doge = DogueDeBordeaux doge

myPug = PugData :: PugType

myHusky :: HuskyType a
myHusky = HuskyData

myOtherHusky :: Num a => HuskyType a
myOtherHusky = HuskyData

myOtherOtherHusky :: HuskyType [[[[Int]]]]
myOtherOtherHusky = HuskyData

myDoge :: DogueDeBordeaux Int
myDoge = DogueDeBordeaux 10

data Doggies a = Husky a | Mastiff a deriving (Eq, Show)

data Price = Price Integer deriving (Eq, Show)

data Size = Size Integer deriving (Eq, Show)

data Manufacturer = Mini | Mazda | Tata deriving (Eq, Show)

data Airline = PapuAir | CatapultsR'Us | TakeYourChancesUnited deriving (Eq, Show)

data Vehicle = Car Manufacturer Price | Plane Airline Size deriving (Eq, Show)

myCar = Car Mini (Price 14000)
urCar = Car Mazda (Price 20000)
clownCar = Car Tata (Price 7000)
doge = Plane PapuAir (Size 100)

isCar :: Vehicle -> Bool
isCar (Car _ _) = True
isCar _ = False

isPlane :: Vehicle -> Bool
isPlane (Plane _ _) = True
isPlane _ = False

getManu :: Vehicle -> Manufacturer
getManu (Car m _) = m

data MyType = MyVal Int
  deriving (Eq, Show)

data Example = MakeExample deriving Show

data Example' = MakeExample' Int deriving Show

class TooMany a where
  tooMany :: a -> Bool

instance TooMany Int where
  tooMany n = n > 42

-- instance TooMany Goats where
--   tooMany (Goats n) = n > 43

newtype Goats = Goats Int deriving (Eq, Show, TooMany)

newtype Cows = Cows Int deriving (Eq, Show, TooMany)

instance TooMany (Int, String) where
  tooMany (n, _) = n > 42

instance (Num a, TooMany a) => TooMany (a, a) where
  tooMany (n, m) = tooMany n || tooMany m

--data Bool = False | True

data BigSmall = Big Bool | Small Bool deriving (Eq, Show)
-- the cardinality would be 4

data NumberOrBool = Numba Int8 | BoolyBool deriving (Eq, Show)

data QuantumBool = QuantumTrue | QuantumFalse | QuantumBoth deriving (Eq, Show)

data TwoQs = MkTwoQs QuantumBool QuantumBool deriving (Eq, Show)

--data Person = MkPerson String Int deriving (Eq, Show)

data Person = Person { name :: String, age :: Int } deriving (Eq, Show)

-- data Fiction' = Fiction deriving Show
-- data Nonfiction' = Nonfiction deriving Show

-- data BookType = FictionBook Fiction' | NonfictionBook Nonfiction' deriving Show

type AuthorName = String

data Author = Author (AuthorName, BookType)

data Author = Fiction AuthorName | Nonfiction AuthorName deriving (Eq, Show)

--data FlowerType = Gardenia | Daisy | Rose | Lilac deriving Show

type Gardener = String

--data Garden = Garden Gardener FlowerType deriving Show

--data Garden = Gardenia Gardener | ..

data GuessWhat = Chickenbutt deriving (Eq, Show)

data Id a = MkId a deriving (Eq, Show)

data Product a b = Product a b deriving (Eq, Show)

data Sum a b = First a | Second b deriving (Eq, Show)

data RecordProduct a b = RecordProduct { pfirst  :: a
                                       , psecond :: b }
                         deriving (Eq, Show)

newtype NumCow = NumCow Int deriving (Eq, Show)

newtype NumPig = NumPig Int deriving (Eq, Show)

data Farmhouse = Farmhouse NumCow NumPig deriving (Eq, Show)

type Farmhouse' = Product NumCow NumPig

{- -}

trivialValue :: GuessWhat
trivialValue = Chickenbutt

--data Id a = MkId a deriving (Eq, Show)

idInt :: Id Integer
idInt = MkId 10

type Awesome = Bool
type Name = String

person :: Product Name Awesome
person = Product "Simon" True
-}
--data Twitter = Twitter deriving (Eq, Show)

--data AskFm = AskFm deriving (Eq, Show)

--socialNetwork :: Sum Twitter AskFm
--socialNetwork = First Twitter

--data SocialNetwork = Twitter | AskFm deriving (Eq, Show)

--type Twitter = String
--type AskFm = String

--twitter :: Sum Twitter AskFm
--twitter = Fist

data OS = Linux | BSD | Mac | Windows deriving (Eq, Show)

data Lang = Haskell | Agda | Idris deriving (Eq, Show)

data Programmer = Programmer { os :: OS
                             , lang :: Lang } deriving (Eq, Show)

allOSs :: [OS]
allOSs = [Linux, BSD, Mac, Windows]

allLangs :: [Lang]
allLangs = [Haskell, Agda, Idris]

allProgrammers :: [Programmer]
--allProgrammers = concat $ map (\os -> map (\lang -> Programmer os lang) allLangs) allOSs
allProgrammers = [Programmer os lang | os <- allOSs, lang <- allLangs]

newtype Name  = Name String deriving Show
newtype Acres = Acres Int deriving Show

--data FarmerType = Dairl
