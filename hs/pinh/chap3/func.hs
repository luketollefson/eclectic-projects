add :: (Int,Int) -> Int
add (x,y) = x+y

zeroto :: Int -> [Int]
zeroto n = [0..n]

add' :: Int -> (Int -> Int)
add' x y = x+y

mult :: Int -> (Int -> (Int -> Int))
mult x y z = x*y*z

inc :: Int -> Int
inc = add' 1

bools = [False,True]

nums = [[1,2,3],[4,5,6]]

add'' :: Int -> Int -> Int -> Int
add'' x y z = x+y+z

copy :: a -> (a,a)
copy x = (x,x)

apply :: (a -> b) -> a -> b
apply f x = f x

second :: [a] -> a
second xs = head (tail xs)

swap :: (a, b) -> (b, a)
swap (x,y) = (y,x)

pair x y = (x,y)

double :: Num a => a -> a
double x = x*2

palindrome xs = reverse xs == xs

twice f x = f (f x)
