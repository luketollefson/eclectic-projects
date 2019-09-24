test :: [Int] -> [Int]
test [] = []
test [x] = y : [x]
test (x:xs) = y : x : xs
	      where y = 5
