-- sing.hs
module Sing where

fstString :: [Char] -> [Char]
fstString x = x ++ " in the rain"

sndString :: [Char] -> [Char]
sndString x = x ++ " did he come from?"

sing = if (x > y) then fstString x else sndString y
  where x = "Singin"
        y = "Where"
