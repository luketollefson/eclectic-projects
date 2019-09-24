-- learn.hs
module Learn where

x = 10 * 5 + y
x' = 10
  * 5 + y

myResult = x * 5

y = 10

foo x =
  let y = x * 2
      z = x ^ 2
  in 2 * y * z

{- Heal the sick
1)
area x = 3.14 * (x * x)
2)
double x = x * 2
3)
x = 7
y = 10
f = x + y
-}

{- laws for quotients and remainders
(quot x y)*y + (rem x y) == x
(div x y)*y + (mod x y) == x
-}
