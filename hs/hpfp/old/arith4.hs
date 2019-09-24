-- arith4.hs
module Arith4 where

-- id :: a -> a
-- id x = x

{- Regular
roundTrip :: (Show a, Read a) => a -> a
roundTrip a = read (show a)
-}

-- point free
roundTrip :: (Show a, Read a) => a -> a
roundTrip = read . show

roundTrip' :: (Show a, Read b) => a -> b
roundTrip' = read . show
--roundTrip' = roundTrip


main = do
  print (roundTrip 4 :: Int)
  print (id 4)

