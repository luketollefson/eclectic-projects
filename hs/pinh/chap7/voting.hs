import Data.List

{- First Past the Post Election -}

votes :: [String]
votes = ["Red", "Blue", "Green", "Blue", "Blue", "Red"]

-- evaluate the number of times a value appears in a list
count :: Eq a => a -> [a] -> Int
count x = length . filter (== x)

-- evaluate a list of only unique values
rmdups :: Eq a => [a] -> [a]
rmdups []     = []
rmdups (x:xs) = x : filter (/= x) (rmdups xs)

-- evaluate the number of times all values appear in a list
result :: Ord a => [a] -> [(Int,a)]
result vs = sort [(count v vs, v) | v <- rmdups vs]

-- evaluate the winner in a FPTP election
winner :: Ord a => [a] -> a
winner = snd . last . result

{- Alternative Voting Election -}

ballots :: [[String]]
ballots = [["Red", "Green"],
	   ["Blue"],
	   ["Green", "Red", "Blue"],
	   ["Blue", "Green", "Red"],
	   ["Green"]]

-- evaluate a list of list without empty sublists
rmempty :: Eq a => [[a]] -> [[a]]
rmempty = filter (/= [])

-- evaluate a list with a value eliminated
elim :: Eq a => a -> [[a]] -> [[a]]
elim x = map (filter (/= x))

-- evaluate in acending order which head of ballots
-- was most to least voted for
rank :: Ord a => [[a]] -> [a]
rank = map snd . result . map head

winner' :: Ord a => [[a]] -> a
winner' bs = case rank (rmempty bs) of
		[c]    -> c
		(c:cs) -> winner' (elim c bs)
