-- Forth definition of the compiler
-- This step transforms evaluation
-- back into first-order style using
-- defunctionalisation

data Expr = Val Int | Add Expr Expr

data Code = HALT | PUSH Int Code | ADD Code
            deriving Show

type Stack = [Int]

-- Compile the Expr into Code
comp :: Expr -> Code
comp e = comp' e HALT

comp' :: Expr -> Code -> Code
comp' (Val n)   c = PUSH n c
comp' (Add x y) c = comp' x (comp' y (ADD c))

-- Execute code using a stack
exec :: Code -> Stack -> Stack
exec HALT       s 	    = s
exec (PUSH n c) s 	    = exec c (n : s)
exec (ADD c)    (m : n : s) = exec c (n+m : s)

-- Evaluate expr by compiling it first, then 
-- running the code on a virtual machine
eval :: Expr -> Int
eval e = head (exec (comp e) [])

-- value is 28
expr :: Expr
expr = (Add (Add (Val 1) (Val 9))
            (Add (Val 2) (Add (Val 3) (Val 13))))
