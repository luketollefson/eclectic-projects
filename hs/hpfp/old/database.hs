-- database.hs
module Database where

import Data.Time

data DatabaseItem = DbString String | DbNumber Integer | DbDate UTCTime
  deriving (Eq, Ord, Show)

theDatabase :: [DatabaseItem]
theDatabase =
  [ DbDate (UTCTime (fromGregorian 1911 5 1) (secondsToDiffTime 34123))
  , DbNumber 9001
  , DbString "Hello, world!"
  , DbDate (UTCTime (fromGregorian 1921 5 1) (secondsToDiffTime 34123))
  ]

filterDbDate :: [DatabaseItem] -> [UTCTime]
filterDbDate db = foldr onlyTimes [] db
  where onlyTimes a b = case a of (DbDate t) -> t : b
                                  _          -> b

filterDbDate' :: [DatabaseItem] -> [UTCTime]
filterDbDate' [] = []
filterDbDate' ((DbDate t):xs) = t : filterDbDate' xs
filterDbDate' (_:xs) = filterDbDate' xs

filterDbNumber :: [DatabaseItem] -> [Integer]
filterDbNumber db = foldr onlyNumbers [] db
  where onlyNumbers a b = case a of (DbNumber n) -> n : b
                                    _            -> b

mostRecent :: [DatabaseItem] -> UTCTime
mostRecent db = maximum $ filterDbDate db

sumDb :: [DatabaseItem] -> Integer
sumDb = sum . filterDbNumber

averageDb :: [DatabaseItem] -> Double
averageDb db = (fromIntegral $ sum dbNs) / (fromIntegral $ length dbNs)
  where dbNs = filterDbNumber db
