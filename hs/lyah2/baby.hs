doubleMe x = x + x

-- doubleUs x y = x * 2 + y * 2

doubleUs x y = doubleMe x + doubleMe y

doubleSmallNumber x = if x > 100
                      then x
                      else x*2

doubleSmallNumber' x = (if x > 100 then x else x*2) + 1

conanO'Brien = "It's a-me, Conan O'Brien!"

boomBangs xs = [if x < 10 then "BOOM!" else "BANG!" | x <- xs, odd x]
                
legnth' xs = sum [1 | _ <- xs]

removeNonUppercase :: [Char] -> [Char]
removeNonUppercase st = [c | c <- st, c `elem` ['A'..'Z']]

triples = [(a,b,c) | c <- [1..10],
           a <- [1..c],
           b <- [1..a],
           c^2 == a^2 + b^2,
           a+b+c == 24]

addThree :: Int -> Int -> Int -> Int
addThree x y z = x + y + z

factorial :: Integer -> Integer
factorial n = product [1..n]

circumference :: Float -> Float
circumference r = 2 * pi * r

lucky :: Int -> String
lucky 7 = "LUCKY NUMBER SEVEN!"
lucky x = "Sorry, your out of luck, pal!"

factorial' :: Int -> Int
factorial' 0 = 1
factorial' n = n * factorial' (n - 1)

addVectors :: (Double, Double) -> (Double, Double) -> (Double, Double)
addVectors (x1, y1) (x2, y2) = (x1 + x2, y1 + y2)

firstLetter :: String -> String
firstLetter "" = "Empty string, whops!"
firstLetter all@(x:xs) = "The first letter of " ++ all ++ " is " ++ [x]

-- bmiTell :: Double -> String
-- bmiTell bmi
--   | bmi <= 18.5 = "You're underweight"
--   | otherwise   = "ofjwof"

myCompare :: (Ord a) => a -> a -> Ordering
a `myCompare` b
  | a == b    = EQ
  | a <= b    = LT
  | otherwise = GT

bmiTell :: Double -> Double -> String
bmiTell weight height
  | bmi <= 18.5 = "jofiwj"
  | bmi <= 42   = " jfwo"
  | bmi <= 43.2 = "fowj"
  | otherwise   = "ofijw"
  where bmi = weight / height ^ 2
        skinny = 94

initials :: String -> String -> String
initials firstname lastname = [f] ++ ". " ++ [l] ++ "."
  where (f:_) = firstname
        (l:_) = lastname

cylinder :: Double -> Double -> Double
cylinder r h =
  let sideArea = 2 * pi * r * h
      topArea  = pi * r ^ 2
  in  sideArea + 2 * topArea

calcBmis :: [(Double, Double)] -> [Double]
calcBmis xs = [bmi | (w, h) <- xs, let bmi = w / h ^ 2, bmi > 25.0]

describeList :: [a] -> String
describeList ls = "The list is " ++ case ls of [] -> "empty."
                                               [x] -> "a singleton list."
                                               xs -> "a longer list."
