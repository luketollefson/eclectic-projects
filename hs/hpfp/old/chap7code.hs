-- chap7code.hs
module Chap7Code where

tensDigit :: Integral a => a -> a
tensDigit x = d
  where xLast = x `div` 10
        d     = xLast `mod` 10

--tensDigit' :: Integral a => a -> a
tensDigit' x = snd . flip divMod 10 . fst $ divMod x 10
--tensDigit' = snd . flip divMod 10 . fst . flip divMod 10

{-
hunsD :: Integral a => a -> a
hunsD x = d2
  where d2 = (x `div` 100) `mod` 10
-}

{-
foldBool :: a -> a -> Bool -> a
foldBool a1 a2 p
  | p = a1
  | otherwise = a2
-}

foldBool :: a -> a -> Bool -> a
foldBool a1 a2 p = case p of True -> a1
                             False -> a2

g :: (a -> b) -> (a, c) -> (b, c)
g f (a, c) = (f a, c)
