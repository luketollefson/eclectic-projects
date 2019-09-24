data Expr = Val Int | Add Expr Expr

data Code = HALT | PUSH Int Code | ADD Code

type Stack = [Int]

eval :: Expr -> Int
eval (Val n)   = n
eval (Add x y) = eval x + eval y

PUSH :: Int -> Code -> Code
ADD :: Code -> Code
HALT :: Code

comp' (Val n)   c = PUSH n c
comp' (Add x y) c = comp' x (comp' y (ADD c))

comp :: Expr -> Code
comp e = comp' e HALT

exec :: Code -> Stack -> Stack
exec HALT       s           = s
exec (PUSH n c) s           = exec c (n : s)
exec (ADD c)    (m : n : s) = exec c (n+m : s)
