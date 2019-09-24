-- practice.hs
module Mult1 where

mult1     = x * y
  where x = 5
        y = 6

mult2     = x * 3 + y
  where x = 3
        y = 1000

mult3     = x * 5
  where y = 10
        x = 10 * 5 + y

mult4     = z / x + y
  where x = 7
        y = negate x
        z = y * 10

z = 7
y = z + 8
x = y ^ 2
waxOn = x * 5

triple x = x * 3

waxOn'    = x * 5
  where x = y ^ 2
        y = z + 8
        z = 7

waxOff x = triple x

waxOff' x = ((triple x) ^ 2 / 10) + b + fwo
  where b = 933
        fwo = let j = 492 in j * 7
