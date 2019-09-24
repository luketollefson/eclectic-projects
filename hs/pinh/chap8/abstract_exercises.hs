data Expr = Val Int | Add Expr Expr | Mult Expr Expr

data Op = EVALA Expr | EVALM Expr | ADD Int | MULT Int
type Cont = [Op]

eval :: Expr -> Cont -> Int
eval (Val n)   c = exec c n
eval (Add x y) c = eval x (EVALA y : c)
eval (Mult x y) c = eval x (EVALM y : c)

exec :: Cont -> Int -> Int
exec []           n = n
exec (EVALA y : c) n = eval y (ADD n : c)
exec (EVALM y : c) n = eval y (MULT n : c)
exec (ADD n : c)  m = exec c (n+m)
exec (MULT n : c) m = exec c (n*m)

value :: Expr -> Int
value e = eval e []

v :: Expr
v = Add (Add (Val 2) (Val 3)) (Val 4)
v2 :: Expr
v2 = Mult (Val 5) (Val 3)

-- evaluate the Expr with Val replaced with f and
-- Add replaced with g
folde :: (Int -> a) -> (a -> a -> a) -> Expr -> a
folde f g (Val v)     = f v
folde f g (Add e1 e2) = g (folde f g e1) (folde f g e2)

eval' :: Expr -> Int
eval' = folde id (+)

size :: Expr -> Int
size = folde (const 1) (+)
