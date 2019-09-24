-- typeInference1.hs
module TypeInference1 where

-- f :: Num a => a -> a -> a
f x y = x + y + 3

{-
-- if Haskell infered the type, idwouldbe :: Num a => a -> a
triple :: Integer -> Integer
triple x = x * 3
-}

triple x = tripleItYo x
  where tripleItYo :: Integer -> Integer
        tripleItYo y = y * 3
