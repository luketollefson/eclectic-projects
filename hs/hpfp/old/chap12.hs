-- chap12.hs
module Chap12 where

import Data.List

ifEvenAdd2 :: Integer -> Maybe Integer
ifEvenAdd2 n = if even n then Just (n+2) else Nothing

type Name = String
type Age = Integer

data Person = Person Name Age deriving Show

mkPerson :: Name -> Age -> Maybe Person
mkPerson name age
  | name /= "" && age >= 0 =
      Just $ Person name age
  | otherwise = Nothing

--data PersonInvalid = NameEmpty | AgeTooLow deriving (Eq, Show)

data Example a = Blah | Woot a

data Identity a = Identity a

safeTail :: [a] -> Maybe [a]
safeTail []     = Nothing
safeTail (_:[]) = Nothing
safeTail (_:xs) = Just xs

data Trivial = Trivial deriving Show
data Unary a = Unary a deriving Show
data TwoArgs a b = TwoArgs a b
data ThreeArgs a b c = ThreeArgs a b c

data UnaryC = UnaryC Int deriving Show

-- replaceThe :: String -> String
-- replaceThe = unwords . fmap convert . words
--   where convert = \w -> case notThe w of Nothing -> "a"
--                                          Just u  -> u

-- replaceThe :: String -> String
-- replaceThe "" = ""
-- replaceThe (' ':'t':'h':'e':' ':xs) = ' ':'a':' ':replaceThe xs
-- replaceThe (x:xs) = x:replaceThe xs

replaceThe :: String -> String
replaceThe "" = "" 
replaceThe s = (deMaybe . notThe . head $ words s) ++ " " ++ (replaceThe . unwords . tail $ words s)
  where deMaybe s = case s of Nothing -> "a"
                              Just w  -> w


notThe :: String -> Maybe String
notThe "the" = Nothing
notThe s     = Just s


countTheBeforeVowel :: String -> Integer
countTheBeforeVowel "" = 0
countTheBeforeVowel ('t':'h':'e':' ':x:xs)
  | x `elem` "aeiou" = 1 + countTheBeforeVowel xs
  | otherwise = countTheBeforeVowel (x:xs)
countTheBeforeVowel (_:xs) = countTheBeforeVowel xs

countVowels :: String -> Integer
countVowels "" = 0
countVowels (x:xs)
  | x `elem` "aeiou" = 1 + countVowels xs
  | otherwise = countVowels xs

countVowels' :: String -> Integer
countVowels' = foldr (\x -> if x `elem` "aeiou" then (+1) else (+0)) 0

newtype Word' = Word' String deriving (Eq, Show)

vowels = "aeiou"

mkWord :: String -> Maybe Word'
mkWord s = if numVowels > numConsts then Nothing else (Just (Word' s))
  where numVowels = countVowels' s
        numConsts = fromIntegral (length s) - numVowels

data Nat = Zero | Succ Nat deriving (Eq, Show)

exNat = Succ (Succ (Succ (Succ Zero)))

natToInteger :: Nat -> Integer
natToInteger Zero = 0
natToInteger (Succ n) = 1 + natToInteger n

integerToNat :: Integer -> Maybe Nat
integerToNat 0 = Just Zero
integerToNat n
  | n > 0 = fmap Succ $ integerToNat (n-1)
  | otherwise = Nothing

isJust :: Maybe a -> Bool
isJust (Just _) = True
isJust _        = False

isNothing :: Maybe a -> Bool
isNothing Nothing = True
isNothing _       = False

mayybee :: b -> (a -> b) -> Maybe a -> b
mayybee x f Nothing = x
mayybee _ f (Just x) = f x

fromMaybe :: a -> Maybe a -> a
fromMaybe x Nothing = x
fromMaybe _ (Just x) = x

listToMaybe :: [a] -> Maybe a
listToMaybe [] = Nothing
listToMaybe (x:_) = Just x

maybeToList :: Maybe a -> [a]
maybeToList Nothing = []
maybeToList (Just x) = [x]

-- these are probably not performant as the dont use underscore

catMaybes :: [Maybe a] -> [a]
catMaybes [] = []
catMaybes (Nothing:xs) = catMaybes xs
catMaybes ((Just x):xs) = x : catMaybes xs

flipMaybe :: [Maybe a] -> Maybe [a]
flipMaybe [] = Just []
flipMaybe (Nothing:xs) = Nothing
flipMaybe ((Just x):xs) = fmap (x:) $ flipMaybe xs

lefts' :: [Either a b] -> [a]
lefts' = foldr (\x xs -> case x of Right y -> xs
                                   Left  y -> (y:xs)) []

rights' :: [Either a b] -> [b]
rights' = foldr (\x xs -> case x of Right y -> y:xs
                                    Left  y -> xs) []

partitionEithers' :: [Either a b] -> ([a], [b])
partitionEithers' xs = (lefts' xs, rights' xs)

eitherMaybe' :: (b -> c) -> Either a b -> Maybe c
eitherMaybe' _ (Left _) = Nothing
eitherMaybe' f (Right b) = Just $ f b

either' :: (a -> c) -> (b -> c) -> Either a b -> c
either' f _ (Left a)  = f a
either' _ g (Right b) = g b

eitherMaybe'' :: (b -> c) -> Either a b -> Maybe c
eitherMaybe'' f (Right b) = Just $ f b
eitherMaybe'' _ (Left _)  = Nothing

-- some stuff
mehSum :: Num a => [a] -> a
mehSum xs = go 0 xs
  where go :: Num a => a -> [a] -> a
        go n [] = n
        go n (x:xs) = (go (n+x) xs)

niceSum :: Num a => [a] -> a
niceSum = foldl' (+) 0

mehProduct :: Num a => [a] -> a
mehProduct xs = go 1 xs
  where go :: Num a => a -> [a] -> a
        go n [] = n
        go n (x:xs) = (go (n*x) xs)

niceProduct :: Num a => [a] -> a
niceProduct = foldl' (*) 1

mehConcat :: [[a]] -> [a]
mehConcat xs = go [] xs
  where go :: [a] -> [[a]] -> [a]
        go xs' [] = xs'
        go xs' (x:xs) = (go (xs' ++ x) xs)

niceConcat :: [[a]] -> [a]
niceConcat = foldr (++) []

-- some stuff
myIterate :: (a -> a) -> a -> [a]
myIterate f e = e : myIterate f (f e)

myUnfoldr :: (b -> Maybe (a, b)) -> b -> [a]
myUnfoldr f e = e : myUnfoldr f (\(a, b) ->
