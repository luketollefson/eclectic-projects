-- phone.hs
module Phone where

import Data.Maybe
import Data.List
import Data.Char

data DaPhone = DaPhone [(Char, [Char])]

cellPhone :: DaPhone
cellPhone = DaPhone [ ('1', ['1'])
                    , ('2', ['a', 'b', 'c', '2'])
                    , ('3', ['d', 'e', 'f', '3'])
                    , ('4', ['g', 'h', 'i', '4'])
                    , ('5', ['j', 'k', 'l', '5'])
                    , ('6', ['m', 'n', 'o', '6'])
                    , ('7', ['p', 'q', 'r', 's', '7'])
                    , ('8', ['t', 'u', 'v', '8'])
                    , ('9', ['w', 'x', 'y', 'z', '9'])
                    , ('*', ['*', '^'])
                    , ('0', ['+', ' ', '0'])
                    , ('#', ['.', ',', '#']) ]

convo :: [String]
convo = [ "Wanna play 20 questions"
        , "Ya"
        , "U 1st haha"
        , "Lol ok. Have u ever tasted alcohol"
        , "Lol ya"
        , "Wow ur cool haha. Ur turn"
        , "Ok. Do u think I am pretty Lol"
        , "Lol ya"
        , "Just making sure rofl ur turn" ]

-- validButtons = "1234567890*#"
type Digit = Char

-- Valid presses: 1 and up
type Presses = Int

-- this is TERRIBLE, poor use of Maybe
reverseTaps :: DaPhone -> Char -> [(Digit, Presses)]
reverseTaps p@(DaPhone phone) c = if isUpper c
                                  then reverseTaps p '*' ++ reverseTaps p (toLower c)
                                  else [(button, presses)] 
  where cIndex = fromJust $ findIndex (\(_, cs) -> c `elem` cs) phone
        button = fst $ phone !! cIndex
        presses = (+1) . fromJust $ elemIndex c (snd $ phone !! cIndex)

cellPhonesDead :: DaPhone -> String -> [(Digit, Presses)]
cellPhonesDead phone s = concat $ map (reverseTaps phone) s

fingerTaps :: [(Digit, Presses)] -> Presses
fingerTaps = sum . map snd

mostPopularLetter :: String -> Char
mostPopularLetter s = head . snd . last $ sortOn fst lettsAndLengths
  where sorted = sort s
        groups = group sorted
        lettsAndLengths = zip (map length groups) groups

coolestLtr :: [String] -> Char
coolestLtr = mostPopularLetter . concat

coolestWord :: [String] -> String
coolestWord ws = head . snd . last $ sortOn fst freq
  where sorted = sort ws
        groups = group sorted
        freq   = zip (map length groups) groups
