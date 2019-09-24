-- partial.hs
module Partial where

addStuff :: Integer -> Integer -> Integer
addStuff a b = a + b + 5

subtractSuff:: Integer -> Integer -> Integer
subtractSuff x y = x - y - 10
subtractOne = subtractSuff 1

nonsense :: Bool -> Integer
nonsense True = 805
nonsense False = 31337

curriedFunction :: Integer -> Bool -> Integer
curriedFunction i b = i + (nonsense b)

uncurriedFunction :: (Integer, Bool) -> Integer
uncurriedFunction (i, b) = i + (nonsense b)

anonymous :: Integer -> Bool -> Integer
anonymous = \i b -> i + (nonsense b)

anonNested :: Integer -> Bool -> Integer
anonNested = \i -> \b -> i + (nonsense b)

curry3 :: ((t1, t2, t3) -> t) -> t1 -> t2 -> t3 -> t
curry3 f a b c = f (a, b, c)

uncurry3 :: (t1 -> t2 -> t3 -> t) -> (t1, t2, t3) -> t
uncurry3 f (a, b, c) = f a b c
