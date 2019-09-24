-- evalaute the total of an input
adder :: IO ()
adder  = do putStr "How many numbers? "
	    noints <- getLine
	    ints <- getInts (read noints :: Int)
	    putStr "The total is "
	    putStrLn (show (sum ints))

getInts :: Int -> IO [Int]
getInts n = if n > 0 then
	       do int <- getLine
		  ints <- getInts (n - 1)
		  return ((read int :: Int):ints)
	    else
	       do return []

adder' :: IO ()
adder' = do putStr "How many numbers? "
	    noints <- getLine
	    ints <- sequence [getInt | _ <- [1..(read noints :: Int)]]
	    putStr "The total is "
	    putStrLn (show (sum ints))

getInt :: IO Int
getInt = do int <- getLine
	    return (read int :: Int)

