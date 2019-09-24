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

-- evalutes a list of n bit lists
chop :: Int -> [Bit] -> [[Bit]]
chop _ []   = []
chop n bits = take n bits : chop n (drop n bits)

-- evaluate a string of digits with a parity on the front
addparity :: [Bit] -> [Bit]
addparity xs | (odd . sum) xs = 1 : xs
	     | otherwise      = 0 : xs

-- evalute the bit stream of a string
encode :: String -> [Bit]
encode = concat . map (addparity . make8 . int2bin . ord)

rmparity :: [Bit] -> [Bit]
rmparity xs | length xs /= 9  = error "Bad length"
	    | (even . sum) xs = tail xs
	    | otherwise       = error "Incorrect parity"

-- evaluate the string by the bits
decode :: [Bit] -> String
decode = map (chr . bin2int) . map rmparity . chop 9

-- evaluate a transmition
transmit :: String -> String
transmit = decode . channel . encode

-- evaluate the channel that is used for transmition
channel :: [Bit] -> [Bit]
channel = id
