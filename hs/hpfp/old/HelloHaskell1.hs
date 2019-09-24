sayHello :: String -> IO ()
sayHello x =
  putStrLn ("Hello, " ++ x ++ "!")

triple x = x * 3

half x = x / 2

square x = x * x

circleArea r = pi * square r

halfSquare x = half (square x)

perimeter x y = (x * 2) + (y * 2)

perimeter' x y = x * 2 + y * 2
