-- reverse.hs
module Reverse where

rvrs :: String -> String
rvrs xs = awesome ++ ws ++ is ++ ws ++ cur
  where awesome = take 7 $ drop 9 xs
        is      = take 2 $ drop 6 xs
        cur     = take 5 xs
        ws      = take 1 $ drop 5 xs

main :: IO ()
main = print $ rvrs "Curry is awesome"
