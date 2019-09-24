-- hutton.hs
module Hutton where

data Expr = Lit Integer | Add Expr Expr

eval :: Expr -> Integer
eval (Add e1 e2) = eval e1 + eval e2
eval (Lit i) = i

printExpr :: Expr -> String
printExpr (Add e1 e2) = printExpr e1 ++ " + " ++ printExpr e2
printExpr (Lit i)     = show i
