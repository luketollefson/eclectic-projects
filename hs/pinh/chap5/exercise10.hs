import Data.Char

-- evaluate the position of a letter in the alphabet
-- uppercase letters start at 26
let2int :: Char -> Int
let2int c | isUpper c = ord c - ord 'A' + 26
	  | otherwise = ord c - ord 'a'

-- evaluate the nth letter of the alphabet
int2let :: Int -> Char
int2let n | n >= 26   = chr (ord 'A' - 26 + n)
	  | otherwise = chr (ord 'a' + n)

-- evaluate the Caesar shifted character of a character
shift :: Int -> Char -> Char
shift n c | isUpper c = int2let ((let2int c + n) `mod` 26 + 26)
	  | isLower c = int2let ((let2int c + n) `mod` 26)
	  | otherwise = c

-- evaluate a Caesar cipher of a string
-- decoding can be done by using a negative shift factor
encode :: Int -> String -> String
encode n xs = [shift n x | x <- xs]

{-
    Cracking the Caesar cipher using frequency analysis
-}

-- table of English letter frequencies
table :: [Float]
table = [8.1, 1.5, 2.8, 4.2, 12.7, 2.2, 2.0, 6.1, 7.0,
	 0.2, 0.8, 4.0, 2.4,  6.7, 7.5, 1.9, 0.1, 6.0,
	 6.3, 9.0, 2.8, 1.0,  2.4, 0.2, 2.0, 0.1]

-- evaluates the percentage of one integer with respect
-- to another
percent :: Int -> Int -> Float
percent n m = (fromIntegral n / fromIntegral m) * 100

-- evaluate the number of lowercase letters in a string
lowers :: String -> Int
lowers xs = length [x | x <- xs, x >= 'a' && x <= 'z']

-- evaluate the number of a particular character in a string
count :: Char -> String -> Int
count x xs = length [x' | x' <- xs, x == x']

-- evaluates the frequencies of letters in a string
freqs :: String -> [Float]
freqs xs = [percent (count x xs) n | x <- ['a'..'z']]
	   where n = lowers xs

-- evaluates the chi-square statistic by comparing a list
-- of observed frequencies (os) and expected frequencies (es)
-- the lower the value the better better the match
chisqr :: [Float] -> [Float] -> Float
chisqr os es = sum [((o-e)^2)/e | (o,e) <- zip os es]

-- evaluates a left rotated list of a list
rotate :: Int -> [a] -> [a]
rotate n xs = drop n xs ++ take n xs

-- evaluate the position(s) of an element in a list
positions :: Eq a => a -> [a] -> [Int]
positions x xs = [i | (x',i) <- zip xs [0..], x == x']

-- evaluate the decoded Caesar cipher string
crack :: String -> String
crack xs = encode (-factor) xs
  where
     factor = head (positions (minimum chitab) chitab)
     chitab = [chisqr (rotate n table') table | n <- [0..25]]
     table' = freqs xs
