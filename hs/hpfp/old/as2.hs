-- as2.hs
module As2 where

import Data.String
import Data.Char
import Data.List

f :: Show a => (a, b) -> IO (a, b)
f t@(a,_) = do
  print a
  return t

doubleUp :: [a] -> [a]
doubleUp [] = []
doubleUp xs@(x:_) = x : xs

isSubseqOf :: (Eq a) => [a] -> [a] -> Bool
isSubseqOf []    _  = True
isSubseqOf (x:_) [] = False
isSubseqOf xS@(x:xs) (y:ys)
  | x == y    = isSubseqOf xs ys
  | otherwise = isSubseqOf xS ys

capitalizeWords :: String -> [(String, String)]
capitalizeWords "" = []
capitalizeWords wS@(x:xs) = (head splitWords, toUpper x : tail (head splitWords)) : (capitalizeWords $ unwords (tail splitWords))
  where splitWords = words wS

capitalizeWord :: String -> String
capitalizeWord "" = ""
capitalizeWord (x:xs) = toUpper x : xs

capitalizeParagraph :: String -> String
capitalizeParagraph parg = (++".") . intercalate ". " $ map capitalizeWord sentences
  where sentences = map (dropWhile (==' ')) . lines $ map (\c -> if (c=='.') then '\n' else c) parg

