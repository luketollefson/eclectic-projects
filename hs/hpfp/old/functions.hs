-- functions.hs
module Functions where

{-
myNum :: Integer
myNum = 1

myVal f g h = myNum

{-
bindExp :: Integer -> String
bindExp x =
  let y = 5 in
    "the integer was: " ++ show x
    ++ " and y was: " ++ show y
-}

{-
bindExp :: Integer -> String
bindExp x =
  let z = y + x in
    let y = 5 in
      "the integer was: " ++ show x ++ and
-}

bindExp :: Integer -> String
bindExp x =
  let x = 10; y = 5 + z; z = 3 in
    "the integer was: " ++ show x
    ++ " and y was: " ++ show y
    ++ " and z was: " ++ show z

addOneIfOdd n = case odd n of
  True -> f n
  False -> n
  where f = \n -> n + 1

addFive = \x y -> (if x > y then y else x) + 5

mflip f x y = f y x
-}

isItTwo :: Integer -> Bool
isItTwo 2 = True
isItTwo _ = False

