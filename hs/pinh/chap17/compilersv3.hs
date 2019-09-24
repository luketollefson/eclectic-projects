-- Third definition of the compiler
-- This step tansforms the stack-based
-- evaluation function into continuation-
-- passing style. Makes flow control explicit

data Expr = Val Int | Add Expr Expr

type Stack = [Int]

type Cont = Stack -> Stack

push :: Int -> Stack -> Stack
push n s = n : s

add :: Stack -> Stack
add (m : n : s) = n+m : s

eval'' :: Expr -> Cont -> Cont
eval'' (Val n)   c s = c (push n s)
eval'' (Add x y) c s = eval'' x (eval'' y (c . add)) s

eval' :: Expr -> Cont
eval' e s = eval'' e id s

eval :: Expr -> Int
eval e = head (eval' e [])

-- value is 28
expr :: Expr
expr = (Add (Add (Val 1) (Val 9))
            (Add (Val 2) (Add (Val 3) (Val 13))))
