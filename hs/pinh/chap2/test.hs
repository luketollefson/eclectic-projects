{-
double x = x + x

quadruple x = double (double x)
-}		

-- Factorial of a positive integer:
factorial n = product [1..n]

-- Average of a list of integers:
average ns = sum ns `div` length ns

n = a `div` length xs
    where
        a = 10
        xs = [1,2,3,4,5]

-- last element of a non-empty list
mylast [x]    = x
mylast (x:xs) = mylast xs

-- last element of a non-empty list
mylast2 xs = head (reverse xs)

-- last element of a non-empty list
mylast3 xs = xs !! (length xs - 1)

-- all but last element of list
myinit [x]    = []
myinit (x:xs) = [x] ++ (myinit xs)

-- all but last element of a list
myinit2 xs = take (length xs - 1) xs
