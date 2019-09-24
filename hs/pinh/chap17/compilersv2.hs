-- Second definition of the compiler
-- This version makes manipulation of the
-- arguments explicit by using a stack

data Expr = Val Int | Add Expr Expr

type Stack = [Int]

push :: Int -> Stack -> Stack
push n s = n : s

add :: Stack -> Stack
add (m : n : s) = n+m : s

eval' :: Expr -> Stack -> Stack
eval' (Val n)   s = push n s
eval' (Add x y) s = add (eval' y (eval' x s))

eval :: Expr -> Int
eval e = head (eval' e [])

-- value is 28
expr :: Expr
expr = (Add (Add (Val 1) (Val 9))
            (Add (Val 2) (Add (Val 3) (Val 13))))
