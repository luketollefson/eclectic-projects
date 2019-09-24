-- as.hs
module AsPatterns where

import Data.Char

isSubseqOf :: (Eq a) => [a] -> [a] -> Bool
isSubseqOf [] _ = True
isSubseqOf (x:xs) sup = x `elem` sup && isSubseqOf xs (tail $ dropWhile (/=x) sup)

capitalizeWords :: String -> [(String, String)]
capitalizeWords ws = map (\w -> (w, toUpper ( head w) : tail w)) $ words ws

capitalizeWord :: String -> String
capitalizeWord "" = ""
capitalizeWord (x:xs) = toUpper x : xs

capitalizeParagraph :: String -> String
capitalizeParagraph "" = ""
capitalizeParagraph parg = capitalizeWord (takeWhile (/='.') parg) ++ "." ++
  capitalizeParagraph (tail $ dropWhile (/='.') parg)
