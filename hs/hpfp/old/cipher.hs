-- cipher.hs
module Cipher where

import Data.Char

-- main :: IO ()
-- main = do
--   word <- getLine
--   shift <- getLine
--   putStrLn $ caesar (read shift :: Int) word

main :: IO ()
main = do
  word <- getLine
  cipher <- getLine
  putStrLn $ vigenere cipher word

caesar :: Int -> String -> String
caesar n xs = map (shift n) xs

shift :: Int -> Char -> Char
shift n c
  | isUpper c = upperShift n c
  | isLower c = lowerShift n c
  | otherwise = c

upperShift :: Int -> Char -> Char
upperShift n c = chr . (\x -> (mod (x+n-65) 26) + 65) $ ord c

lowerShift :: Int -> Char -> Char
lowerShift n c = chr . (\x -> (mod (x+n-97) 26) + 97) $ ord c

unCaesar :: Int -> String -> String
unCaesar n xs = map (shift (-n)) xs

upperLetterShift :: Char -> Int
upperLetterShift c = (ord c) - 65

lowerLetterShift :: Char -> Int
lowerLetterShift c = (ord c) - 97

letterShift :: Char -> Int
letterShift c
  | isUpper c = upperLetterShift c
  | isLower c = lowerLetterShift c
  | otherwise = 0

--vigenere :: String -> String -> String
vigenere keyword msg = shiftedSentence --map (\(n,c) -> shift n c) $ zip secretShift msg
  where secretShift = cycle . map letterShift $ keyword
        msgWords = words msg
        wordsLengths = zip (map length msgWords) msgWords
        wordsWShifts shifts theWords =
          case theWords of [] -> []
                           (x:xs) -> (take (length x) shifts, x) :
                                     wordsWShifts (drop (length x) shifts) xs
        shiftedWords wWShifts =
          case wWShifts of [] -> []
                           ((s,w):ws) -> (map (\(n,c) -> shift n c) $ zip s w) :
                                         shiftedWords ws
        shiftedSentence = unwords . shiftedWords $ wordsWShifts secretShift msgWords

