{- Binary string transmitter -}

import Data.Char

type Bit = Int

{-
bin2int :: [Bit] -> Int
bin2int bits = sum [w*b | (w,b) <- zip weights bits]
	       where weights = iterate (*2) 1
-}

-- evaluate the integer for a little-endedness binary number list
bin2int :: [Bit] -> Int
bin2int = foldr (\x y -> x + 2*y) 0

-- evalute the binary number for an integer
int2bin :: Int -> [Bit]
int2bin 0 = []
int2bin n = n `mod` 2 : int2bin (n `div` 2)

-- evaluates an 8 bit list
make8 :: [Bit] -> [Bit]
make8 bits = take 8 (bits ++ repeat 0)

-- evalutes a list of 8 bit lists
chop8 :: [Bit] -> [[Bit]]
chop8 []   = []
chop8 bits = take 8 bits : chop8 (drop 8 bits)

-- evalute the bit stream of a string
encode :: String -> [Bit]
encode = concat . map (make8 . int2bin . ord)

-- evaluate the string by the bits
decode :: [Bit] -> String
decode = map (chr . bin2int) . chop8

-- evaluate a transmition
transmit :: String -> String
transmit = decode . channel . encode

-- evaluate the channel that is used for transmition
channel :: [Bit] -> [Bit]
channel = id
