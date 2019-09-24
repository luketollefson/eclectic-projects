-- folds.hs
module Folds where

myAny :: (a -> Bool) -> [a] -> Bool
myAny f xs = foldr (\x b -> f x || b) False xs

{-
foldl (flip (*)) 1 [1..3]
foldl (flip (*)) (flip (*) 1 1) [2..3]
foldl (flip (*)) (flip (*) (flip (*) 1 1) 2) [3..3]
foldl (flip (*)) (flip (*) (flip (*) (flip (*) 1 1) 2) 3) []
(flip (*)) (flip (*) (flip (*) (flip (*) 1 1) 2) 3)
((*) 3 (flip (*) (flip (*) (flip (*) 1 1) 2))
((*) 3 ((*) 2 (flip (*) 1 1)))
((*) 3 ((*) 2 ((*) 1 1)))
((*) 3 ((*) 2 1))
((*) 3 2)
6
-}
