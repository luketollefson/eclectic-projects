-- stringExercises.hs
module StringExercises where

dropOne :: [a] -> [a]
dropOne x = drop 1 x

excited :: String -> String
excited x = x ++ "!"

forthIndex :: [a] -> a
forthIndex x = x !! 4

dropNine :: [a] -> [a]
dropNine x = drop 9 x

thirdLetter :: String -> Char
thirdLetter x = x !! 2

letterIndex :: Int -> Char
letterIndex x = "Curry is awesome!" !! x

{-
curryS :: String
curryS = "Curry is awesome"

rvrs :: String
rvrs = awesome ++ " " ++ is ++ " " ++ curryMine
  where awesome = take 7 $ drop 9 curryS
        is      = take 2 $ drop 6 curryS
        curryMine   = take 5 curryS
-}

rvrs :: String -> String
rvrs xs = awesome ++ ws ++ is ++ ws ++ cur
  where awesome = take 7 $ drop 9 xs
        is      = take 2 $ drop 6 xs
        cur     = take 5 xs
        ws      = take 1 $ drop 5 xs
