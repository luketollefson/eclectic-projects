-- greetIfCool1.hs
module GreetIfCool1 where

{-
greetIfCool :: String -> IO ()
greetIfCool coolness =
  if cool
     then putStrLn "eyyy. What's shakin'?"
  else
    putStrLn "pshhh."
  where cool =
          coolness == "downright frosty you"
-}

greetIfCool :: String -> IO ()
greetIfCool coolness =
  if cool coolness
     then putStrLn "eyyy. What's shakin'?"
  else
    putStrLn "pshhh."
  where cool v =
          v == "downright frosty you"
