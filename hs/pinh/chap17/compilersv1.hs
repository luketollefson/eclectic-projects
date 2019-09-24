-- First defintion of the compiler
-- This establishes syntax and semantics
-- for what will be a compiler and
-- virtual machine

data Expr = Val Int | Add Expr Expr

eval :: Expr -> Int
eval (Val n) = n
eval (Add x y) = eval x + eval y

-- value is 28
expr :: Expr
expr = (Add (Add (Val 1) (Val 9))
            (Add (Val 2) (Add (Val 3) (Val 13))))

